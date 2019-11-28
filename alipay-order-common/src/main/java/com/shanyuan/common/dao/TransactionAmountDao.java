package com.shanyuan.common.dao;


import com.shanyuan.common.domain.HomeTransactionChartParams;
import com.shanyuan.common.domain.TransOrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-06 17:56
 * <p>
 * desc
 **/
public interface TransactionAmountDao {
    List<TransOrderInfo> getTransactionAmount( @Param("params") HomeTransactionChartParams params);
}
