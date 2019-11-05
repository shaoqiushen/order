package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 14:54
 * <p>
 * desc
 **/
@Data
@ApiModel
public class HomeTransactionChartParams {
    @ApiModelProperty(value="店铺id")
    private Integer storeId;
    @ApiModelProperty(value="开启时间",required=true,example="2019-10-22")
    private String startTime;
    @ApiModelProperty(value="结束时间",required=true,example="2019-10-22")
    private String endTime;
}
