package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-05 16:38
 * <p>
 * desc
 **/
@Data
@ApiModel
public class UmsRoleParams {
    @ApiModelProperty(value="角色名",required=true)
    @NotEmpty(message="角色名不允许为空")
    private String name;
    @ApiModelProperty(value="品牌id",required=true)
    @NotNull(message="品牌id不允许为空")
    private Long brandId;
    @ApiModelProperty(value="店铺id",required=true)
    @NotNull(message="店铺id不允许为空")
    private Integer storeId;
    @ApiModelProperty(value="权限；多个以 | 分隔",required=true,example="首页|订单管理|收款码管理")
    @NotEmpty(message="权限不允许为空")
    private String permission;
}
