package com.shanyuan.alipayorderadmin.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 9:54
 * <p>
 * desc
 **/
@Data
public class AliRefundData {
    private String alipay_response_code;
    private String alipay_response_sub_code;
    private String alipay_response_sub_msg;
}
