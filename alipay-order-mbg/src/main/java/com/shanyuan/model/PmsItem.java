package com.shanyuan.model;

import java.io.Serializable;
import java.util.Date;

public class PmsItem implements Serializable {
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
     * 产品分类id
     *
     * @mbggenerated
     */
    private Integer itemCategoryId;

    /**
     * 产品属性id
     *
     * @mbggenerated
     */
    private Integer attrCategoryId;

    /**
     * 产品名称
     *
     * @mbggenerated
     */
    private String itemName;

    /**
     * 产品计量单位
     *
     * @mbggenerated
     */
    private String itemUnit;

    /**
     * 商品介绍
     *
     * @mbggenerated
     */
    private String itemIntroduce;

    /**
     * 缩略图
     *
     * @mbggenerated
     */
    private String thumbnailPic;

    /**
     * 详情图
     *
     * @mbggenerated
     */
    private String detailPic;

    /**
     * 产品轮播展示图
     *
     * @mbggenerated
     */
    private String planPic;

    /**
     * 上架状态:0->下架；1->上架
     *
     * @mbggenerated
     */
    private Integer publishStatus;

    /**
     * 原价,单位分
     *
     * @mbggenerated
     */
    private Integer price;

    /**
     * 促销价
     *
     * @mbggenerated
     */
    private Integer promotionPrice;

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
     * 创建者
     *
     * @mbggenerated
     */
    private String createOper;

    /**
     * 修改者
     *
     * @mbggenerated
     */
    private String updateOper;

    /**
     * 阿里素材id
     *
     * @mbggenerated
     */
    private String materialId;

    private String materialKey;

    private String extInfo;

    /**
     * 销量
     *
     * @mbggenerated
     */
    private Integer saleAmount;

    /**
     * 是否删除:0->否;1->是
     *
     * @mbggenerated
     */
    private Integer deleteStatus;

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

    public Integer getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Integer itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public Integer getAttrCategoryId() {
        return attrCategoryId;
    }

    public void setAttrCategoryId(Integer attrCategoryId) {
        this.attrCategoryId = attrCategoryId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getItemIntroduce() {
        return itemIntroduce;
    }

    public void setItemIntroduce(String itemIntroduce) {
        this.itemIntroduce = itemIntroduce;
    }

    public String getThumbnailPic() {
        return thumbnailPic;
    }

    public void setThumbnailPic(String thumbnailPic) {
        this.thumbnailPic = thumbnailPic;
    }

    public String getDetailPic() {
        return detailPic;
    }

    public void setDetailPic(String detailPic) {
        this.detailPic = detailPic;
    }

    public String getPlanPic() {
        return planPic;
    }

    public void setPlanPic(String planPic) {
        this.planPic = planPic;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
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

    public String getCreateOper() {
        return createOper;
    }

    public void setCreateOper(String createOper) {
        this.createOper = createOper;
    }

    public String getUpdateOper() {
        return updateOper;
    }

    public void setUpdateOper(String updateOper) {
        this.updateOper = updateOper;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterialKey() {
        return materialKey;
    }

    public void setMaterialKey(String materialKey) {
        this.materialKey = materialKey;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public Integer getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
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
        sb.append(", itemCategoryId=").append(itemCategoryId);
        sb.append(", attrCategoryId=").append(attrCategoryId);
        sb.append(", itemName=").append(itemName);
        sb.append(", itemUnit=").append(itemUnit);
        sb.append(", itemIntroduce=").append(itemIntroduce);
        sb.append(", thumbnailPic=").append(thumbnailPic);
        sb.append(", detailPic=").append(detailPic);
        sb.append(", planPic=").append(planPic);
        sb.append(", publishStatus=").append(publishStatus);
        sb.append(", price=").append(price);
        sb.append(", promotionPrice=").append(promotionPrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createOper=").append(createOper);
        sb.append(", updateOper=").append(updateOper);
        sb.append(", materialId=").append(materialId);
        sb.append(", materialKey=").append(materialKey);
        sb.append(", extInfo=").append(extInfo);
        sb.append(", saleAmount=").append(saleAmount);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}