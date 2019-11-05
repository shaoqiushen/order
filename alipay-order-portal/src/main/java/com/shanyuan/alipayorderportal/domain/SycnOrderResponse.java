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
public class SycnOrderResponse {
    private int status;
    private String code;
    private String msg;
    private SycnData data;

}
