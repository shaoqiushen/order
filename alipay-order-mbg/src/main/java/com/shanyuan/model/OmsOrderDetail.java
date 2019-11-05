package com.shanyuan.model;

import java.io.Serializable;

public class OmsOrderDetail implements Serializable {
    private Integer id;

    /**
     * 订单id
     *
     * @mbggenerated
     */
    private Long orderId;

    /**
     * 产品id
     *
     * @mbggenerated
     */
    private Integer itemId;

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
     * 价格，单位分
     *
     * @mbggenerated
     */
    private Integer price;

    /**
     * 购买数量
     *
     * @mbggenerated
     */
    private Integer buyCount;

    /**
     * 产品名称
     *
     * @mbggenerated
     */
    private String itemName;

    /**
     * 是否退订:0->否;1->是
     *
     * @mbggenerated
     */
    private Integer cancelStatus;

    /**
     * 退订原因
     *
     * @mbggenerated
     */
    private String cancelDesc;

    private Integer skuId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(Integer cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public String getCancelDesc() {
        return cancelDesc;
    }

    public void setCancelDesc(String cancelDesc) {
        this.cancelDesc = cancelDesc;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", itemId=").append(itemId);
        sb.append(", sp1=").append(sp1);
        sb.append(", sp2=").append(sp2);
        sb.append(", sp3=").append(sp3);
        sb.append(", price=").append(price);
        sb.append(", buyCount=").append(buyCount);
        sb.append(", itemName=").append(itemName);
        sb.append(", cancelStatus=").append(cancelStatus);
        sb.append(", cancelDesc=").append(cancelDesc);
        sb.append(", skuId=").append(skuId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}