package com.shanyuan.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class UmsAddress implements Serializable {
    private Integer id;

    /**
     * 品牌id
     *
     * @mbggenerated
     */
    private Long brandId;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 收货人
     *
     * @mbggenerated
     */
    private String receiver;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    private String telephone;

    /**
     * 所在地区
     *
     * @mbggenerated
     */
    private String area;

    /**
     * 详细地址
     *
     * @mbggenerated
     */
    private String address;

    /**
     * 是否默认地址:0->否;1->是
     *
     * @mbggenerated
     */
    private Integer type;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandId=").append(brandId);
        sb.append(", userId=").append(userId);
        sb.append(", receiver=").append(receiver);
        sb.append(", telephone=").append(telephone);
        sb.append(", area=").append(area);
        sb.append(", address=").append(address);
        sb.append(", type=").append(type);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}