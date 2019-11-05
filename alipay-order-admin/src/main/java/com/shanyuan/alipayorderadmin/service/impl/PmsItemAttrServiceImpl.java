package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.PmsItemAttrParams;
import com.shanyuan.alipayorderadmin.service.PmsItemAttrService;
import com.shanyuan.mapper.PmsItemAttrMapper;
import com.shanyuan.model.PmsItemAttr;
import com.shanyuan.model.PmsItemAttrExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 16:22
 * <p>
 * desc
 **/
@Service
public class PmsItemAttrServiceImpl implements PmsItemAttrService {

    @Autowired
    PmsItemAttrMapper pmsItemAttrMapper;

    @Override
    public int createItemAttr(PmsItemAttrParams params) {
        PmsItemAttr itemAttr = new PmsItemAttr();
        BeanUtils.copyProperties( params,itemAttr );
        return pmsItemAttrMapper.insertSelective( itemAttr );
    }

    @Override
    public int updateItemAttr(Integer id, PmsItemAttrParams params) {

        PmsItemAttr pmsItemAttr = new PmsItemAttr();
        BeanUtils.copyProperties( params,pmsItemAttr );
        pmsItemAttr.setId( id );
        return pmsItemAttrMapper.updateByPrimaryKeySelective( pmsItemAttr );
    }

    @Override
    public PageInfo<PmsItemAttr> listItemAttr(Integer attrCategoryId,Integer attrType,Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        PmsItemAttrExample attrExample = new PmsItemAttrExample();
        attrExample.setOrderByClause( "sort asc,id asc" );
        attrExample.createCriteria().andAttrgoryIdEqualTo( attrCategoryId )
        .andAttrTypeEqualTo( attrType );
        List <PmsItemAttr> pmsItemAttrs=pmsItemAttrMapper.selectByExample( attrExample );
        PageInfo<PmsItemAttr> pmsItemAttrPageInfo = new PageInfo <>( pmsItemAttrs );
        return pmsItemAttrPageInfo;
    }

    @Override
    public int deleteItemAttr(Integer id) {
        return pmsItemAttrMapper.deleteByPrimaryKey( id );
    }
}
