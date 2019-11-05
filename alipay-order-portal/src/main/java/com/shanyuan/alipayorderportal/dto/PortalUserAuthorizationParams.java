package com.shanyuan.alipayorderportal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-23 9:19
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalUserAuthorizationParams {
    @ApiModelProperty(value="加密code",required=true)
    @NotEmpty(message="code不允许为空")
    private String code;
    @ApiModelProperty(value="用户头像",required=true)
    @NotEmpty(message="用户头像不允许为空")
    private String avatar;
    @ApiModelProperty(value="用户昵称",required=true)
    @NotEmpty(message="昵称不允许为空")
    private String nickName;
    @ApiModelProperty(value="性别，男对应m，女对应f",required=true)
    private String gender;
    @ApiModelProperty("国家代码")
    private String countryCode;
    @ApiModelProperty("省份")
    private String province;
    @ApiModelProperty("所在市区")
    private String city;
    @ApiModelProperty(value="品牌id",required=true)
    @NotNull(message="品牌id不允许为空")
    private Long brandId;
}
