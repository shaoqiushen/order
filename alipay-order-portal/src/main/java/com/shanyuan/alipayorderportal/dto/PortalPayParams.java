package com.shanyuan.alipayorderportal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-18 9:59
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalPayParams {

    @ApiModelProperty(value="用户id",required=true)
    @NotEmpty(message="用户id不允许为空")
    private String userId;
    @ApiModelProperty(value="消费描述",required=true)
    private String body;
    @ApiModelProperty(value="订单id",required=true)
    @NotNull(message="订单号不允许为空")
    private Long orderId;
    @ApiModelProperty(value="订单标题",required=true)
    @NotEmpty(message="标题不允许为空")
    private String subject;
    @ApiModelProperty(value="appid",required=true)
    @NotEmpty(message="appid不允许为空")
    private String appid;
    @ApiModelProperty("订单备注")
    private String notes;
    @ApiModelProperty("就餐人数")
    private Integer eatPeopleAmount;
}
