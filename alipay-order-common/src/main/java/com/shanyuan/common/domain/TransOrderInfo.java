package com.shanyuan.common.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 15:09
 * <p>
 * desc
 **/
@Data
public class TransOrderInfo {
    private int transactionTotal;
    private int orderTotal;
    private String payDate;
}
