package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.HomeDateSummaryResult;
import com.shanyuan.alipayorderadmin.dto.HomeTransactionChartParams;
import com.shanyuan.alipayorderadmin.dto.HomeTransactionChartResult;
import com.shanyuan.model.OmsOrder;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 14:07
 * <p>
 * desc
 **/
public interface HomeService {
    PageInfo<OmsOrder> getNewOrderInfo(Long brandId, Integer storeId, Integer pageNum, Integer pageSize);
    HomeDateSummaryResult getDataSummary(Long brandId, Integer storeId);
    HomeTransactionChartResult getTransactionChart(Long brandId, HomeTransactionChartParams params);

    HomeDateSummaryResult getMasterDataSummary(Long brandId);
}
