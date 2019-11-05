package com.shanyuan.common.service;

import com.shanyuan.model.CmsCarousel;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 10:24
 * <p>
 * desc
 **/
public interface CarouselService {
    List<CmsCarousel> listCarousel(Integer pageNum,Integer pageSize,Long brandId,Integer storeId,Integer position);
}
