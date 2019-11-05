package com.shanyuan.alipayorderportal.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-23 9:46
 * <p>
 * desc
 **/
@Data
public class ServerResponse {
    private int status;
    private String code;
    private String msg;
    private Object data;
}
