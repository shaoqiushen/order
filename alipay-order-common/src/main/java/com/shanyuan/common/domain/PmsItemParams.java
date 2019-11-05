package com.shanyuan.common.domain;

import com.shanyuan.model.PmsItem;
import com.shanyuan.model.PmsItemAttrValue;
import com.shanyuan.model.PmsItemSku;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 15:40
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PmsItemParams extends PmsItem {
    @ApiModelProperty(value="操作者",required=true,example="admin")
    @NotEmpty(message="操作者不允许为空")
    private String oper;
    @ApiModelProperty(value="sku信息",required=true)
    private List<PmsItemSku> itemSkuList;
    @ApiModelProperty(value="产品规格属性信息",required=true)
    private List<PmsItemAttrValue> itemAttrValueList;

    private List<ExtInfo> ext_info;
    private String standard_category_id;
    private String appid;
}
