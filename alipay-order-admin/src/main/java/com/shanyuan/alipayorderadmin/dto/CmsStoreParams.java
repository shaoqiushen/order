package com.shanyuan.alipayorderadmin.dto;

import com.shanyuan.common.validator.FlagValidator;
import com.shanyuan.common.validator.LengthValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 17:59
 * <p>
 * desc
 **/
@Data
@ApiModel
public class CmsStoreParams  {
    /**
     * 店铺名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="店铺名称",required=true)
    @NotEmpty(message="店铺名称不允许为空")
    private String storeName;

    /**
     * 店铺地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="店铺地址",required=true)
    @NotEmpty(message="店铺地址不允许为空")
    private String storeAddr;

    /**
     * 店铺电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="店铺电话",required=true)
    @NotEmpty(message="店铺电话不允许为空")
    @LengthValidator(value=11,message="电话号码最大长度11位")
    private String storePhone;

    /**
     * 是否启用:0->否;1->是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="是否启用:0->否;1->是",required=true)
    @FlagValidator(value={"0","1"},message="启用状态只允许输入0或1")
    private Integer enableStatus;

    @ApiModelProperty(value="品牌id",required=true)
    private Long brandId;

    @ApiModelProperty(value="账号",required=true)
    @NotEmpty(message="账号不允许为空")
    private String account;
    @ApiModelProperty(value="密码",required=true)
    @NotEmpty(message="密码不允许为空")
    private String password;

    @ApiModelProperty(value="联系人")
    private String concater;
}
