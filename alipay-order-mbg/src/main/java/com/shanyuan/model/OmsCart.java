package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class OmsCart implements Serializable {
    private Integer id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 产品id
     *
     * @mbggenerated
     */
    private Integer itemId;

    /**
     * skuId
     *
     * @mbggenerated
     */
    private Integer skuId;

    /**
     * 购买数量
     *
     * @mbggenerated
     */
    private Integer buyCount;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 店铺id
     *
     * @mbggenerated
     */
    private Integer storeId;

    /**
     * 品牌id
     *
     * @mbggenerated
     */
    private Long brandId;

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

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", itemId=").append(itemId);
        sb.append(", skuId=").append(skuId);
        sb.append(", buyCount=").append(buyCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", storeId=").append(storeId);
        sb.append(", brandId=").append(brandId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}