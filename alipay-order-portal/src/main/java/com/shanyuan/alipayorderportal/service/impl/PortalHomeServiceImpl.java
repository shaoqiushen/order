package com.shanyuan.alipayorderportal.service.impl;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.dto.PortalHomeResult;
import com.shanyuan.alipayorderportal.service.PortalHomeService;
import com.shanyuan.common.service.CarouselService;
import com.shanyuan.common.service.ItemService;
import com.shanyuan.model.CmsCarousel;
import com.shanyuan.model.PmsItem;
import com.shanyuan.model.PmsItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 16:54
 * <p>
 * desc
 **/
@Service
public class PortalHomeServiceImpl implements PortalHomeService {

    @Autowired
    ItemService itemService;

    @Autowired
    CarouselService carouselService;

    @Override
    public List <PmsItemCategory> listItemCategory(Long brandId,Integer storeId) {
        return itemService.listItemCategory( 1,10,0,brandId,storeId );
    }

    @Override
    public PageInfo<PmsItem> listItem(Integer itemCategoryId, Integer pageNum, Integer pageSize) {
        List <PmsItem> pmsItems=itemService.listItem( itemCategoryId, pageNum, pageSize );
        PageInfo<PmsItem> pmsItemPageInfo = new PageInfo <>( pmsItems );
        return pmsItemPageInfo;
    }

    @Override
    public PageInfo <CmsCarousel> listCarousel(Long brandId,Integer position,Integer storeId, Integer pageNum, Integer pageSize) {
        List <CmsCarousel> cmsCarousels=carouselService.listCarousel( pageNum,pageSize,brandId,storeId,position );
        PageInfo<CmsCarousel> pageInfo = new PageInfo <>( cmsCarousels );
        return pageInfo;
    }


//    @Override
//    public PortalHomeResult getHomeContent(Integer pageNum, Integer pageSize, Integer itemCategoryId) {
//        PortalHomeResult result = new PortalHomeResult();
//        //获取分类列表
//        List <PmsItemCategory> pmsItemCategories=itemService.listItemCategory( pageNum, pageSize, 0 );//不分页
//        result.setItemCategoryList( pmsItemCategories );
//        //获取产品列表
//        List <PmsItem> pmsItems=itemService.listItem( itemCategoryId, pageNum, pageSize );
//        result.setItemList( pmsItems );
//        //获取首页轮播图
//
//        return result;
//    }


}
