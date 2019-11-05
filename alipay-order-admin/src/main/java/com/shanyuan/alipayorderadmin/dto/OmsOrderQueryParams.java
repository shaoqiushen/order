package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 9:56
 * <p>
 * desc
 **/
@Data
@ApiModel
public class OmsOrderQueryParams {
    @ApiModelProperty("订单编号")
    private Long orderId;
    @ApiModelProperty("查询开始时间")
    private String startTime;
    @ApiModelProperty("查询结束时间")
    private String endTime;
    @ApiModelProperty(value="品牌id",required=true)
    private Long brandId;
    @ApiModelProperty(value="店铺id")
    private Integer storeId;
    @ApiModelProperty(value="订单类型:0->在线点餐;1->扫码点餐",required=true)
    private Integer orderType;
    @ApiModelProperty("订单状态：0->待付款；1->已支付，待接单；2->已接单，制作中；3->在配送；4->已完成；5->已关闭；6->无效订单; 7->已取消; 8->已删除;")
    private Integer orderStatus;
}
