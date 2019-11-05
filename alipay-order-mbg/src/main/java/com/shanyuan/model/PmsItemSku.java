package com.shanyuan.model;

import java.io.Serializable;

public class PmsItemSku implements Serializable {
    private Integer id;

    /**
     * 产品id
     *
     * @mbggenerated
     */
    private Integer itemId;

    /**
     * 价格，单位分
     *
     * @mbggenerated
     */
    private Integer price;

    /**
     * 促销价格，单位分
     *
     * @mbggenerated
     */
    private Integer promotionPrice;

    /**
     * 库存，-1表示无限量
     *
     * @mbggenerated
     */
    private Integer stock;

    /**
     * 产品属性规格图
     *
     * @mbggenerated
     */
    private String picture;

    /**
     * 产品属性1
     *
     * @mbggenerated
     */
    private String sp1;

    /**
     * 产品属性2
     *
     * @mbggenerated
     */
    private String sp2;

    /**
     * 产品属性3
     *
     * @mbggenerated
     */
    private String sp3;

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

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Integer promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSp1() {
        return sp1;
    }

    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }

    public String getSp2() {
        return sp2;
    }

    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }

    public String getSp3() {
        return sp3;
    }

    public void setSp3(String sp3) {
        this.sp3 = sp3;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", itemId=").append(itemId);
        sb.append(", price=").append(price);
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", stock=").append(stock);
        sb.append(", picture=").append(picture);
        sb.append(", sp1=").append(sp1);
        sb.append(", sp2=").append(sp2);
        sb.append(", sp3=").append(sp3);
        sb.append(", brandId=").append(brandId);
        sb.append(", storeId=").append(storeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}