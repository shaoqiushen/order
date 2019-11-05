package com.shanyuan.alipayorderportal.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-29 10:35
 * <p>
 * desc
 **/
@Data
public class SycnOrderParams {
    private String amount;
    private String app="2001";
    private String buyer_id;
    private String ext_info;
    private String item_order_list;
//    private String partner_id;
    private String trade_no;
    private Integer type=1;
    private String out_trade_no;
    private String appid;
}
