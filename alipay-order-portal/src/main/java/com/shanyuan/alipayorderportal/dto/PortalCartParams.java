package com.shanyuan.alipayorderportal.dto;

import com.shanyuan.alipayorderportal.domain.CartParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-30 10:30
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalCartParams {

    @ApiModelProperty(value="用户id", required=true)
    @NotEmpty(message="用户id不允许为空")
    private String userId;
    @ApiModelProperty(value="品牌id", required=true)
    private Long brandId;
    @ApiModelProperty(value="店铺id", required=true)
    private Integer storeId;
    @ApiModelProperty(value="购物车产品信息",required=true)
    private List<CartParam> cartParamList;
//    @ApiModelProperty(value="产品id", required=true)
//    private Integer itemId;
//    @ApiModelProperty(value="购物满数量", required=true)
//    @Min(value=1, message="购买数量必须大于0")
//    private Integer buyCount;
//    @ApiModelProperty(value="sku库存id", required=true)
//    private Integer skuId;
}
