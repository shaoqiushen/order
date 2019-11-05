package com.shanyuan.model;

import java.io.Serializable;

public class CmsBrand implements Serializable {
    private Long id;

    /**
     * 品牌名称
     *
     * @mbggenerated
     */
    private String brandName;

    /**
     * 联系人
     *
     * @mbggenerated
     */
    private String concatName;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    private String concatPhone;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getConcatName() {
        return concatName;
    }

    public void setConcatName(String concatName) {
        this.concatName = concatName;
    }

    public String getConcatPhone() {
        return concatPhone;
    }

    public void setConcatPhone(String concatPhone) {
        this.concatPhone = concatPhone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandName=").append(brandName);
        sb.append(", concatName=").append(concatName);
        sb.append(", concatPhone=").append(concatPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}