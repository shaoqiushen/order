package com.shanyuan.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-07 8:46
 * <p>
 * desc
 **/
@Data
@ApiModel
public class TransactionParams {

    @ApiModelProperty(value="品牌id",required=true)
    @NotNull(message="品牌id不允许为空")
    private Long brandId;
    @ApiModelProperty("店铺id")
    private Integer storeId;
    @ApiModelProperty(value="搜索过滤时间",required=true)
    private String searchDate;
}
