package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.PmsItemCategoryParams;
import com.shanyuan.model.PmsItemCategory;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 16:00
 * <p>
 * desc
 **/
public interface PmsItemCategoryService {
    int createItemCategory(PmsItemCategoryParams params);
    PageInfo<PmsItemCategory> listItemCategory(BrandStoreParams params,Integer pageNum, Integer pageSize);
    int deleteItemCategory(Integer id);
    int updateItemCategory(Integer id,PmsItemCategoryParams params);
}
