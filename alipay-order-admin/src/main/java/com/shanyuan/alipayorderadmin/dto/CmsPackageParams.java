package com.shanyuan.alipayorderadmin.dto;

import com.shanyuan.common.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-04 10:32
 * <p>
 * desc
 **/
@Data
@ApiModel
public class CmsPackageParams {
    @ApiModelProperty(value="品牌id",required=true)
    private Long brandId;
    @ApiModelProperty(value="店铺id",required=true)
    private Integer storeId;
    @ApiModelProperty(value="价格,单位分",required=true)
    @Min( value=0 ,message="价格不允许负数")
    private Integer price;
    @ApiModelProperty(value="是否启用:0->否;1->是",required=true)
    @FlagValidator(value={"0","1"},message="启用状态只允许输入0或1")
    private Integer enableStatus;
}
