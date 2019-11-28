package com.shanyuan.alipayorderinternal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 10:34
 * <p>
 * desc
 **/
@Data
@ApiModel
public class InternalStaffParams {
    @ApiModelProperty(value="员工姓名",required=true)
    @NotEmpty(message="员工姓名不允许为空")
    private String staffName;
    @ApiModelProperty(value="性别:0-未知;1->男;2->女",required=true)
    private Integer sex;
    @ApiModelProperty("联系电话")
    private String telephone;
}
