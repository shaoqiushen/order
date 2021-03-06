package com.shanyuan.alipayorderinternal.service.impl;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.service.InternalTranscationAmountService;
import com.shanyuan.common.domain.HomeTransactionChartParams;
import com.shanyuan.common.domain.OmsOrderDetailResult;
import com.shanyuan.common.domain.TransOrderInfo;
import com.shanyuan.common.domain.TransactionParams;
import com.shanyuan.common.service.TransactionService;
import com.shanyuan.model.OmsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-07 18:14
 * <p>
 * desc
 **/
@Service
public class InternalTranscationAmountServiceImpl implements InternalTranscationAmountService {

    @Autowired
    TransactionService transactionService;

    @Override
    public PageInfo <TransOrderInfo> getTransactionAmount( HomeTransactionChartParams params, Integer pageNum, Integer pageSize) {
        List <TransOrderInfo> transactionAmount=transactionService.getTransactionAmount(  params, pageNum, pageSize );
        PageInfo<TransOrderInfo> pageInfo = new PageInfo <>( transactionAmount );
        return pageInfo;
    }

    @Override
    public PageInfo <OmsOrder> getTransactionDetails(TransactionParams params, Integer pageNum, Integer pageSize) {
        List <OmsOrder> transactionDetails=transactionService.getTransactionDetails( params, pageNum, pageSize );
        PageInfo<OmsOrder> pageInfo = new PageInfo <>( transactionDetails );
        return null;
    }

    @Override
    public List <OmsOrderDetailResult> getOrderDetails(Long orderId) {
        List <OmsOrderDetailResult> orderDetails=transactionService.getOrderDetails( orderId );
        return orderDetails;
    }
}
