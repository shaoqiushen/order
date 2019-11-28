package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-30 10:09
 * <p>
 * desc
 **/
@Data
@ApiModel
public class UmsOperParams {
    @ApiModelProperty(value="品牌id",required=true)
    private Long brandId;
    @ApiModelProperty(value="店铺id")
    private Integer storeId;
    @ApiModelProperty(value="账号",required=true)
    @NotEmpty(message="账号不允许为空")
    private String account;
    @ApiModelProperty(value="密码",required=true)
    @NotEmpty(message="密码不允许为空")
    private String password;
    @ApiModelProperty(value="角色id",required=true)
    private Integer roleId;

}
