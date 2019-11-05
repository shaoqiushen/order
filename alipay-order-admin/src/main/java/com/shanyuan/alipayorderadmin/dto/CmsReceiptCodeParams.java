package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-24 14:30
 * <p>
 * desc
 **/
@Data
@ApiModel
public class CmsReceiptCodeParams {
    @ApiModelProperty(value="收款码",required=true)
    @NotEmpty(message="收款码不允许为空")
    private String receiptCode;
    @NotEmpty(message="编号不允许为空")
    @ApiModelProperty(value="编号/桌号",required=true)
    private String deskNo;
    @ApiModelProperty(value="品牌id",required=true)
    private Long brandId;
    @ApiModelProperty(value="店铺id",required=true)
    private Integer storeId;


}
