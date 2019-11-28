package com.shanyuan.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.common.dao.OrderDao;
import com.shanyuan.common.dao.TransactionAmountDao;
import com.shanyuan.common.domain.HomeTransactionChartParams;
import com.shanyuan.common.domain.OmsOrderDetailResult;
import com.shanyuan.common.domain.TransOrderInfo;
import com.shanyuan.common.domain.TransactionParams;
import com.shanyuan.common.service.TransactionService;
import com.shanyuan.common.utils.MyDateUtil;
import com.shanyuan.mapper.OmsOrderMapper;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 8:37
 * <p>
 * desc
 **/
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Autowired
    OrderDao orderDao;

    @Autowired
    TransactionAmountDao transactionAmountDao;
    @Override
    public List<TransOrderInfo> getTransactionAmount( HomeTransactionChartParams params, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        List <TransOrderInfo> transactionAmount=transactionAmountDao.getTransactionAmount(  params );
        return transactionAmount;
    }

    @Override
    public List <OmsOrder> getTransactionDetails(TransactionParams params, Integer pageNum, Integer pageSize) {
        OmsOrderExample example = new OmsOrderExample();
        example.setOrderByClause( "id desc" );
        OmsOrderExample.Criteria criteria=example.createCriteria();
        criteria.andBrandIdEqualTo( params.getBrandId() )
                .andDeleteStatusEqualTo( 0 )
                .andPaymentTimeGreaterThanOrEqualTo( MyDateUtil.stringTransToDate( params.getSearchDate()+" 00:00:00" ) )
                .andPaymentTimeLessThanOrEqualTo( MyDateUtil.stringTransToDate( params.getSearchDate()+" 23:59:59" ) );
        if(params.getStoreId() != null && params.getStoreId() > 0){
            criteria.andStoreIdEqualTo( params.getStoreId() );
        }
        PageHelper.startPage( pageNum,pageSize );
        List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
        return omsOrders;
    }

    @Override
    public List <OmsOrderDetailResult> getOrderDetails(Long orderId) {
        List <OmsOrderDetailResult> omsOrderDetailResults=orderDao.listOrderDetail( orderId );
        return omsOrderDetailResults;
    }
}
