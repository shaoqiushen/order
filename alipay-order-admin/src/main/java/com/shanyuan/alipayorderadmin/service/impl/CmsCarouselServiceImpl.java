package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.CmsCarouselParams;
import com.shanyuan.alipayorderadmin.service.CmsCarouselService;
import com.shanyuan.common.service.CarouselService;
import com.shanyuan.mapper.CmsCarouselMapper;
import com.shanyuan.model.CmsCarousel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 9:46
 * <p>
 * desc
 **/
@Service
public class CmsCarouselServiceImpl implements CmsCarouselService {

    @Autowired
    CmsCarouselMapper cmsCarouselMapper;

    @Autowired
    CarouselService carouselService;

    @Override
    public int createCarousel(CmsCarouselParams params) {
        CmsCarousel cmsCarousel=new CmsCarousel();
        BeanUtils.copyProperties( params, cmsCarousel );

        return cmsCarouselMapper.insert( cmsCarousel );
    }

    @Override
    public PageInfo<CmsCarousel> listCarousel(Integer pageNum, Integer pageSize, Long brandId,Integer storeId) {
        //position = -1 表示查询的后台的轮播图
        List <CmsCarousel> cmsCarousels=carouselService.listCarousel( pageNum,pageSize, brandId ,storeId,-1);
        PageInfo<CmsCarousel> pageInfo  = new PageInfo <>( cmsCarousels );
        return pageInfo;
    }

    @Override
    public int deleteCarousel(Integer id) {
        return cmsCarouselMapper.deleteByPrimaryKey( id );
    }

    @Override
    public int updateCarousel(Integer id, CmsCarouselParams params) {
        CmsCarousel cmsCarousel = new CmsCarousel();
        BeanUtils.copyProperties( params,cmsCarousel );
        cmsCarousel.setId( id );
        return cmsCarouselMapper.updateByPrimaryKeySelective( cmsCarousel );
    }
}
