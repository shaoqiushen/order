package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-31 10:22
 * <p>
 * desc
 **/
@Data
@ApiModel
public class BrandStoreParams {
    @ApiModelProperty(value="品牌id",required=true)
    @NotNull(message="品牌id不允许为空")
    private Long brandId;
    @ApiModelProperty("店铺id")
    private Integer storeId;
}
