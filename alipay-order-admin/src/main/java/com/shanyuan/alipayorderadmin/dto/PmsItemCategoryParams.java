package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 15:53
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PmsItemCategoryParams {
    @ApiModelProperty(value="产品分类名称",required=true)
    @NotEmpty(message="分类名称不允许为空")
    private String categoryName;
    @ApiModelProperty(value="排序，值越小越靠前",required=true)
    private Integer sort;
    @ApiModelProperty(value="品牌id",required=true)
    private Long brandId;
    @ApiModelProperty(value="店铺id",required=true)
    private Integer storeId;
}
