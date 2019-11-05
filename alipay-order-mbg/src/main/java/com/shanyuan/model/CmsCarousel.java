package com.shanyuan.model;

import java.io.Serializable;

public class CmsCarousel implements Serializable {
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
     * 图片
     *
     * @mbggenerated
     */
    private String picture;

    /**
     * 是否上架:0->否;1->是
     *
     * @mbggenerated
     */
    private Integer publishStatus;

    /**
     * 轮播顺序
     *
     * @mbggenerated
     */
    private Integer sort;

    /**
     * 外链地址
     *
     * @mbggenerated
     */
    private String outchain;

    /**
     * 链接类型:0->商品;1->外链
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * 展示位置:0->首页;1->产品页
     *
     * @mbggenerated
     */
    private Integer position;

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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getOutchain() {
        return outchain;
    }

    public void setOutchain(String outchain) {
        this.outchain = outchain;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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
        sb.append(", picture=").append(picture);
        sb.append(", publishStatus=").append(publishStatus);
        sb.append(", sort=").append(sort);
        sb.append(", outchain=").append(outchain);
        sb.append(", type=").append(type);
        sb.append(", position=").append(position);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}