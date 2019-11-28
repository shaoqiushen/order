package com.shanyuan.alipayorderinternal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 9:37
 * <p>
 * desc
 **/
@ApiModel
@Data
public class InternalMerchantParams {

    @ApiModelProperty(value="商户名称",required=true)
    @NotEmpty(message="商户名称不允许为空")
    private String businessName;
    @ApiModelProperty(value="负责人",required=true)
    @NotEmpty(message="负责人不允许为空")
    private String principalName;
    @ApiModelProperty(value="联系方式",required=true)
    @NotEmpty(message="联系方式不允许为空")
    private String concatInfo;
    @ApiModelProperty(value="店铺数量",required=true)
    @Min(value=0,message="店铺数量不允许负数")
    private Integer storeAmount;
}
