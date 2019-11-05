package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.PmsItemCategoryParams;
import com.shanyuan.alipayorderadmin.service.PmsItemCategoryService;
import com.shanyuan.mapper.PmsItemCategoryMapper;
import com.shanyuan.model.PmsItemCategory;
import com.shanyuan.model.PmsItemCategoryExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 16:00
 * <p>
 * desc
 **/
@Service
public class PmsItemCategoryServiceImpl implements PmsItemCategoryService {

    @Autowired
    PmsItemCategoryMapper pmsItemCategoryMapper;

    @Override
    public int createItemCategory(PmsItemCategoryParams params) {
        PmsItemCategory itemCategory = new PmsItemCategory();
        BeanUtils.copyProperties( params,itemCategory );
        itemCategory.setCreateTime( new Date(  ) );
        return pmsItemCategoryMapper.insertSelective( itemCategory );
    }

    @Override
    public PageInfo<PmsItemCategory> listItemCategory(BrandStoreParams params,Integer pageNum, Integer pageSize) {
        PmsItemCategoryExample categoryExample = new PmsItemCategoryExample();
        categoryExample.setOrderByClause( "sort asc,id asc" );
        categoryExample.createCriteria().andBrandIdEqualTo( params.getBrandId() ).andStoreIdEqualTo( params.getStoreId() );
        PageHelper.startPage( pageNum,pageSize );
        List <PmsItemCategory> pmsItemCategories=pmsItemCategoryMapper.selectByExample( categoryExample );
        PageInfo<PmsItemCategory> pmsItemCategoryPageInfo = new PageInfo <>( pmsItemCategories );
        return pmsItemCategoryPageInfo;
    }

    @Override
    public int deleteItemCategory(Integer id) {
        return pmsItemCategoryMapper.deleteByPrimaryKey( id );
    }

    @Override
    public int updateItemCategory(Integer id, PmsItemCategoryParams params) {
        PmsItemCategory pmsItemCategory = new PmsItemCategory();
        BeanUtils.copyProperties( params,pmsItemCategory );
        pmsItemCategory.setId( id );
        return pmsItemCategoryMapper.updateByPrimaryKeySelective( pmsItemCategory );
    }
}
