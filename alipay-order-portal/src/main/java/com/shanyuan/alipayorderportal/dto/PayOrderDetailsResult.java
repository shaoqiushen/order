package com.shanyuan.alipayorderportal.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-25 11:05
 * <p>
 * desc
 **/
@Data
public class PayOrderDetailsResult {
    private String itemName;
    private Integer itemId;
    private Integer price;
    private Integer buyCount;
}
