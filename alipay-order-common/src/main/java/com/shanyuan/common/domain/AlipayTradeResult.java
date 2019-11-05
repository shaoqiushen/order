package com.shanyuan.common.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-23 17:55
 * <p>
 * desc
 **/
@Data
public class AlipayTradeResult {
    private int status;
    private String code;
    private String msg;
    private TradeData data;
}
