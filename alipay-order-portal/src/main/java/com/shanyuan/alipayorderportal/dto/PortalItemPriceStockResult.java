package com.shanyuan.alipayorderportal.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-29 14:33
 * <p>
 * desc
 **/
@Data
public class PortalItemPriceStockResult {
    private Integer skuId;
    private Integer price;
    private Integer stock;
    private Integer promotionPrice;
}
