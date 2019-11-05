package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.PmsItemAttrParams;
import com.shanyuan.model.PmsItemAttr;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 16:01
 * <p>
 * desc
 **/
public interface PmsItemAttrService {
    int createItemAttr(PmsItemAttrParams params);
    int updateItemAttr(Integer id,PmsItemAttrParams params);
    PageInfo<PmsItemAttr> listItemAttr(Integer attrCategoryId,Integer attrType,Integer pageNum,Integer pageSize);
    int deleteItemAttr(Integer id);
}
