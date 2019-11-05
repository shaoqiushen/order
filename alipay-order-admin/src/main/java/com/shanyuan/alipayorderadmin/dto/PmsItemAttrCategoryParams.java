package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 10:10
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PmsItemAttrCategoryParams {
    @ApiModelProperty(value="名称",required=true)
    @NotEmpty(message="名称不允许为空")
    private String name;
    @ApiModelProperty(value="品牌id",required=true)
    private Long brandId;
    @ApiModelProperty(value="店铺id",required=true)
    private Integer storeId;
}
