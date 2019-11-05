package com.shanyuan.alipayorderadmin.dao;

import com.shanyuan.alipayorderadmin.domain.TransOrderInfo;
import com.shanyuan.alipayorderadmin.dto.HomeTransactionChartParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 15:11
 * <p>
 * desc
 **/
public interface TransOrderDao {
    List<TransOrderInfo> getTransOrderInfo(@Param( "brandId" ) Long brandId, @Param( "params" ) HomeTransactionChartParams params);
}
