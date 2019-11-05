package com.shanyuan.alipayorderportal.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-29 17:06
 * <p>
 * desc
 **/
@Data
public class SycnData {
    private String app;
    private String appid;
    private String out_biz_no;
    private Integer type;
    private String out_trade_no;
    private String buyer_id;
    private String seller_id;
    private String partner_id;
    private String amount;
    private String trade_no;
    private String item_order_list;
    private String ext_info;
    private String alipay_response_code;
    private String alipay_response_sub_code;
    private String alipay_response_sub_msg;
    private String order_sync_id;
}
