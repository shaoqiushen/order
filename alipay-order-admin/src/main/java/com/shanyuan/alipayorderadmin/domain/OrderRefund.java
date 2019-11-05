package com.shanyuan.alipayorderadmin.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 9:08
 * <p>
 * desc
 **/
@Data
public class OrderRefund {
    private String appid;
    private String out_trade_no;
    private String refund_amount;
    private String refund_reason;
    private String trade_no;
    private Integer type=1;
    //退款商品详情
    private String goods_detail;

}
