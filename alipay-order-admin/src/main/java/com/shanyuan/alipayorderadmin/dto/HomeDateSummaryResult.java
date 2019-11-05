package com.shanyuan.alipayorderadmin.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 14:19
 * <p>
 * desc
 **/
@Data
public class HomeDateSummaryResult {
    //收款码总数
    private int receiptCodeTotal;
    //昨日交易额
    private int yesDayTransactionAmount;
    //今日交易额
    private Integer toDayTransactionAmount;
    //昨日订单数
    private int yesDayOrderTotal;
    //今日订单数
    private int toDayOrderTotal;
    //店铺数
    private int storeAmount;


}
