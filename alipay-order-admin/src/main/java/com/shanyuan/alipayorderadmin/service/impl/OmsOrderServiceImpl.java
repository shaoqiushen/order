package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dao.OmsOrderDao;
import com.shanyuan.alipayorderadmin.domain.OrderRefund;
import com.shanyuan.alipayorderadmin.domain.ServerRefundResponse;
import com.shanyuan.alipayorderadmin.dto.OmsOrderDetailResult;
import com.shanyuan.alipayorderadmin.dto.OmsOrderQueryParams;
import com.shanyuan.alipayorderadmin.service.OmsOrderService;
import com.shanyuan.alipayorderadmin.service.RefundService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.MathUtils;
import com.shanyuan.common.utils.MyDateUtil;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.mapper.OmsOrderDetailMapper;
import com.shanyuan.mapper.OmsOrderMapper;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderDetail;
import com.shanyuan.model.OmsOrderDetailExample;
import com.shanyuan.model.OmsOrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 9:54
 * <p>
 * desc
 **/
@Service
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Autowired
    OmsOrderDetailMapper omsOrderDetailMapper;

    @Autowired
    OmsOrderDao omsOrderDao;

    @Autowired
    RefundService refundService;

    @Override
    public PageInfo <OmsOrder> listOrder(Integer pageNum, Integer pageSize, OmsOrderQueryParams params) {
        PageHelper.startPage( pageNum, pageSize );
        OmsOrderExample example=new OmsOrderExample();
        example.setOrderByClause( "id desc" );
        OmsOrderExample.Criteria criteria=example.createCriteria();
        if (params.getOrderId() != null) {
            criteria.andOrderIdEqualTo( params.getOrderId() );
        }
        if (!StringUtils.isEmpty( params.getStartTime() )) {
            criteria.andCreateTimeGreaterThanOrEqualTo( MyDateUtil.StringTransToDate( params.getStartTime() + " 00:00:00" ) );
        }
        if (!StringUtils.isEmpty( params.getEndTime() )) {
            criteria.andCreateTimeLessThanOrEqualTo( MyDateUtil.StringTransToDate( params.getEndTime() + " 23:59:59" ) );
        }
        if(params.getOrderStatus() != null){
            criteria.andOrderStatusEqualTo( params.getOrderStatus() );
        }
        if(params.getStoreId() != null){
            criteria.andStoreIdEqualTo( params.getStoreId() );
        }
        criteria.andOrderTypeEqualTo( params.getOrderType() );
        criteria.andBrandIdEqualTo( params.getBrandId() );
        criteria.andDeleteStatusEqualTo( 0 );
        List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
        PageInfo <OmsOrder> pageInfo=new PageInfo <>( omsOrders );
        return pageInfo;
    }

    @Override
    public List <OmsOrderDetailResult> listOrderDetail(Long orderId) {
        List <OmsOrderDetailResult> omsOrderDetailResults=omsOrderDao.listOrderDetail( orderId );

        return omsOrderDetailResults;
    }

    @Override
    public CommonResult unsubscribe(List<Integer> ids, Integer cancelStatus, String cancelDesc) {
        OmsOrderDetail omsOrderDetail = new OmsOrderDetail();
        omsOrderDetail.setCancelStatus( cancelStatus );
        omsOrderDetail.setCancelDesc( cancelDesc );
        OmsOrderDetailExample example = new OmsOrderDetailExample();
        example.createCriteria().andIdIn( ids );
        int count=omsOrderDetailMapper.updateByExampleSelective( omsOrderDetail, example );
        //执行退款逻辑

        List <OmsOrderDetailResult> orderInfos=omsOrderDao.getOrderInfo( ids );
        if(orderInfos.size() ==0){
            return new CommonResult().failed( "退订失败，查询不到相应订单信息" );
        }
        int refunAmount = 0;
        String tradeNo = "";
        Long brandId=0L;
        Long orderId=0L;
        for(OmsOrderDetailResult detailResult : orderInfos){
            refunAmount+=detailResult.getPrice();
            tradeNo=detailResult.getTradeNo();
            brandId=detailResult.getBrandId();
            orderId=detailResult.getOrderId();
        }
        OrderRefund orderRefund = new OrderRefund();
        orderRefund.setAppid( String.valueOf( brandId ) );
        orderRefund.setOut_trade_no( String.valueOf( orderId ) );
        orderRefund.setRefund_amount( String.valueOf( MathUtils.getTwoBitValue( String.valueOf( (double)refunAmount/100 ) ) ) );
        orderRefund.setRefund_reason( cancelDesc );
        orderRefund.setTrade_no( tradeNo );
        ServerRefundResponse refund=refundService.refund( orderRefund );
        if(refund.getStatus() != 1){
            //退订失败则手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new CommonResult().failed( "退订失败："+refund.getData().getAlipay_response_sub_msg() );
        }
        return ResultUtil.result( count );

    }

    @Override
    public int updateOrderStatus(Integer id, Integer orderStatus) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId( id );
        omsOrder.setOrderStatus( orderStatus );
        omsOrder.setUpdateTime( new Date(  ) );
        return omsOrderMapper.updateByPrimaryKeySelective( omsOrder );
    }

}
