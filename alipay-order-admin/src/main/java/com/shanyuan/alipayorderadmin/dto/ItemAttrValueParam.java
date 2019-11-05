package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 14:56
 * <p>
 * desc
 **/
@Data
@ApiModel
public class ItemAttrValueParam {
    /**
     * 属性id
     *
     * @mbggenerated
     */
    private Integer attrId;

    /**
     * 属性值
     *
     * @mbggenerated
     */
    private String value;

    /**
     * 品牌id
     *
     * @mbggenerated
     */
    private Long brandId;

    /**
     * 属性类型:0->规格;1->参数
     *
     * @mbggenerated
     */
    private Integer attrType;

}
