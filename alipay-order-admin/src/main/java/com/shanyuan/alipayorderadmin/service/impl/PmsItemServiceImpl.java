package com.shanyuan.alipayorderadmin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.config.ServerConfig;
import com.shanyuan.alipayorderadmin.dao.PmsItemAttrValueDao;
import com.shanyuan.alipayorderadmin.dao.PmsItemSkuDao;
import com.shanyuan.alipayorderadmin.domain.AliImgResult;
import com.shanyuan.alipayorderadmin.domain.AliItemParams;
import com.shanyuan.alipayorderadmin.domain.AliSku;
import com.shanyuan.alipayorderadmin.domain.Material;
import com.shanyuan.alipayorderadmin.dto.AliImgParams;
import com.shanyuan.alipayorderadmin.service.PmsItemService;
import com.shanyuan.common.domain.PmsItemParams;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.common.exception.DescribeException;
import com.shanyuan.common.service.ItemService;
import com.shanyuan.common.utils.HttpUtils;
import com.shanyuan.common.utils.WebFileUtil;
import com.shanyuan.mapper.PmsItemAttrValueMapper;
import com.shanyuan.mapper.PmsItemMapper;
import com.shanyuan.mapper.PmsItemSkuMapper;
import com.shanyuan.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 15:39
 * <p>
 * desc
 **/
@Service
@Slf4j
public class PmsItemServiceImpl implements PmsItemService {

    @Autowired
    PmsItemMapper pmsItemMapper;

    @Autowired
    PmsItemAttrValueDao pmsItemAttrValueDao;

    @Autowired
    PmsItemSkuDao pmsItemSkuDao;

    @Autowired
    ItemService itemService;

    @Autowired
    PmsItemAttrValueMapper pmsItemAttrValueMapper;

    @Autowired
    PmsItemSkuMapper pmsItemSkuMapper;

    @Autowired
    ServerConfig serverConfig;

    @Override
    public int createItem(PmsItemParams params) {

        //创建产品基本信息
        PmsItem item=new PmsItem();
        BeanUtils.copyProperties( params, item );
        item.setCreateOper( params.getOper() );
        item.setCreateTime( new Date() );
        int count=pmsItemMapper.insertSelective( item );

        //创建产品sku信息
        //店铺先归属于默认、、后续区分再修改
        this.relateAndInsertList( pmsItemSkuDao, params.getItemSkuList(), item.getId(), item.getBrandId() ,0);

        //创建产品规格属性
        this.relateAndInsertList( pmsItemAttrValueDao, params.getItemAttrValueList(), item.getId(), item.getBrandId(),0 );
        try {
            //素材接口
            AliImgResult result=this.upload( params.getThumbnailPic(), item.getId(),params.getBrandId() );
            if(result.getStatus() == 1){
                //添加产品相应的素材id
                PmsItem pmsItem = new PmsItem();
                pmsItem.setMaterialId( result.getData().getMaterial_id() );
                pmsItem.setMaterialKey( result.getData().getMaterial_key() );
                pmsItem.setId( item.getId() );
                pmsItem.setExtInfo( JSONObject.toJSONString( params.getExt_info() ) );
                pmsItemMapper.updateByPrimaryKeySelective( pmsItem );

//                List<Material> material_list = new ArrayList <>(  );
//                Material material = new Material();
//                material.setType( "ITEM_PIC" );
//                material.setContent( result.getData().getMaterial_key() );
//                material_list.add( material );
//
//                List <PmsItemSku> itemSkuList=params.getItemSkuList();
//                List<AliSku> aliSkus = new ArrayList <>(  );
//                for(PmsItemSku sku : itemSkuList){
//                    AliSku aliSku = new AliSku();
//                    aliSku.setOriginal_price( sku.getPromotionPrice() );
//                    aliSku.setPrice( sku.getPrice() );
//                    aliSkus.add( aliSku );
//                }
//                //
//                AliItemParams itemParams = new AliItemParams();
//                itemParams.setExt_info( JSONObject.toJSONString( params.getExt_info() ) );
//                itemParams.setMaterial_list( JSONObject.toJSONString( material_list ) );
//                itemParams.setLocal_goods_id( String.valueOf( item.getId() ) );
//                itemParams.setName( item.getItemName() );
//                itemParams.setTarget_id( String.valueOf( params.getBrandId() ) );
//                itemParams.setSku_list( JSONObject.toJSONString( aliSkus ) );
//                itemParams.setStandard_category_id( params.getStandard_category_id() );
//                this.createAliItem( itemParams  );
            }
        } catch ( IOException e ) {
            log.error( "AliImgResult error{}",e );
            throw new DescribeException( ExceptionEnum.CREATE_ITEM_ERROR );
        }
        count=1;

        return count;
    }

    @Override
    public PmsItemParams getItemInfo(Integer itemId) {
        PmsItemParams itemDetail=itemService.getItemDetail( itemId );
        return itemDetail;
    }

    @Override
    public int updateItemInfo(Integer itemId, PmsItemParams params) {
        int count;
        try {
            count=0;
            //修改产品基本信息
            PmsItem pmsItem=new PmsItem();
            BeanUtils.copyProperties( params, pmsItem );
            pmsItem.setUpdateOper( params.getOper() );
            pmsItem.setUpdateTime( new Date() );
            pmsItem.setId( itemId );
            pmsItemMapper.updateByPrimaryKeySelective( pmsItem );
            //修改sku信息
            PmsItemSkuExample skuExample=new PmsItemSkuExample();
            skuExample.createCriteria().andItemIdEqualTo( itemId );
            List <PmsItemSku> pmsItemSkus=pmsItemSkuMapper.selectByExample( skuExample );
            this.sovleSkuInfo( pmsItemSkus, params.getItemSkuList(), itemId, params.getBrandId() );
            //修改规格属性
            PmsItemAttrValueExample attrValueExample=new PmsItemAttrValueExample();
            attrValueExample.createCriteria().andItemIdEqualTo( itemId );
            pmsItemAttrValueMapper.deleteByExample( attrValueExample );
            this.relateAndInsertList( pmsItemAttrValueDao, params.getItemAttrValueList(), itemId, params.getBrandId(),0 );
            count=1;
        } catch ( Exception e ) {

            throw new DescribeException( ExceptionEnum.UPDATE_ITEM_ERROR );
        }
        return count;
    }

    @Override
    public int updatePublishStatus(List <Integer> ids, Integer publishStatus) {
        PmsItemExample itemExample = new PmsItemExample();
        itemExample.createCriteria().andIdIn( ids );
        PmsItem pmsItem = new PmsItem();
        pmsItem.setPublishStatus( publishStatus );
        return pmsItemMapper.updateByExampleSelective( pmsItem,itemExample );
    }

    @Override
    public int deleteItem(List <Integer> ids) {
        PmsItemExample itemExample = new PmsItemExample();
        itemExample.createCriteria().andIdIn( ids );
        return pmsItemMapper.deleteByExample( itemExample );
    }

    @Override
    public PageInfo <PmsItem> listItem(Long brandId,Integer storeId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        PmsItemExample itemExample = new PmsItemExample();
        itemExample.createCriteria().andBrandIdEqualTo( brandId ).andStoreIdEqualTo( storeId );
        itemExample.setOrderByClause( "id" );
        List <PmsItem> pmsItems=pmsItemMapper.selectByExample( itemExample );
        PageInfo pageInfo = new PageInfo( pmsItems );
        return pageInfo;
    }

    public AliImgResult upload(String imgPath,Integer itemId,Long brandId) throws IOException {
        AliImgParams aliImgParams = new AliImgParams();
        aliImgParams.setImg_path( imgPath );
        aliImgParams.setLocal_goods_id( String.valueOf( itemId ) );
        aliImgParams.setAppid( String.valueOf( brandId ) );
        return this.uploadAliImg( aliImgParams );
    }
    @Override
    public AliImgResult uploadAliImg(AliImgParams aliImgParams) {

        StringBuffer sb = new StringBuffer(  );
        sb.append( "app="+aliImgParams.getApp() )
                .append( "&local_goods_id="+aliImgParams.getLocal_goods_id() )
                .append( "&appid="+aliImgParams.getAppid() )
                .append( "&scene="+aliImgParams.getScene() )
                .append( "&type="+aliImgParams.getType())
                .append( "&file_content_url="+aliImgParams.getImg_path() );
        String response=HttpUtils.getResponse( serverConfig.getServeraddr() + "/goods/fileupload", sb.toString() );
        AliImgResult aliImgResult=JSONObject.parseObject( response, AliImgResult.class );
        return aliImgResult;
    }

    @Override
    public void createAliItem(AliItemParams params) {
        StringBuffer sb = new StringBuffer(  );
        sb.append( "app="+params.getApp() )
                .append( "&ext_info="+ params.getExt_info()  )
                .append( "&goods_type="+params.getGoods_type() )
                .append( "&local_goods_id="+params.getLocal_goods_id() )
                .append( "&material_list="+params.getMaterial_list() )
                .append( "&name="+params.getName() )
//                .append( "&property_list="+ params.getProperty_list()  )
                .append( "&scene="+params.getScene() )
                .append( "&sku_list="+ params.getSku_list()  )
                .append( "&standard_category_id="+params.getStandard_category_id() )
                .append( "&target_id="+params.getTarget_id() )
                .append( "&target_type="+params.getTarget_type() )
                .append( "&type="+params.getType() );
        String response=HttpUtils.getResponse( serverConfig.getServeraddr() + "/goods/addgoods", sb.toString() );
        System.out.println(response);
    }

    /**
     * 建立和插入关系表操作
     *
     * @param dao      可以操作的dao
     * @param dataList 要插入的数据
     * @param itemId   建立关系的id
     */
    private void relateAndInsertList(Object dao, List dataList, Integer itemId, Long brandId, Integer storeId) {
        try {
            if (CollectionUtils.isEmpty( dataList )) return;
            for (Object item : dataList) {
                Method setId=item.getClass().getMethod( "setId", Integer.class );
                setId.invoke( item, ( Integer ) null );//id主键，数据自增，不用赋值
                Method setItemId=item.getClass().getMethod( "setItemId", Integer.class );
                setItemId.invoke( item, itemId );
                Method setBrandId=item.getClass().getMethod( "setBrandId", Long.class );
                setBrandId.invoke( item, brandId );
                //TODO
                Method setStoreId=item.getClass().getMethod( "setStoreId", Integer.class );
                setStoreId.invoke( item, storeId );
            }
            Method insertList=dao.getClass().getMethod( "insertList", List.class );
            insertList.invoke( dao, dataList );
        } catch ( Exception e ) {
            log.error( "创建产品出错:{}", e );
            throw new DescribeException( ExceptionEnum.CREATE_ITEM_ERROR );
        }
    }

    /**
     * descrition: TODO
     * create_user: shenshaoqiu
     * create_date: 2019/7/11
     * create_time: 11:40
     * param: pmsSkuStocks --原始规格集合 , skuStockList ----前端传入规格集合
     * return:
     **/
    private void sovleSkuInfo(List <PmsItemSku> pmsSkuStocks,List <PmsItemSku> skuStockList,Integer itemId,Long brandId){
        //需要删除的规格
        List<Integer> deleteIds = new ArrayList<>(  );
        //需要新增的规格
        List<PmsItemSku> addSkuList = new ArrayList <>(  );
        //需要更新的规格
        List<PmsItemSku> updateSkuList = new ArrayList <>(  );
        //存储已使用过的id
        Map<Integer,Integer> idMap = new HashMap<>(  );
        start: for(PmsItemSku skuStock : skuStockList) {
            if (skuStock.getId() == null) {
                //说明是新增的数据
                addSkuList.add( skuStock );
            }
            for (PmsItemSku pmsSkuStock : pmsSkuStocks) {
                if (skuStock.getId() == pmsSkuStock.getId()) {
                    //证明是更新的数据
                    updateSkuList.add( skuStock );
                    idMap.put( pmsSkuStock.getId(), pmsSkuStock.getId() );
                    continue start;
                } else {
                    if (idMap.get( pmsSkuStock.getId() ) == null) {
                        //说明是要删除的数据
                        deleteIds.add( pmsSkuStock.getId() );
                    }
                }
            }
        }
        //清除缓存
        idMap.clear();
        if(addSkuList.size()>0){
            //执行新增sku操作
            relateAndInsertList(pmsItemSkuDao,addSkuList,itemId,brandId,0);
        }
        if(updateSkuList.size()>0){
            //执行更新sku操作
            pmsItemSkuDao.updateList( updateSkuList );
        }
        if(deleteIds.size()>0){
            //执行删除sku操作
            pmsItemSkuDao.deleteList( deleteIds );
        }

    }

}
