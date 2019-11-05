package com.shanyuan.model;

import java.io.Serializable;

public class PmsItemAttr implements Serializable {
    private Integer id;

    /**
     * 属性目录id
     *
     * @mbggenerated
     */
    private Integer attrgoryId;

    /**
     * 属性名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 可选属性值,多个用逗号分隔
     *
     * @mbggenerated
     */
    private String inputList;

    /**
     * 属性类型:0->规格;1->参数
     *
     * @mbggenerated
     */
    private Integer attrType;

    /**
     * 排序，值越小越靠前
     *
     * @mbggenerated
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttrgoryId() {
        return attrgoryId;
    }

    public void setAttrgoryId(Integer attrgoryId) {
        this.attrgoryId = attrgoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInputList() {
        return inputList;
    }

    public void setInputList(String inputList) {
        this.inputList = inputList;
    }

    public Integer getAttrType() {
        return attrType;
    }

    public void setAttrType(Integer attrType) {
        this.attrType = attrType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attrgoryId=").append(attrgoryId);
        sb.append(", name=").append(name);
        sb.append(", inputList=").append(inputList);
        sb.append(", attrType=").append(attrType);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}