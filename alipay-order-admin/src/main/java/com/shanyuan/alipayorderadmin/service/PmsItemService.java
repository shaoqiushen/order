package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.domain.AliImgResult;
import com.shanyuan.alipayorderadmin.domain.AliItemParams;
import com.shanyuan.alipayorderadmin.dto.AliImgParams;
import com.shanyuan.common.domain.PmsItemParams;
import com.shanyuan.model.PmsItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 16:06
 * <p>
 * desc
 **/
public interface PmsItemService {
    @Transactional
    int createItem(PmsItemParams params);
    PmsItemParams getItemInfo(Integer itemId);
    @Transactional
    int updateItemInfo(Integer itemId,PmsItemParams params);
    int updatePublishStatus(List<Integer> ids,Integer publishStatus);
    int deleteItem(List<Integer> ids);
    PageInfo<PmsItem> listItem(Long brandId,Integer storeId, Integer pageNum, Integer pageSize);

    //
    //阿里素材接口
    AliImgResult uploadAliImg(AliImgParams aliImgParams);
    //阿里创建商品接口
    void createAliItem(AliItemParams params);
}
