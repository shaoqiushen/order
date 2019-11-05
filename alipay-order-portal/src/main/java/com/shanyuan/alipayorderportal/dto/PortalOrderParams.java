package com.shanyuan.alipayorderportal.dto;

import com.shanyuan.alipayorderportal.domain.CartParam;
import com.shanyuan.common.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 11:45
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalOrderParams {
    @ApiModelProperty(value="收货地址id,在线点餐时必填")
    private Integer addressId;
//    @ApiModelProperty(value="支付方式:0->未支付,1->微信支付,2->支付宝支付",required=true)
//    private Integer payType;
    @ApiModelProperty(value="用户id",required=true)
    @NotEmpty(message="用户id不允许为空")
    private String userId;
//    @ApiModelProperty("购买留言")
//    private String notes;
    @ApiModelProperty(value="品牌id",required=true)
    @NotNull(message="品牌id不允许为空")
    private Long brandId;
    @ApiModelProperty(value="店铺id",required=true)
    @NotNull(message="店铺id不允许为空")
    private Integer storeId;
    @ApiModelProperty(value="点餐方式:0->在线点餐;1->扫码点餐",required=true)
    @FlagValidator(value={"0","1"},message="点餐方式只允许输入0或1")
    private Integer orderType;
    @ApiModelProperty(value="桌号,扫码点餐时必填")
    private String deskNo;
    @ApiModelProperty(value="购物车产品信息",required=true)
    private List<CartParam> cartParamList;
}
