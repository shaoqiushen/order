package com.shanyuan.alipayorderportal.dto;

import com.shanyuan.common.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 10:46
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalUserAddressParams  {

    @ApiModelProperty(value="品牌id",required=true)
    @NotNull(message="品牌不允许为空")
    private Long brandId;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="用户id",required=true)
    @NotEmpty(message="用户id不允许为空")
    private String userId;

    /**
     * 收货人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="收货人",required=true)
    @NotEmpty(message="收货人不允许为空")
    private String receiver;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="联系电话",required=true)
    @NotEmpty(message="联系电话不允许为空")
    private String telephone;

    /**
     * 所在地区
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="所在地区",required=true)
    @NotEmpty(message="所在地区不允许为空")
    private String area;

    /**
     * 详细地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="详细地址",required=true)
    @NotEmpty(message="详细地址不允许为空")
    private String address;

    /**
     * 是否默认地址:0->否;1->是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="是否默认地址:0->否;1->是",required=true)
    @FlagValidator(value={"0","1"},message="地址状态只允许输入0或1")
    private Integer type;
    /**
     * 经度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="经度",required=true)
    private BigDecimal longitude;

    /**
     * 纬度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="纬度",required=true)
    private BigDecimal latitude;
}
