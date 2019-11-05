package com.shanyuan.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.common.service.CarouselService;
import com.shanyuan.mapper.CmsCarouselMapper;
import com.shanyuan.model.CmsCarousel;
import com.shanyuan.model.CmsCarouselExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 10:24
 * <p>
 * desc
 **/
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    CmsCarouselMapper cmsCarouselMapper;

    @Override
    public List <CmsCarousel> listCarousel(Integer pageNum,Integer pageSize,Long brandId,Integer storeId,Integer position) {
        PageHelper.startPage( pageNum, pageSize );
        CmsCarouselExample cmsCarouselExample=new CmsCarouselExample();
        cmsCarouselExample.setOrderByClause( "sort asc,id asc" );
        CmsCarouselExample.Criteria criteria=cmsCarouselExample.createCriteria();
        criteria.andBrandIdEqualTo( brandId );
        if (position == -1) {
            //则是后台查询,需查全部//不做条件控制
        } else {
            if(position == 0){
                //查小程序首页轮播图不传店铺id
            }else {
                //查询小程序产品轮播图则需传店铺id
                criteria.andStoreIdEqualTo( storeId );
            }
            //前端查询
            criteria.andPositionEqualTo( position );
            criteria.andPublishStatusEqualTo( 1 );
        }

        return cmsCarouselMapper.selectByExample( cmsCarouselExample );
    }
}
