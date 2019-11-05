package com.shanyuan.model;

import java.io.Serializable;

public class CmsTable implements Serializable {
    private Integer id;

    /**
     * 品牌id
     *
     * @mbggenerated
     */
    private Long brandId;

    /**
     * 店铺id
     *
     * @mbggenerated
     */
    private Integer storeId;

    /**
     * 茶位费，单位分
     *
     * @mbggenerated
     */
    private Integer price;

    /**
     * 是否启用:0->否;1->是
     *
     * @mbggenerated
     */
    private Integer enableStatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandId=").append(brandId);
        sb.append(", storeId=").append(storeId);
        sb.append(", price=").append(price);
        sb.append(", enableStatus=").append(enableStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}