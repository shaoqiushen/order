package com.shanyuan.alipayorderportal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-18 14:14
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalOrderQueryParams {
    @ApiModelProperty(value="用户id",required=true)
    @NotEmpty(message="用户id不允许为空")
    private String userId;
    @ApiModelProperty(value="店铺id",required=true)
//    @NotNull(message="店铺id不允许为空")
    private Integer storeId;

//    private Integer orderStatus;
    @ApiModelProperty(value="订单状态集合：0->待付款；1->已支付，待发货；2->已发货；3->已完成；4->已关闭；5->无效订单；查询全部则不传")
    private List<Integer> orderStatusList;
}
