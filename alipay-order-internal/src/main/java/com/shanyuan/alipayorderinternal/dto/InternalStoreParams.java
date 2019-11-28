package com.shanyuan.alipayorderinternal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 9:44
 * <p>
 * desc
 **/
@ApiModel
@Data
public class InternalStoreParams {
    @ApiModelProperty(value="商户id",required=true)
    @NotNull(message="商户id不允许为空")
    private Integer merId;
    @ApiModelProperty(value="店铺名称",required=true)
    @NotEmpty(message="店铺名称不允许为空")
    private String storeName;
    @ApiModelProperty(value="省份",required=true)
    @NotEmpty(message="省份不允许为空")
    private String province;
    @ApiModelProperty(value="城市名称",required=true)
    @NotEmpty(message="城市名称不允许为空")
    private String city;
    @ApiModelProperty(value="详细地址")
    private String address;
    @ApiModelProperty(value="联系人",required=true)
    @NotEmpty(message="联系人不允许为空")
    private String concatName;
    @ApiModelProperty(value="联系电话",required=true)
    @NotEmpty(message="联系电话不允许为空")
    private String concatPhone;
    @ApiModelProperty(value="员工姓名",required=true)
    @NotEmpty(message="员工项目不允许为空")
    private String staffName;
    @ApiModelProperty(value="员工id",required=true)
    @NotNull(message="员工id不允许为空")
    private Integer staffId;
    @ApiModelProperty("签约时间")
    private String signTime;
}
