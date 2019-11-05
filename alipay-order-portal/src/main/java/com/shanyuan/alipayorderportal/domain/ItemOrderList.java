package com.shanyuan.alipayorderportal.domain;

import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-29 10:40
 * <p>
 * desc
 **/
@Data
public class ItemOrderList {
    private String sku_id;
    private String item_id;
    private String item_name;
    private double unit_price;
    private Integer quantity;
    private List<ExtInfo> ext_info;
    private String sp1;
    private String sp2;
    private String sp3;
}
