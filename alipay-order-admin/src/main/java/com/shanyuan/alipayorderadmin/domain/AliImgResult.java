package com.shanyuan.alipayorderadmin.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-28 16:42
 * <p>
 * desc
 **/
@Data
public class AliImgResult {
    private int status;
    private String code;
    private String msg;
    private AliImgData data;
}
