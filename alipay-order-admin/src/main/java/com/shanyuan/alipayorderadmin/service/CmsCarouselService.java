package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.CmsCarouselParams;
import com.shanyuan.model.CmsCarousel;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 9:45
 * <p>
 * desc
 **/
public interface CmsCarouselService {
    int createCarousel(CmsCarouselParams params);
    PageInfo<CmsCarousel> listCarousel(Integer pageNum,Integer pageSize,Long brandId,Integer storeId);
    int deleteCarousel(Integer id);
    int updateCarousel(Integer id,CmsCarouselParams params);
}
