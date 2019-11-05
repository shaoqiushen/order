package com.shanyuan.alipayorderportal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-04 15:14
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalSearchItemParams {
    @ApiModelProperty(value="品牌id",required=true)
    @NotNull(message="品牌id不允许为空")
    private Long brandId;
    @ApiModelProperty(value="店铺id",required=true)
    @NotNull(message="店铺id不允许为空")
    private Integer storeId;
    @ApiModelProperty(value="产品名称关键字")
    private String keywords;
}
