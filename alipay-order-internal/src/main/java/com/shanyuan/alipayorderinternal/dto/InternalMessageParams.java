package com.shanyuan.alipayorderinternal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 11:48
 * <p>
 * desc
 **/
@Data
@ApiModel
public class InternalMessageParams {
    @ApiModelProperty(value="消息",required=true)
    @NotEmpty(message="消息不允许为空")
    private String message;
    @ApiModelProperty(value="时间",required=true,example="2019-09-09 00:00:00")
    @NotEmpty(message="时间不允许为空")
    private String mesTime;
    @ApiModelProperty(value="员工姓名",required=true)
    private String staffName;
}
