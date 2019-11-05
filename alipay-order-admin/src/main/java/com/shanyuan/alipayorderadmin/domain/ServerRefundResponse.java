package com.shanyuan.alipayorderadmin.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 9:29
 * <p>
 * desc
 **/
@Data
public class ServerRefundResponse {
    private int status;
    private String code;
    private String msg;
    private AliRefundData data;
}
