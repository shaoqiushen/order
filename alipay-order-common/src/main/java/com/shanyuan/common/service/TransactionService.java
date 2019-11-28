package com.shanyuan.common.service;

import com.shanyuan.common.domain.HomeTransactionChartParams;
import com.shanyuan.common.domain.OmsOrderDetailResult;
import com.shanyuan.common.domain.TransOrderInfo;
import com.shanyuan.common.domain.TransactionParams;
import com.shanyuan.model.OmsOrder;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 8:36
 * <p>
 * desc
 **/
public interface TransactionService {
    List<TransOrderInfo> getTransactionAmount( HomeTransactionChartParams params, Integer pageNum, Integer pageSize);
    List<OmsOrder>getTransactionDetails(TransactionParams params, Integer pageNum, Integer pageSize);
    List<OmsOrderDetailResult> getOrderDetails(Long orderId);
}
