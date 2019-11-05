package com.shanyuan.alipayorderportal.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.model.CmsCarousel;
import com.shanyuan.model.PmsItem;
import com.shanyuan.model.PmsItemCategory;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 16:54
 * <p>
 * desc
 **/
public interface PortalHomeService {
    List<PmsItemCategory> listItemCategory(Long brandId,Integer storeId);
    PageInfo<PmsItem> listItem(Integer itemCategoryId, Integer pageNum, Integer pageSize);
    PageInfo<CmsCarousel> listCarousel(Long brandId,Integer position,Integer storeId,Integer pageNum, Integer pageSize);
}
