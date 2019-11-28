package com.shanyuan.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.common.domain.PmsItemParams;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.common.exception.DescribeException;
import com.shanyuan.common.service.ItemService;
import com.shanyuan.mapper.PmsItemAttrValueMapper;
import com.shanyuan.mapper.PmsItemCategoryMapper;
import com.shanyuan.mapper.PmsItemMapper;
import com.shanyuan.mapper.PmsItemSkuMapper;
import com.shanyuan.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 17:00
 * <p>
 * desc
 **/
@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    PmsItemCategoryMapper pmsItemCategoryMapper;

    @Autowired
    PmsItemMapper pmsItemMapper;

    @Autowired
    PmsItemSkuMapper pmsItemSkuMapper;

    @Autowired
    PmsItemAttrValueMapper pmsItemAttrValueMapper;


    @Override
    public List<PmsItemCategory> listItemCategory(Integer pageNum, Integer pageSize,int flag,Long brandId,Integer storeId) {
        if(flag == 1){
            PageHelper.startPage( pageNum,pageSize );
        }
        PmsItemCategoryExample categoryExample = new PmsItemCategoryExample();
        categoryExample.setOrderByClause( "id asc" );
        categoryExample.createCriteria().andBrandIdEqualTo( brandId ).andStoreIdEqualTo( storeId );
        return pmsItemCategoryMapper.selectByExample( categoryExample );
    }

    @Override
    public List <PmsItem> listItem(Integer itemCategoryId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        PmsItemExample itemExample = new PmsItemExample();
        itemExample.setOrderByClause( "id" );
        itemExample.createCriteria().andPublishStatusEqualTo( 1 ).andItemCategoryIdEqualTo( itemCategoryId ).andDeleteStatusEqualTo( 0 );
        return pmsItemMapper.selectByExample( itemExample );
    }

    @Override
    public PmsItemParams getItemDetail(Integer itemId) {
        PmsItemParams result=null;
        try {
            result=new PmsItemParams();
            //产品基本信息
            PmsItem itemInfo=this.getItemInfo( itemId );
            BeanUtils.copyProperties( itemInfo, result );
            //sku
            List <PmsItemSku> itemSkuInfo=this.getItemSkuInfo( itemId );
            result.setItemSkuList( itemSkuInfo );
            //规格属性
            List <PmsItemAttrValue> itemAttrValueInfo=this.getItemAttrValueInfo( itemId );
            result.setItemAttrValueList( itemAttrValueInfo );
        } catch ( Exception e ) {
            log.error( "getItemDetail error{}",e );
            throw new DescribeException( ExceptionEnum.QUERY_ERROR );
        }
        return result;
    }

    private PmsItem getItemInfo(Integer itemId){
        return pmsItemMapper.selectByPrimaryKey( itemId );
    }

    private List<PmsItemSku> getItemSkuInfo(Integer itemId){
        PmsItemSkuExample skuExample = new PmsItemSkuExample();
        skuExample.setOrderByClause( "id" );
        skuExample.createCriteria().andItemIdEqualTo( itemId );
        return pmsItemSkuMapper.selectByExample( skuExample );
    }

    private List<PmsItemAttrValue> getItemAttrValueInfo(Integer itemId){
        PmsItemAttrValueExample valueExample = new PmsItemAttrValueExample();
        valueExample.setOrderByClause( "id" );
        valueExample.createCriteria().andItemIdEqualTo( itemId );
        return pmsItemAttrValueMapper.selectByExample( valueExample );
    }
}
