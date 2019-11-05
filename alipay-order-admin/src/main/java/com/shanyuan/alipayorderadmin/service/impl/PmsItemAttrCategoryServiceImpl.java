package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.PmsItemAttrCategoryParams;
import com.shanyuan.alipayorderadmin.service.PmsItemAttrCategoryService;
import com.shanyuan.mapper.PmsItemAttrCategoryMapper;
import com.shanyuan.model.PmsItemAttrCategory;
import com.shanyuan.model.PmsItemAttrCategoryExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 16:02
 * <p>
 * desc
 **/
@Service
public class PmsItemAttrCategoryServiceImpl implements PmsItemAttrCategoryService {

    @Autowired
    PmsItemAttrCategoryMapper pmsItemAttrCategoryMapper;

    @Override
    public int createItemAttrCategory(PmsItemAttrCategoryParams params) {
        PmsItemAttrCategory itemAttrCategory = new PmsItemAttrCategory();
        BeanUtils.copyProperties( params,itemAttrCategory );
        return pmsItemAttrCategoryMapper.insertSelective( itemAttrCategory );
    }

    @Override
    public int updateItemAttrCategory(Integer id, PmsItemAttrCategoryParams params) {
        PmsItemAttrCategory pmsItemAttrCategory = new PmsItemAttrCategory();
        BeanUtils.copyProperties( params,pmsItemAttrCategory );
        pmsItemAttrCategory.setId( id );
        return pmsItemAttrCategoryMapper.updateByPrimaryKeySelective( pmsItemAttrCategory );
    }

    @Override
    public int deleteItemAttrCategory(Integer id) {
        return pmsItemAttrCategoryMapper.deleteByPrimaryKey( id );
    }

    @Override
    public PageInfo<PmsItemAttrCategory> listItemAttrCategory(BrandStoreParams params,Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        PmsItemAttrCategoryExample attrCategoryExample = new PmsItemAttrCategoryExample();
        attrCategoryExample.setOrderByClause( "id asc" );
        attrCategoryExample.createCriteria().andBrandIdEqualTo( params.getBrandId() ).andStoreIdEqualTo( params.getStoreId() );
        List <PmsItemAttrCategory> pmsItemAttrCategories=pmsItemAttrCategoryMapper.selectByExample( attrCategoryExample );
        PageInfo<PmsItemAttrCategory> pmsItemAttrCategoryPageInfo = new PageInfo <>( pmsItemAttrCategories );
        return pmsItemAttrCategoryPageInfo;
    }


}
