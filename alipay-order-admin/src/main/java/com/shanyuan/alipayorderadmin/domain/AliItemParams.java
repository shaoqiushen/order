package com.shanyuan.alipayorderadmin.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-28 17:29
 * <p>
 * desc
 **/
@Data
public class AliItemParams {
    private String app="2001";
    private String ext_info;
    private String goods_type="NON_STANDARD_GOODS";
    private String local_goods_id;
    private String material_list;
    private String name;
    private String property_list;
    private String scene="SYNC_ORDER";
    private String sku_list;
    private String standard_category_id;
    private String target_id;
    private String target_type="8";
    private Integer type=1;
}
