package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-05 17:55
 * <p>
 * desc
 **/
@Data
@ApiModel
public class CmsCodeParams {
    @ApiModelProperty(value="品牌id",required=true)
    @NotNull(message="品牌id不允许为空")
    private Long brandId;
    @ApiModelProperty(value="店铺id",required=true)
    @NotNull(message="店铺id不允许为空")
    private Integer storeId;
    @ApiModelProperty(value="桌号",required=true)
    @NotEmpty(message="桌号不允许为空")
    private String deskNo;
}
