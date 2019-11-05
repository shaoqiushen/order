package com.shanyuan.alipayorderadmin.dto;

import com.shanyuan.alipayorderadmin.domain.TransOrderInfo;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 14:56
 * <p>
 * desc
 **/
@Data
public class HomeTransactionChartResult {
    private List<String> dayList;
    private List<TransOrderInfo> transOrderInfoList;
}
