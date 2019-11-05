package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class OmsOrder implements Serializable {
    private Integer id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 订单编号
     *
     * @mbggenerated
     */
    private Long orderId;

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
     * 店铺名称
     *
     * @mbggenerated
     */
    private String storeName;

    /**
     * 订单总价，单位分
     *
     * @mbggenerated
     */
    private Integer totalAmount;

    /**
     * 实际支付总价，单位分
     *
     * @mbggenerated
     */
    private Integer payAmount;

    /**
     * 优惠金额，单位分
     *
     * @mbggenerated
     */
    private Integer freeAmount;

    /**
     * 配送费，单位分
     *
     * @mbggenerated
     */
    private Integer freightAmount;

    /**
     * 支付方式:0->未支付,1->微信支付,2->支付宝支付,3-->余额支付
     *
     * @mbggenerated
     */
    private Integer payType;

    /**
     * 订单状态：0->待付款；1->已支付，待接单；2->已接单，制作中；3->在配送；4->已完成；5->已关闭；6->无效订单; 7->已取消; 8->已删除;
     *
     * @mbggenerated
     */
    private Integer orderStatus;

    /**
     * 支付时间
     *
     * @mbggenerated
     */
    private Date paymentTime;

    /**
     * 订单备注
     *
     * @mbggenerated
     */
    private String notes;

    /**
     * 收货人
     *
     * @mbggenerated
     */
    private String receiverName;

    /**
     * 收货人电话
     *
     * @mbggenerated
     */
    private String receiverPhone;

    /**
     * 收货人地址
     *
     * @mbggenerated
     */
    private String receiverAddress;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 订单类型:0->在线点餐;1->扫码点餐
     *
     * @mbggenerated
     */
    private Integer orderType;

    /**
     * 桌号;扫码点餐时使用
     *
     * @mbggenerated
     */
    private String deskNo;

    /**
     * 交易流水号
     *
     * @mbggenerated
     */
    private String tradeNo;

    /**
     * 支付标志:0->未生成预订单;1->表示已生成预订单且未实际支付；若再次支付时，则不走正常支付流程，而是从预支付订单表中获取流水号直接唤起支付页面
     *
     * @mbggenerated
     */
    private Integer payFlag;

    /**
     * 取消原因
     *
     * @mbggenerated
     */
    private String cancelDesc;

    private String buyerId;

    /**
     * 订单同步单号
     *
     * @mbggenerated
     */
    private String orderSyncId;

    /**
     * 是否删除：0否1是
     *
     * @mbggenerated
     */
    private Integer deleteStatus;

    /**
     * 取餐号
     *
     * @mbggenerated
     */
    private String mealNo;

    /**
     * 就餐人数（扫码点餐才有）
     *
     * @mbggenerated
     */
    private Integer eatPeopleAmount;

    /**
     * 茶位费(扫码点餐才有，=茶位单价*就餐认数,单位分)
     *
     * @mbggenerated
     */
    private Integer tableMoney;

    /**
     * 包装费，单位分
     *
     * @mbggenerated
     */
    private Integer packageMoney;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(Integer freeAmount) {
        this.freeAmount = freeAmount;
    }

    public Integer getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(Integer freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getDeskNo() {
        return deskNo;
    }

    public void setDeskNo(String deskNo) {
        this.deskNo = deskNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(Integer payFlag) {
        this.payFlag = payFlag;
    }

    public String getCancelDesc() {
        return cancelDesc;
    }

    public void setCancelDesc(String cancelDesc) {
        this.cancelDesc = cancelDesc;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getOrderSyncId() {
        return orderSyncId;
    }

    public void setOrderSyncId(String orderSyncId) {
        this.orderSyncId = orderSyncId;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getMealNo() {
        return mealNo;
    }

    public void setMealNo(String mealNo) {
        this.mealNo = mealNo;
    }

    public Integer getEatPeopleAmount() {
        return eatPeopleAmount;
    }

    public void setEatPeopleAmount(Integer eatPeopleAmount) {
        this.eatPeopleAmount = eatPeopleAmount;
    }

    public Integer getTableMoney() {
        return tableMoney;
    }

    public void setTableMoney(Integer tableMoney) {
        this.tableMoney = tableMoney;
    }

    public Integer getPackageMoney() {
        return packageMoney;
    }

    public void setPackageMoney(Integer packageMoney) {
        this.packageMoney = packageMoney;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append(", brandId=").append(brandId);
        sb.append(", storeId=").append(storeId);
        sb.append(", storeName=").append(storeName);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", freeAmount=").append(freeAmount);
        sb.append(", freightAmount=").append(freightAmount);
        sb.append(", payType=").append(payType);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", notes=").append(notes);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverPhone=").append(receiverPhone);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", orderType=").append(orderType);
        sb.append(", deskNo=").append(deskNo);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", payFlag=").append(payFlag);
        sb.append(", cancelDesc=").append(cancelDesc);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", orderSyncId=").append(orderSyncId);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", mealNo=").append(mealNo);
        sb.append(", eatPeopleAmount=").append(eatPeopleAmount);
        sb.append(", tableMoney=").append(tableMoney);
        sb.append(", packageMoney=").append(packageMoney);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}