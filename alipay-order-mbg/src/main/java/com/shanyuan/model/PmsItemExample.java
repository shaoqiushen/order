package com.shanyuan.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PmsItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PmsItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Long value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Long value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Long value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Long value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Long value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Long value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Long> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Long> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Long value1, Long value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Long value1, Long value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Integer value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Integer value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Integer value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Integer value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Integer> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Integer> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Integer value1, Integer value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIsNull() {
            addCriterion("item_category_id is null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIsNotNull() {
            addCriterion("item_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdEqualTo(Integer value) {
            addCriterion("item_category_id =", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotEqualTo(Integer value) {
            addCriterion("item_category_id <>", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdGreaterThan(Integer value) {
            addCriterion("item_category_id >", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_category_id >=", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdLessThan(Integer value) {
            addCriterion("item_category_id <", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_category_id <=", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIn(List<Integer> values) {
            addCriterion("item_category_id in", values, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotIn(List<Integer> values) {
            addCriterion("item_category_id not in", values, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("item_category_id between", value1, value2, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_category_id not between", value1, value2, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdIsNull() {
            addCriterion("attr_category_id is null");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdIsNotNull() {
            addCriterion("attr_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdEqualTo(Integer value) {
            addCriterion("attr_category_id =", value, "attrCategoryId");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdNotEqualTo(Integer value) {
            addCriterion("attr_category_id <>", value, "attrCategoryId");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdGreaterThan(Integer value) {
            addCriterion("attr_category_id >", value, "attrCategoryId");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attr_category_id >=", value, "attrCategoryId");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdLessThan(Integer value) {
            addCriterion("attr_category_id <", value, "attrCategoryId");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("attr_category_id <=", value, "attrCategoryId");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdIn(List<Integer> values) {
            addCriterion("attr_category_id in", values, "attrCategoryId");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdNotIn(List<Integer> values) {
            addCriterion("attr_category_id not in", values, "attrCategoryId");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("attr_category_id between", value1, value2, "attrCategoryId");
            return (Criteria) this;
        }

        public Criteria andAttrCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attr_category_id not between", value1, value2, "attrCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemUnitIsNull() {
            addCriterion("item_unit is null");
            return (Criteria) this;
        }

        public Criteria andItemUnitIsNotNull() {
            addCriterion("item_unit is not null");
            return (Criteria) this;
        }

        public Criteria andItemUnitEqualTo(String value) {
            addCriterion("item_unit =", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotEqualTo(String value) {
            addCriterion("item_unit <>", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitGreaterThan(String value) {
            addCriterion("item_unit >", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitGreaterThanOrEqualTo(String value) {
            addCriterion("item_unit >=", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitLessThan(String value) {
            addCriterion("item_unit <", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitLessThanOrEqualTo(String value) {
            addCriterion("item_unit <=", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitLike(String value) {
            addCriterion("item_unit like", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotLike(String value) {
            addCriterion("item_unit not like", value, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitIn(List<String> values) {
            addCriterion("item_unit in", values, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotIn(List<String> values) {
            addCriterion("item_unit not in", values, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitBetween(String value1, String value2) {
            addCriterion("item_unit between", value1, value2, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemUnitNotBetween(String value1, String value2) {
            addCriterion("item_unit not between", value1, value2, "itemUnit");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceIsNull() {
            addCriterion("item_introduce is null");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceIsNotNull() {
            addCriterion("item_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceEqualTo(String value) {
            addCriterion("item_introduce =", value, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceNotEqualTo(String value) {
            addCriterion("item_introduce <>", value, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceGreaterThan(String value) {
            addCriterion("item_introduce >", value, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("item_introduce >=", value, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceLessThan(String value) {
            addCriterion("item_introduce <", value, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceLessThanOrEqualTo(String value) {
            addCriterion("item_introduce <=", value, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceLike(String value) {
            addCriterion("item_introduce like", value, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceNotLike(String value) {
            addCriterion("item_introduce not like", value, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceIn(List<String> values) {
            addCriterion("item_introduce in", values, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceNotIn(List<String> values) {
            addCriterion("item_introduce not in", values, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceBetween(String value1, String value2) {
            addCriterion("item_introduce between", value1, value2, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andItemIntroduceNotBetween(String value1, String value2) {
            addCriterion("item_introduce not between", value1, value2, "itemIntroduce");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicIsNull() {
            addCriterion("thumbnail_pic is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicIsNotNull() {
            addCriterion("thumbnail_pic is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicEqualTo(String value) {
            addCriterion("thumbnail_pic =", value, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicNotEqualTo(String value) {
            addCriterion("thumbnail_pic <>", value, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicGreaterThan(String value) {
            addCriterion("thumbnail_pic >", value, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicGreaterThanOrEqualTo(String value) {
            addCriterion("thumbnail_pic >=", value, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicLessThan(String value) {
            addCriterion("thumbnail_pic <", value, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicLessThanOrEqualTo(String value) {
            addCriterion("thumbnail_pic <=", value, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicLike(String value) {
            addCriterion("thumbnail_pic like", value, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicNotLike(String value) {
            addCriterion("thumbnail_pic not like", value, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicIn(List<String> values) {
            addCriterion("thumbnail_pic in", values, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicNotIn(List<String> values) {
            addCriterion("thumbnail_pic not in", values, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicBetween(String value1, String value2) {
            addCriterion("thumbnail_pic between", value1, value2, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andThumbnailPicNotBetween(String value1, String value2) {
            addCriterion("thumbnail_pic not between", value1, value2, "thumbnailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicIsNull() {
            addCriterion("detail_pic is null");
            return (Criteria) this;
        }

        public Criteria andDetailPicIsNotNull() {
            addCriterion("detail_pic is not null");
            return (Criteria) this;
        }

        public Criteria andDetailPicEqualTo(String value) {
            addCriterion("detail_pic =", value, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicNotEqualTo(String value) {
            addCriterion("detail_pic <>", value, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicGreaterThan(String value) {
            addCriterion("detail_pic >", value, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicGreaterThanOrEqualTo(String value) {
            addCriterion("detail_pic >=", value, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicLessThan(String value) {
            addCriterion("detail_pic <", value, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicLessThanOrEqualTo(String value) {
            addCriterion("detail_pic <=", value, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicLike(String value) {
            addCriterion("detail_pic like", value, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicNotLike(String value) {
            addCriterion("detail_pic not like", value, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicIn(List<String> values) {
            addCriterion("detail_pic in", values, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicNotIn(List<String> values) {
            addCriterion("detail_pic not in", values, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicBetween(String value1, String value2) {
            addCriterion("detail_pic between", value1, value2, "detailPic");
            return (Criteria) this;
        }

        public Criteria andDetailPicNotBetween(String value1, String value2) {
            addCriterion("detail_pic not between", value1, value2, "detailPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicIsNull() {
            addCriterion("plan_pic is null");
            return (Criteria) this;
        }

        public Criteria andPlanPicIsNotNull() {
            addCriterion("plan_pic is not null");
            return (Criteria) this;
        }

        public Criteria andPlanPicEqualTo(String value) {
            addCriterion("plan_pic =", value, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicNotEqualTo(String value) {
            addCriterion("plan_pic <>", value, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicGreaterThan(String value) {
            addCriterion("plan_pic >", value, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicGreaterThanOrEqualTo(String value) {
            addCriterion("plan_pic >=", value, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicLessThan(String value) {
            addCriterion("plan_pic <", value, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicLessThanOrEqualTo(String value) {
            addCriterion("plan_pic <=", value, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicLike(String value) {
            addCriterion("plan_pic like", value, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicNotLike(String value) {
            addCriterion("plan_pic not like", value, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicIn(List<String> values) {
            addCriterion("plan_pic in", values, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicNotIn(List<String> values) {
            addCriterion("plan_pic not in", values, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicBetween(String value1, String value2) {
            addCriterion("plan_pic between", value1, value2, "planPic");
            return (Criteria) this;
        }

        public Criteria andPlanPicNotBetween(String value1, String value2) {
            addCriterion("plan_pic not between", value1, value2, "planPic");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIsNull() {
            addCriterion("publish_status is null");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIsNotNull() {
            addCriterion("publish_status is not null");
            return (Criteria) this;
        }

        public Criteria andPublishStatusEqualTo(Integer value) {
            addCriterion("publish_status =", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotEqualTo(Integer value) {
            addCriterion("publish_status <>", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThan(Integer value) {
            addCriterion("publish_status >", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("publish_status >=", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThan(Integer value) {
            addCriterion("publish_status <", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThanOrEqualTo(Integer value) {
            addCriterion("publish_status <=", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIn(List<Integer> values) {
            addCriterion("publish_status in", values, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotIn(List<Integer> values) {
            addCriterion("publish_status not in", values, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusBetween(Integer value1, Integer value2) {
            addCriterion("publish_status between", value1, value2, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("publish_status not between", value1, value2, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceIsNull() {
            addCriterion("promotion_price is null");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceIsNotNull() {
            addCriterion("promotion_price is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceEqualTo(Integer value) {
            addCriterion("promotion_price =", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceNotEqualTo(Integer value) {
            addCriterion("promotion_price <>", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceGreaterThan(Integer value) {
            addCriterion("promotion_price >", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_price >=", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceLessThan(Integer value) {
            addCriterion("promotion_price <", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_price <=", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceIn(List<Integer> values) {
            addCriterion("promotion_price in", values, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceNotIn(List<Integer> values) {
            addCriterion("promotion_price not in", values, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceBetween(Integer value1, Integer value2) {
            addCriterion("promotion_price between", value1, value2, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_price not between", value1, value2, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateOperIsNull() {
            addCriterion("create_oper is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIsNotNull() {
            addCriterion("create_oper is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperEqualTo(String value) {
            addCriterion("create_oper =", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotEqualTo(String value) {
            addCriterion("create_oper <>", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperGreaterThan(String value) {
            addCriterion("create_oper >", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperGreaterThanOrEqualTo(String value) {
            addCriterion("create_oper >=", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLessThan(String value) {
            addCriterion("create_oper <", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLessThanOrEqualTo(String value) {
            addCriterion("create_oper <=", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperLike(String value) {
            addCriterion("create_oper like", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotLike(String value) {
            addCriterion("create_oper not like", value, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperIn(List<String> values) {
            addCriterion("create_oper in", values, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotIn(List<String> values) {
            addCriterion("create_oper not in", values, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperBetween(String value1, String value2) {
            addCriterion("create_oper between", value1, value2, "createOper");
            return (Criteria) this;
        }

        public Criteria andCreateOperNotBetween(String value1, String value2) {
            addCriterion("create_oper not between", value1, value2, "createOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIsNull() {
            addCriterion("update_oper is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIsNotNull() {
            addCriterion("update_oper is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperEqualTo(String value) {
            addCriterion("update_oper =", value, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperNotEqualTo(String value) {
            addCriterion("update_oper <>", value, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperGreaterThan(String value) {
            addCriterion("update_oper >", value, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperGreaterThanOrEqualTo(String value) {
            addCriterion("update_oper >=", value, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperLessThan(String value) {
            addCriterion("update_oper <", value, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperLessThanOrEqualTo(String value) {
            addCriterion("update_oper <=", value, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperLike(String value) {
            addCriterion("update_oper like", value, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperNotLike(String value) {
            addCriterion("update_oper not like", value, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIn(List<String> values) {
            addCriterion("update_oper in", values, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperNotIn(List<String> values) {
            addCriterion("update_oper not in", values, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperBetween(String value1, String value2) {
            addCriterion("update_oper between", value1, value2, "updateOper");
            return (Criteria) this;
        }

        public Criteria andUpdateOperNotBetween(String value1, String value2) {
            addCriterion("update_oper not between", value1, value2, "updateOper");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(String value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(String value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(String value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(String value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(String value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLike(String value) {
            addCriterion("material_id like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotLike(String value) {
            addCriterion("material_id not like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<String> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<String> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(String value1, String value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(String value1, String value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyIsNull() {
            addCriterion("material_key is null");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyIsNotNull() {
            addCriterion("material_key is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyEqualTo(String value) {
            addCriterion("material_key =", value, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyNotEqualTo(String value) {
            addCriterion("material_key <>", value, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyGreaterThan(String value) {
            addCriterion("material_key >", value, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyGreaterThanOrEqualTo(String value) {
            addCriterion("material_key >=", value, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyLessThan(String value) {
            addCriterion("material_key <", value, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyLessThanOrEqualTo(String value) {
            addCriterion("material_key <=", value, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyLike(String value) {
            addCriterion("material_key like", value, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyNotLike(String value) {
            addCriterion("material_key not like", value, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyIn(List<String> values) {
            addCriterion("material_key in", values, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyNotIn(List<String> values) {
            addCriterion("material_key not in", values, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyBetween(String value1, String value2) {
            addCriterion("material_key between", value1, value2, "materialKey");
            return (Criteria) this;
        }

        public Criteria andMaterialKeyNotBetween(String value1, String value2) {
            addCriterion("material_key not between", value1, value2, "materialKey");
            return (Criteria) this;
        }

        public Criteria andExtInfoIsNull() {
            addCriterion("ext_info is null");
            return (Criteria) this;
        }

        public Criteria andExtInfoIsNotNull() {
            addCriterion("ext_info is not null");
            return (Criteria) this;
        }

        public Criteria andExtInfoEqualTo(String value) {
            addCriterion("ext_info =", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotEqualTo(String value) {
            addCriterion("ext_info <>", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoGreaterThan(String value) {
            addCriterion("ext_info >", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoGreaterThanOrEqualTo(String value) {
            addCriterion("ext_info >=", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoLessThan(String value) {
            addCriterion("ext_info <", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoLessThanOrEqualTo(String value) {
            addCriterion("ext_info <=", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoLike(String value) {
            addCriterion("ext_info like", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotLike(String value) {
            addCriterion("ext_info not like", value, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoIn(List<String> values) {
            addCriterion("ext_info in", values, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotIn(List<String> values) {
            addCriterion("ext_info not in", values, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoBetween(String value1, String value2) {
            addCriterion("ext_info between", value1, value2, "extInfo");
            return (Criteria) this;
        }

        public Criteria andExtInfoNotBetween(String value1, String value2) {
            addCriterion("ext_info not between", value1, value2, "extInfo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}