package com.shanyuan.alipayorderportal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.dao.PortalOrderDao;
import com.shanyuan.alipayorderportal.domain.CartParam;
import com.shanyuan.alipayorderportal.dto.PortalOrderDetailResult;
import com.shanyuan.alipayorderportal.dto.PortalOrderParams;
import com.shanyuan.alipayorderportal.dto.PortalOrderQueryParams;
import com.shanyuan.alipayorderportal.dto.PortalOrderQueryResult;
import com.shanyuan.alipayorderportal.service.PortalItemService;
import com.shanyuan.alipayorderportal.service.PortalOrderService;
import com.shanyuan.alipayorderportal.service.PortalStoreService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.common.exception.DescribeException;
import com.shanyuan.common.factory.SnowFlakeFactory;
import com.shanyuan.common.utils.DelayUtil;
import com.shanyuan.mapper.OmsOrderDetailMapper;
import com.shanyuan.mapper.OmsOrderMapper;
import com.shanyuan.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 11:44
 * <p>
 * desc
 **/
@Service
@Slf4j
public class PortalOrderServiceImpl implements PortalOrderService {

    @Autowired
    PortalCartServiceImpl portalCartService;

    @Autowired
    PortalItemService portalItemService;

    @Autowired
    PortalUserServiceImpl portalUserService;

    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Autowired
    PortalOrderDao portalOrderDao;

    @Autowired
    OmsOrderDetailMapper omsOrderDetailMapper;

    @Autowired
    DelayUtil delayUtil;

    @Autowired
    PortalStoreService portalStoreService;


    @Override
    public CommonResult create(PortalOrderParams params) {
        try {
//            List <OmsCart> cartInfo=portalCartService.getCartInfo( params.getStoreId(), params.getUserId() );
            UmsUser userInfo=portalUserService.getUserInfo( params.getUserId() );
            if (userInfo == null) {
                return new CommonResult().error( ExceptionEnum.USER_NOT_EXISTS );
            }
            if (params.getCartParamList().size() == 0) {
                return new CommonResult().failed( "购物车不允许为空" );
            }

            CmsStore storeInfo=portalStoreService.getStoreInfo( params.getStoreId() );
            if(storeInfo == null){
                return new CommonResult().error( ExceptionEnum.STORE_NOT_EXISTS );
            }

            //查询产品信息
            List <PmsItemSku> skuInfo=portalItemService.getSkuInfo( params.getCartParamList() );

            int totalAmount=0;
            long orderId=SnowFlakeFactory.getInstance().getId();
            List <OmsOrderDetail> orderDetailList=new ArrayList <>();
            List <Integer> cartIds=new ArrayList <>();

            if (skuInfo.size() == 0) {
                return new CommonResult().failed( "商品不存在" );
            } else {
                one:
                for (CartParam cart : params.getCartParamList()) {
                    for (PmsItemSku sku : skuInfo) {
                        if (cart.getSkuId() == sku.getId()) {
                            totalAmount+=sku.getPrice() * cart.getBuyCount();
                            OmsOrderDetail orderDetail=new OmsOrderDetail();
                            orderDetail.setSp3( sku.getSp3() );
                            orderDetail.setSp2( sku.getSp2() );
                            orderDetail.setSp1( sku.getSp1() );
                            orderDetail.setBuyCount( cart.getBuyCount() );
                            orderDetail.setPrice( sku.getPrice() );
                            orderDetail.setItemId( sku.getItemId() );
                            orderDetail.setOrderId( orderId );
                            orderDetail.setSkuId( sku.getId() );
                            orderDetailList.add( orderDetail );
                        }
                    }
                }
            }
            if (orderDetailList.size() == 0) {
                return new CommonResult().failed( "查询不到相应的产品信息" );
            }
            UmsAddress userAddr=new UmsAddress();

            if (params.getOrderType() == 1) {
                //扫码点餐时//不做处理
            } else if (params.getOrderType() == 0) {
                //线上点餐时
                //查询用户地址
                userAddr=portalUserService.getUserAddr( params.getAddressId() );
                if (StringUtils.isEmpty( userAddr )) {
                    return new CommonResult().failed( "用户收货地址不存在" );
                }
            } else {
                return new CommonResult().failed( "订单类型不正确" );
            }

            //订单主表入库
            OmsOrder omsOrder=new OmsOrder();
            int freeAmount=0;
            omsOrder.setOrderStatus( 0 );
            omsOrder.setPayAmount( totalAmount - freeAmount );
            omsOrder.setTotalAmount( totalAmount );
            omsOrder.setOrderId( orderId );
            omsOrder.setReceiverAddress( userAddr.getArea() == null ? "" : userAddr.getArea() + userAddr.getAddress() == null ? "" : userAddr.getAddress() );
            omsOrder.setReceiverName( userAddr.getReceiver() == null ? "" : userAddr.getReceiver() );
            omsOrder.setReceiverPhone( userAddr.getTelephone() == null ? "" : userAddr.getTelephone() );
            omsOrder.setUserId( params.getUserId() );
            omsOrder.setStoreName( storeInfo.getStoreName() );
            omsOrder.setStoreId( params.getStoreId() );
            omsOrder.setFreightAmount( 0 );
            omsOrder.setCreateTime( new Date() );
            omsOrder.setFreeAmount( freeAmount );
            omsOrder.setOrderType( params.getOrderType() );
            omsOrder.setDeskNo( params.getDeskNo() == null ? "" : params.getDeskNo() );
            omsOrder.setBrandId( params.getBrandId() );
            omsOrder.setBuyerId( String.valueOf( userInfo.getAliUserId() ) );
            this.insertOrder( omsOrder );

            //订单详情表入库
            this.insertOrderDetail( orderDetailList );
            Map <String, Long> resultMap=new HashMap <>();
            resultMap.put( "orderId", orderId );
            //清空购物车
//            portalCartService.deleteCart( cartIds );

            //推送队列
            //30分钟后未支付则关闭
            delayUtil.putDelay( 30 * 60 * 1000, orderId );
            return new CommonResult().success( "下单成功", resultMap );
        } catch ( Exception e ) {
            log.error( "create order error{}", e );
            throw new DescribeException( ExceptionEnum.CREATE_ORDER_ERROR );
        }

    }

    @Override
    public int deleteOrder(Long orderId) {
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andOrderIdEqualTo( orderId );
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setDeleteStatus( 1 );
        return omsOrderMapper.updateByExampleSelective(omsOrder, example );
    }

    @Override
    public int insertOrder(OmsOrder omsOrder) {
        return omsOrderMapper.insertSelective( omsOrder );
    }

    @Override
    public int insertOrderDetail(List <OmsOrderDetail> omsOrderDetails) {
        return portalOrderDao.insertOrderDetail( omsOrderDetails );
    }

    @Override
    public OmsOrder getOrderInfo(Long orderId) {
        OmsOrderExample example=new OmsOrderExample();
        example.createCriteria().andOrderIdEqualTo( orderId );
        List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
        if (omsOrders.size() > 0) {
            return omsOrders.get( 0 );
        }
        return null;
    }

    @Override
    public PageInfo <OmsOrder> listUserOrder(PortalOrderQueryParams params, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum, pageSize );
        OmsOrderExample example=new OmsOrderExample();
        example.setOrderByClause( "id desc" );
        example.createCriteria().andUserIdEqualTo( params.getUserId() ).andStoreIdEqualTo( params.getStoreId() );
        List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
        PageInfo <OmsOrder> pageInfo=new PageInfo <>( omsOrders );
        return pageInfo;
    }

    @Override
    public PortalOrderDetailResult getUserOrderDetail(Long orderId) {
        PortalOrderDetailResult userOrderDetail=portalOrderDao.getUserOrderDetail( orderId );
        return userOrderDetail;
    }

    @Override
    public PageInfo <PortalOrderQueryResult> listOrderInfoByParams(PortalOrderQueryParams portalOrderQueryParams, Integer pageNum, Integer pageSize) {
        int startNum=(pageNum - 1) * pageSize;
        int endNum=pageNum * pageSize;
        List <PortalOrderQueryResult> portalOrderQueryResults=portalOrderDao.listOrderInfoByParams( portalOrderQueryParams, startNum, endNum );
        PageInfo <PortalOrderQueryResult> portalOrderQueryResultPageInfo=new PageInfo <>( portalOrderQueryResults );
        int total=portalOrderDao.countOrder( portalOrderQueryParams );
        portalOrderQueryResultPageInfo.setTotal( total );
        int totalPage=0;
        DecimalFormat df=new DecimalFormat( "#.##" );
        double v=Double.parseDouble( df.format( ( double ) total / pageSize ) );

        if ((v) % 2 == 0 || (v) % 2 == 1) {
            //说明是分页不产生多余数据
            totalPage=( int ) v;
        } else {
            totalPage=( int ) v + 1;
        }
        portalOrderQueryResultPageInfo.setPages( totalPage );
        portalOrderQueryResultPageInfo.setPageNum( pageNum );
        portalOrderQueryResultPageInfo.setPageSize( pageSize );
        return portalOrderQueryResultPageInfo;
    }



}
