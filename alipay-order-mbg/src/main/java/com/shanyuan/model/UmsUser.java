package com.shanyuan.model;

import java.io.Serializable;

public class UmsUser implements Serializable {
    private Integer id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 支付宝用户id
     *
     * @mbggenerated
     */
    private Long aliUserId;

    /**
     * 头像
     *
     * @mbggenerated
     */
    private String avatar;

    /**
     * 昵称
     *
     * @mbggenerated
     */
    private String nickName;

    /**
     * 性别，男对应m，女对应f
     *
     * @mbggenerated
     */
    private String gender;

    /**
     * 国家代码
     *
     * @mbggenerated
     */
    private String countryCode;

    /**
     * 省份
     *
     * @mbggenerated
     */
    private String province;

    /**
     * 所在城市
     *
     * @mbggenerated
     */
    private String city;

    private Long brandId;

    private String telephone;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getAliUserId() {
        return aliUserId;
    }

    public void setAliUserId(Long aliUserId) {
        this.aliUserId = aliUserId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", aliUserId=").append(aliUserId);
        sb.append(", avatar=").append(avatar);
        sb.append(", nickName=").append(nickName);
        sb.append(", gender=").append(gender);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", brandId=").append(brandId);
        sb.append(", telephone=").append(telephone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}