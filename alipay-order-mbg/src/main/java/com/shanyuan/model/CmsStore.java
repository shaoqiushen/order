package com.shanyuan.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CmsStore implements Serializable {
    private Integer id;

    /**
     * 店铺名称
     *
     * @mbggenerated
     */
    private String storeName;

    /**
     * 店铺地址
     *
     * @mbggenerated
     */
    private String storeAddr;

    /**
     * 店铺电话
     *
     * @mbggenerated
     */
    private String storePhone;

    /**
     * 经度
     *
     * @mbggenerated
     */
    private BigDecimal longitude;

    /**
     * 纬度
     *
     * @mbggenerated
     */
    private BigDecimal latitude;

    /**
     * 是否启用:0->否;1->是
     *
     * @mbggenerated
     */
    private Integer enableStatus;

    /**
     * 是否营业:0->否;1->是
     *
     * @mbggenerated
     */
    private Integer openStatus;

    /**
     * 品牌id
     *
     * @mbggenerated
     */
    private Long brandId;

    private String concater;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(Integer openStatus) {
        this.openStatus = openStatus;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getConcater() {
        return concater;
    }

    public void setConcater(String concater) {
        this.concater = concater;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", storeName=").append(storeName);
        sb.append(", storeAddr=").append(storeAddr);
        sb.append(", storePhone=").append(storePhone);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", enableStatus=").append(enableStatus);
        sb.append(", openStatus=").append(openStatus);
        sb.append(", brandId=").append(brandId);
        sb.append(", concater=").append(concater);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}