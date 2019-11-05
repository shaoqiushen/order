package com.shanyuan.common.service;

import com.shanyuan.common.domain.PmsItemParams;
import com.shanyuan.model.PmsItem;
import com.shanyuan.model.PmsItemCategory;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 17:00
 * <p>
 * desc
 **/
public interface ItemService {
    //查询产品分类列表
    List<PmsItemCategory> listItemCategory(Integer pageNum,Integer pageSize,int flag,Long brandId,Integer storeId);
    //根据产品分类id查询相应产品信息
    List<PmsItem> listItem(Integer itemCategoryId,Integer pageNum,Integer pageSize);

    //根据产品id查询产品详情信息
    PmsItemParams getItemDetail(Integer itemId);
}
