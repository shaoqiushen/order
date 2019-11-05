package com.shanyuan.alipayorderportal.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shanyuan.alipayorderportal.config.ServerConfig;
import com.shanyuan.alipayorderportal.dao.PortalOrderDao;
import com.shanyuan.alipayorderportal.domain.*;
import com.shanyuan.alipayorderportal.dto.PayOrderDetailsResult;
import com.shanyuan.alipayorderportal.dto.PortalPayParams;
import com.shanyuan.alipayorderportal.service.*;
import com.shanyuan.common.domain.AlipayTradeParams;
import com.shanyuan.common.domain.AlipayTradeResult;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.domain.ItemOrderDetail;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.common.exception.DescribeException;
import com.shanyuan.common.service.AlipayService;
import com.shanyuan.common.utils.HttpUtils;
import com.shanyuan.common.utils.MathUtils;
import com.shanyuan.common.utils.MyDateUtil;
import com.shanyuan.mapper.*;
import com.shanyuan.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-18 9:58
 * <p>
 * desc
 **/
@Slf4j
@Service
public class PortalPayServiceImpl implements PortalPayService {

    @Autowired
    PortalOrderService portalOrderService;

    @Autowired
    PortalUserService portalUserService;

    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Autowired
    ErrorOrderMapper errorOrderMapper;

    @Autowired
    AlipayService alipayService;

    @Autowired
    OmsOrderDetailMapper omsOrderDetailMapper;

    @Autowired
    OmsPrepayMapper omsPrepayMapper;

    @Autowired
    PortalOrderDao portalOrderDao;

    @Autowired
    ServerConfig serverConfig;

    @Autowired
    PmsItemMapper pmsItemMapper;

    @Autowired
    SerialNumberService serialNumberService;

    @Autowired
    PortalSystemFeeService portalSystemFeeService;



    @Override
    public CommonResult payBuy(PortalPayParams params) {
        try {

            //判断用户
            //查询用户支付宝id
            UmsUser userInfo=portalUserService.getUserInfo( params.getUserId() );
            if (userInfo == null) {
                return new CommonResult().error( ExceptionEnum.USER_NOT_EXISTS );
            }
            //判断订单状态
            OmsOrder orderInfo=portalOrderService.getOrderInfo( params.getOrderId() );
            if (orderInfo == null) {
                return new CommonResult().error( ExceptionEnum.ORDER_NOT_EXISTS );
            } else {
                if (orderInfo.getOrderStatus() != 0) {
                    return new CommonResult().error( ExceptionEnum.ORDER_STATUS_ERROR );
                }
            }

            //调用支付接口生成预支付信息
            AlipayTradeParams tradeParams=new AlipayTradeParams();
            //回调地址
            tradeParams.setUrl( serverConfig.getMyaddr() + "/pay/alipayNotify" );
            tradeParams.setBody( params.getBody() );
            tradeParams.setBuyer_id( String.valueOf( userInfo.getAliUserId() ) );
            tradeParams.setOut_trade_no( String.valueOf( params.getOrderId() ) );
            tradeParams.setSubject( params.getSubject() );
            tradeParams.setAppid( params.getAppid() );

            Integer payAmount=orderInfo.getPayAmount();
            int eatAmount = 0;

            if (orderInfo.getOrderType() == 0) {
                //配送到家
                tradeParams.setFood_order_type( "home_delivery " );
                tradeParams.setExtend_params( 000 );
                //查询配送费用
                Integer delivery=portalSystemFeeService.getDelivery( orderInfo.getBrandId(), orderInfo.getStoreId() );
                delivery = delivery== null?0:delivery;
                orderInfo.setFreightAmount( delivery );
                //查询包装费用
                Integer aPackage=portalSystemFeeService.getPackage( orderInfo.getBrandId(), orderInfo.getStoreId() );
                aPackage = aPackage == null?0:aPackage;
                orderInfo.setPackageMoney( aPackage );
                orderInfo.setTotalAmount( orderInfo.getTotalAmount()+delivery+aPackage );
                orderInfo.setPayAmount( payAmount+delivery+aPackage );
                //重置为0
                payAmount =0;
            } else if (orderInfo.getOrderType() == 1) {
                //扫码点餐
                tradeParams.setFood_order_type( "qr_order" );
                tradeParams.setExtend_params( 101 );
                Integer tableMoneyPer=portalSystemFeeService.getTableMoney( orderInfo.getBrandId(), orderInfo.getStoreId() );
                tableMoneyPer = tableMoneyPer==null?0:tableMoneyPer;
                if(tableMoneyPer != null){
                    eatAmount=tableMoneyPer * params.getEatPeopleAmount();
                    //重新设置订单价格
                    orderInfo.setPayAmount( payAmount+ eatAmount);
                    //重置为0
                    payAmount = 0;
                    orderInfo.setTotalAmount( orderInfo.getTotalAmount()+eatAmount );
                    orderInfo.setEatPeopleAmount( params.getEatPeopleAmount() );
                    orderInfo.setTableMoney( eatAmount );
                    //重置为0
                    eatAmount = 0;
                }

            }
            //设置订单备注
            orderInfo.setNotes( params.getNotes() );
            //最终需要支付的价格
            //单位元
            // 分----->>>>元
            String totalAmount=String.valueOf( MathUtils.getTwoBitValue( String.valueOf( ( double )(orderInfo.getPayAmount())  / 100 ) ) );
            tradeParams.setTotal_amount( totalAmount );
            tradeParams.setStore_id( String.valueOf( orderInfo.getStoreId() ) );
            tradeParams.setType( 1 );
            tradeParams.setApp( "2001" );
            //组装订单详情
            tradeParams.setGoods_detail( getOrderDetails( orderInfo.getOrderId() ) );
            //调用支付宝统一下单服务---->>>返回预支付信息
            AlipayTradeResult trade=alipayService.createTrade( tradeParams );
            if (trade.getStatus() == 1) {
                //预支付信息入库
                OmsPrepay omsPrepay=new OmsPrepay();
                omsPrepay.setCreateTime( new Date() );
                omsPrepay.setOrderId( orderInfo.getOrderId() );
                omsPrepay.setTradeNo( trade.getData().getTrade_no() );
                omsPrepay.setPayAmount( orderInfo.getPayAmount() );
                insertOrderPre( omsPrepay );

                //修改支付标志
                updatePayFlag( orderInfo );

                return new CommonResult().success( trade.getData() );
            }

            return new CommonResult().failed( "支付失败:" + trade.getMsg() );

        } catch ( Exception e ) {
            log.error( "payBuy error{}", e );
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new DescribeException( ExceptionEnum.PAY_ERROR );
        }
    }

    private void insertOrderPre(OmsPrepay omsPrepay) {
        omsPrepayMapper.insert( omsPrepay );
    }

    private void updatePayFlag(OmsOrder omsOrder) {
//        OmsOrder omsOrder=new OmsOrder();
        omsOrder.setPayFlag( 1 );
        omsOrder.setUpdateTime( new Date(  ) );
//        omsOrder.setNotes( notes );
        OmsOrderExample example=new OmsOrderExample();
//        example.createCriteria().andOrderIdEqualTo( orderId );
        omsOrderMapper.updateByPrimaryKeySelective( omsOrder );
    }

    private List <ItemOrderDetail> getOrderDetails(Long orderId) {
        List <ItemOrderDetail> goodsDetailList=new ArrayList <>();
        List <PayOrderDetailsResult> orderDetails=portalOrderDao.getOrderDetails( orderId );
        ItemOrderDetail goodsDetail=null;
        if (orderDetails.size() > 0) {
            for (PayOrderDetailsResult omsOrderDetail : orderDetails) {
                goodsDetail=new ItemOrderDetail();
                goodsDetail.setGoods_id( String.valueOf( omsOrderDetail.getItemId() ) );
                goodsDetail.setGoods_name( omsOrderDetail.getItemName() );
                goodsDetail.setPrice( String.valueOf( MathUtils.getTwoBitValue( ( double ) omsOrderDetail.getPrice() / 100 + "" ) ) ); //单位元
                goodsDetail.setQuantity( omsOrderDetail.getBuyCount() );
                goodsDetailList.add( goodsDetail );
            }
        }
        return goodsDetailList;
    }

    @Override
    public void alipayNotify(String trade_no, String out_trade_no) {
        ErrorOrder errorOrder=new ErrorOrder();
        OmsOrder omsOrder=null;
        SycnOrderParams sycnOrderParams=new SycnOrderParams();
        List <ItemOrderList> itemOrderLists=new ArrayList <>();
        String mealNo="";//取餐号
        try {
            //校验订单信息
            OmsOrderExample example=new OmsOrderExample();
            example.createCriteria().andOrderIdEqualTo( Long.parseLong( out_trade_no ) );
            List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
            int count=0;
            if (omsOrders.size() > 0) {
//                if(trade_no.equals( omsOrders.get( 0 ).getTradeNo() )){
                //假如流水号相同，则是合法数据//修改支付状态
                omsOrder=omsOrders.get( 0 );

//                }
                mealNo=serialNumberService.generate( String.valueOf( omsOrder.getBrandId() ),String.valueOf( omsOrder.getStoreId() ) );
                OmsOrderDetailExample detailExample=new OmsOrderDetailExample();
                detailExample.createCriteria().andOrderIdEqualTo( Long.parseLong( out_trade_no ) );

                List <OmsOrderDetail> orderDetailList=omsOrderDetailMapper.selectByExample( detailExample );
                List <Integer> list=new ArrayList <>();


                List <ExtInfo> extInfoList=new ArrayList <>();
                List <ExtInfo> extInfoList1=new ArrayList <>();
                if (orderDetailList.size() > 0) {
                    for (OmsOrderDetail detail : orderDetailList) {
                        Integer itemId=detail.getItemId();
                        //查商品extinfo
                        PmsItem pmsItem=pmsItemMapper.selectByPrimaryKey( itemId );
                        double twoBitValue=MathUtils.getTwoBitValue( String.valueOf( ( double ) omsOrder.getPayAmount() / 100 ) );
                        sycnOrderParams.setAmount( String.valueOf( twoBitValue ) );
                        sycnOrderParams.setBuyer_id( omsOrder.getBuyerId() );
                        sycnOrderParams.setTrade_no( trade_no );
                        sycnOrderParams.setOut_trade_no( String.valueOf( omsOrder.getOrderId() ) );
                        ItemOrderList itemOrder=new ItemOrderList();
                        itemOrder.setItem_id( String.valueOf( itemId ) );
                        itemOrder.setItem_name( pmsItem.getItemName() );
                        itemOrder.setQuantity( detail.getBuyCount() );
                        itemOrder.setSku_id( String.valueOf( detail.getSkuId() ) );
                        itemOrder.setUnit_price( MathUtils.getTwoBitValue( String.valueOf( ( double ) detail.getPrice() / 100 ) ) );
                        itemOrder.setSp1( detail.getSp1() );
                        itemOrder.setSp2( detail.getSp2() );
                        itemOrder.setSp3( detail.getSp3() );
                        JSONArray objects=JSONObject.parseArray( pmsItem.getExtInfo() );
                        JSONObject jo=new JSONObject();
                        jo.put( "ext_key", "image_material_id" );
                        jo.put( "ext_value", pmsItem.getMaterialId() );
                        objects.add( jo );
                        extInfoList=objects.toJavaList( ExtInfo.class );
                        itemOrder.setExt_info( extInfoList );
                        itemOrderLists.add( itemOrder );
                    }
                    ExtInfo extInfo2=new ExtInfo();
                    extInfo2.setExt_key( "merchant_order_link_page" );
                    extInfo2.setExt_value( "/pages/order/detail/detail?id=" + out_trade_no );
                    extInfoList1.add( extInfo2 );
                    sycnOrderParams.setExt_info( JSONObject.toJSONString( extInfoList1 ) );
                    sycnOrderParams.setItem_order_list( JSONObject.toJSONString( itemOrderLists ) );
                    sycnOrderParams.setAppid( String.valueOf( omsOrder.getBrandId() ) );
                }
                //阿里订单同步
                SycnOrderResponse sycnOrderResponse=syscronOrder( sycnOrderParams );
                if (sycnOrderResponse.getStatus() == 1) {
                    //同步成功
                    omsOrder.setOrderSyncId( sycnOrderResponse.getData().getOrder_sync_id() );
                }

                omsOrder.setOrderStatus( 1 );//修改为已支付
                omsOrder.setPaymentTime( new Date() );
                omsOrder.setTradeNo( trade_no );
                omsOrder.setMealNo( mealNo );
                //修改订单状态
                count=omsOrderMapper.updateByPrimaryKeySelective( omsOrder );

                //打印小票
                PrintRepects repects=new PrintRepects();
                if (omsOrder != null) {
                    repects.setAppid( String.valueOf( omsOrder.getBrandId() ) );
                    repects.setOrigin_id( out_trade_no );
                    printReceipts( repects, itemOrderLists, omsOrder );
                }
            }
            if (count < 1) {
                throw new DescribeException( ExceptionEnum.PAY_CALLBACK_ERROR );
            }
        } catch ( Exception e ) {
            //异常则记录异常信息//方便人工修改
            log.error( "alipayNotify error{}", e );
            log.error( "alipayNotify 修改订单状态失败,需人工介入修改: 订单: {},流水号: {}", out_trade_no, trade_no );
            errorOrder.setOrderId( Long.parseLong( out_trade_no ) );
            errorOrder.setReason( "订单已经回调，修改状态出现逻辑错误，人工介入修改" );
            errorOrder.setTradeNo( trade_no );
            errorOrder.setCreateTime( new Date() );
            errorOrder.setMealNo( mealNo );
            errorOrderMapper.insertSelective( errorOrder );
        } finally {
        }
    }

    private void printReceipts(PrintRepects repects, List <ItemOrderList> itemOrderLists, OmsOrder omsOrder) {
        String content="<FS2><center>**"+omsOrder.getStoreName()+"**</center></FS2>";
        if (omsOrder.getOrderType() == 0) {
            //外卖配送
            content+="<FS><center>--外卖配送--</center></FS>";
            content+="................................\n";
            content+="<FS>收货地址:" + omsOrder.getReceiverAddress() + "</FS>\n";
            content+="<FS>收货人:" + omsOrder.getReceiverName() + "</FS>\n";
            content+="<FS>联系方式:" + omsOrder.getReceiverPhone() + "</FS>\n";
            content+="<FS>买家留言：" + "<table><tr><td>" + omsOrder.getNotes() + "</td></tr></table></FS>";
            content+="\n................................\n";
        } else if (omsOrder.getOrderType() == 1) {
            //扫码点餐
            content+="<FS><center>桌号：" + omsOrder.getDeskNo() + "   " + "取餐号：" + omsOrder.getMealNo() + "</center></FS>\n";
            content+="<FS>买家留言：" + omsOrder.getNotes() + "</FS>\n";
            content+="................................\n";
        }
        content+="<FS><center>--支付宝在线支付--</center></FS>\n";
        content+="................................\n";
        content+="订单时间:" + MyDateUtil.DateTransToString( omsOrder.getCreateTime() ) + "\n";
        content+="订单编号:" + omsOrder.getOrderId() + "\n";
        content+="**************商品**************\n";
        content+="<table>";
        content+="<tr><td>名称</td><td>数量</td><td>价格</td></tr>";
        double preAmount=0d;
        double discount=0d;
        //遍历组装订单产品信息
        for (ItemOrderList orderList : itemOrderLists) {
            preAmount+=orderList.getQuantity() * orderList.getUnit_price();
            content+="<tr><td>" + orderList.getItem_name() + "(" + orderList.getSp1() + "+" + orderList.getSp2() + "+" + orderList.getSp3() + ")" + "</td><td>" + "x" + orderList.getQuantity() + "</td><td>" + orderList.getUnit_price() + "</td></tr>";
        }
        content+="</table>";
        content+="................................\n";
        content+="小计:￥" + MathUtils.getTwoBitValue( String.valueOf( preAmount ) ) + "\n";
        content+="折扣:￥" + MathUtils.getTwoBitValue( String.valueOf( discount ) ) + "\n";
        content+="********************************\n";
        content+="<FS>订单总价:￥" + MathUtils.getTwoBitValue( String.valueOf( preAmount - discount ) ) + "\n\n</FS>";
        content+="<center>**谢谢惠顾**</center>";
        content+="<center>**山园科技提供技术支持**</center>\n";
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append( "appid=" + repects.getAppid() ).append( "&content=" + content ).append( "&origin_id=" + repects.getOrigin_id() );
        //调用打印服务
        String response=HttpUtils.getResponse( serverConfig.getPrintaddr() + "/yly/print", stringBuffer.toString() );
        log.info( "print response info{}", response );
    }

    private SycnOrderResponse syscronOrder(SycnOrderParams params) {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append( "amount=" + params.getAmount() ).append( "&app=" + params.getApp() ).append( "&appid=" + params.getAppid() ).append( "&buyer_id=" + params.getBuyer_id() ).append( "&ext_info=" + params.getExt_info() ).append( "&item_order_list=" + params.getItem_order_list() ).append( "&trade_no=" + params.getTrade_no() ).append( "&type=" + params.getType() ).append( "&out_trade_no=" + params.getOut_trade_no() );
        log.info( "syscronOrder start{}", JSONObject.toJSONString( stringBuffer ) );
        String response=HttpUtils.getResponse( serverConfig.getServeraddr() + "/order/ordersync", stringBuffer.toString() );
        log.info( "syscronOrder {}", response );
        SycnOrderResponse serverResponse=JSONObject.parseObject( response, SycnOrderResponse.class );
        return serverResponse;
    }

    @Override
    public OmsPrepay payAgain(Long orderId) {
        OmsPrepayExample example=new OmsPrepayExample();
        example.createCriteria().andOrderIdEqualTo( orderId );
        List <OmsPrepay> omsPrepays=omsPrepayMapper.selectByExample( example );
        if (omsPrepays.size() > 0) {
            return omsPrepays.get( 0 );
        }
        return null;
    }
}
