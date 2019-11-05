package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.PmsItemAttrCategoryParams;
import com.shanyuan.model.PmsItemAttrCategory;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 16:02
 * <p>
 * desc
 **/
public interface PmsItemAttrCategoryService {
    int createItemAttrCategory(PmsItemAttrCategoryParams params);
    int updateItemAttrCategory(Integer id,PmsItemAttrCategoryParams params);
    int deleteItemAttrCategory(Integer id);
    PageInfo<PmsItemAttrCategory> listItemAttrCategory(BrandStoreParams params,Integer pageNum, Integer pageSize);
}
