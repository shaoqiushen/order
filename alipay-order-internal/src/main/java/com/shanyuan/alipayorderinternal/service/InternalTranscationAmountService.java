package com.shanyuan.alipayorderinternal.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.common.domain.HomeTransactionChartParams;
import com.shanyuan.common.domain.OmsOrderDetailResult;
import com.shanyuan.common.domain.TransOrderInfo;
import com.shanyuan.common.domain.TransactionParams;
import com.shanyuan.model.OmsOrder;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-07 18:14
 * <p>
 * desc
 **/
public interface InternalTranscationAmountService {
    PageInfo<TransOrderInfo> getTransactionAmount( HomeTransactionChartParams params, Integer pageNum, Integer pageSize);
    PageInfo<OmsOrder>getTransactionDetails(TransactionParams params, Integer pageNum, Integer pageSize);
    List<OmsOrderDetailResult> getOrderDetails(Long orderId);
}
