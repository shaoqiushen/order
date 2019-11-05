package com.shanyuan.alipayorderadmin.dto;

import com.shanyuan.common.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 16:15
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PmsItemAttrParams {

    /**
     * 属性目录id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="属性目录id",required=true)
    private Integer attrgoryId;

    /**
     * 属性名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="属性名称",required=true)
    private String name;

    /**
     * 可选属性值,多个用逗号分隔
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="可选属性值,多个用逗号分隔")
    private String inputList;

    /**
     * 属性类型:0->规格;1->参数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="属性类型:0->规格;1->参数",required=true)
    @FlagValidator(value={"0","1"},message="属性类型只允许输入0或1")
    private Integer attrType;

    /**
     * 排序，值越小越靠前
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="排序，值越小越靠前",required=true)
    private Integer sort;
}
