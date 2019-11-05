package com.shanyuan.common.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-24 10:59
 * <p>
 * desc
 **/
@Data
public class ItemOrderDetail {
    private String goods_id;
    private String goods_name;
    private String price;
    private Integer quantity;
}
