package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 11:04
 * <p>
 * desc
 **/
@Data
@ApiModel
public class OmsReceiptQueryParams {
    @ApiModelProperty(value="品牌id",required=true)
    private Long brandId;
    @ApiModelProperty(value="店铺id",required=true)
    private Integer storeId;
    @ApiModelProperty(value="桌号",required=true)
    @NotEmpty(message="桌号不允许为空")
    private String deskNo;
}
