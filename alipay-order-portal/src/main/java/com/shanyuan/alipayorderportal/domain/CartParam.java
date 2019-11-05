package com.shanyuan.alipayorderportal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-18 16:12
 * <p>
 * desc
 **/
@Data
@ApiModel
public class CartParam {
    @ApiModelProperty(value="产品id",required=true)
    private Integer itemId;
    @ApiModelProperty(value="购物数量",required=true)
    @Min( value=1,message="购买数量必须大于0" )
    private Integer buyCount;
    @ApiModelProperty(value="sku库存id",required=true)
    private Integer skuId;
}
