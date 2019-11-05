package com.shanyuan.alipayorderadmin.dto;

import com.shanyuan.common.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 9:46
 * <p>
 * desc
 **/
@Data
@ApiModel
public class CmsCarouselParams  {
    /**
     * 品牌id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="品牌id",required=true)
    private Long brandId;

    @ApiModelProperty("店铺id")
    private Integer storeId;

    /**
     * 图片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="图片",required=true)
    @NotEmpty(message="图片不允许为空")
    private String picture;

    /**
     * 是否上架:0->否;1->是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="是否上架:0->否;1->是",required=true)
    @FlagValidator(value={"0","1"},message="上架状态只允许输入0或1")
    private Integer publishStatus;

    /**
     * 轮播顺序
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="轮播顺序",required=true)
    private Integer sort;

    /**
     * 外链地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="外链地址")
    private String outchain;

    /**
     * 链接类型:0->商品;1->外链
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="链接类型:0->商品;1->外链")
    @FlagValidator(value={"0","1"},message="链接类型只允许输入0或1")
    private Integer type;

    @ApiModelProperty(value="展示位置:0->首页;1->产品页",required=true)
    private Integer position;
}
