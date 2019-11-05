package com.shanyuan.alipayorderadmin.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 10:48
 * <p>
 * desc
 **/
@Data
public class OmsReceiptCodeResult {
    //收款时间
    private String receiptDate;
    //收款笔数
    private int receiptSum;
    //收款总额
    private int receiptTotal;
    //桌号
    private String deskNo;
}
