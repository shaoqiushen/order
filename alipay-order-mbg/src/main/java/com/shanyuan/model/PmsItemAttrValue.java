package com.shanyuan.model;

import java.io.Serializable;

public class PmsItemAttrValue implements Serializable {
    private Integer id;

    /**
     * 属性id
     *
     * @mbggenerated
     */
    private Integer attrId;

    /**
     * 属性值
     *
     * @mbggenerated
     */
    private String value;

    /**
     * 品牌id
     *
     * @mbggenerated
     */
    private Long brandId;

    /**
     * 属性类型:0->规格;1->参数
     *
     * @mbggenerated
     */
    private Integer attrType;

    /**
     * 产品id
     *
     * @mbggenerated
     */
    private Integer itemId;

    /**
     * 店铺id
     *
     * @mbggenerated
     */
    private Integer storeId;

    /**
     * 属性名
     *
     * @mbggenerated
     */
    private String attrName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Integer getAttrType() {
        return attrType;
    }

    public void setAttrType(Integer attrType) {
        this.attrType = attrType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attrId=").append(attrId);
        sb.append(", value=").append(value);
        sb.append(", brandId=").append(brandId);
        sb.append(", attrType=").append(attrType);
        sb.append(", itemId=").append(itemId);
        sb.append(", storeId=").append(storeId);
        sb.append(", attrName=").append(attrName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}