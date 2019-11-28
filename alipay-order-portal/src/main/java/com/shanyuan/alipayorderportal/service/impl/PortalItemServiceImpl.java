package com.shanyuan.alipayorderportal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.dao.PortalItemDao;
import com.shanyuan.alipayorderportal.domain.CartParam;
import com.shanyuan.alipayorderportal.dto.PortalItemPriceStockResult;
import com.shanyuan.alipayorderportal.dto.PortalItemSkuPriceParams;
import com.shanyuan.alipayorderportal.dto.PortalSearchItemParams;
import com.shanyuan.alipayorderportal.service.PortalItemService;
import com.shanyuan.common.domain.PmsItemAttrValueResult;
import com.shanyuan.common.domain.PmsItemParams;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.common.exception.DescribeException;
import com.shanyuan.common.service.ItemService;
import com.shanyuan.mapper.PmsItemMapper;
import com.shanyuan.mapper.PmsItemSkuMapper;
import com.shanyuan.model.PmsItem;
import com.shanyuan.model.PmsItemExample;
import com.shanyuan.model.PmsItemSku;
import com.shanyuan.model.PmsItemSkuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 15:19
 * <p>
 * desc
 **/
@Service
public class PortalItemServiceImpl implements PortalItemService {

    @Autowired
    ItemService itemService;

    @Autowired
    PortalItemDao portalItemDao;

    @Autowired
    PmsItemSkuMapper pmsItemSkuMapper;

    @Autowired
    PmsItemMapper pmsItemMapper;

    @Override
    public PmsItemParams getItemDetail(Integer itemId) {
        PmsItemParams result;
        try {
            result=itemService.getItemDetail( itemId );
        } catch ( Exception e ) {
            throw new DescribeException( ExceptionEnum.QUERY_ERROR );
        }
        return result;
    }

    @Override
    public List<PmsItemSku> getSkuInfo(List<CartParam> cartParamList) {
        List <PmsItemSku> itemSkuInfo=portalItemDao.getItemSkuInfo( cartParamList );
        return itemSkuInfo;
    }

    @Override
    public List <PmsItemAttrValueResult> getItemAttrValueInfo(Integer itemId) {
        return portalItemDao.getItemAttrValueInfo( itemId );
    }

    @Override
    public List <PortalItemPriceStockResult> getItemPriceByAttribute(Integer itemId, PortalItemSkuPriceParams params) {
        String sp1 = params.getSp1();
        String sp2 = params.getSp2();
        String sp3 = params.getSp3();
        PmsItemSkuExample example = new PmsItemSkuExample();
        PmsItemSkuExample.Criteria criteria=example.createCriteria();
        if(!StringUtils.isEmpty( sp1 )){
            criteria.andSp1EqualTo( sp1 );
        }
        if(!StringUtils.isEmpty( sp2 )){
            criteria.andSp2EqualTo( sp2 );
        }
        if(!StringUtils.isEmpty( sp3 )){
            criteria.andSp3EqualTo( sp3 );
        }

        criteria.andItemIdEqualTo( itemId );
        List <PmsItemSku> pmsItemSkus=pmsItemSkuMapper.selectByExample( example );
        List<PortalItemPriceStockResult> list = new ArrayList<>(  );
        PortalItemPriceStockResult result = new PortalItemPriceStockResult();
        for(PmsItemSku pmsItemSku : pmsItemSkus){
            result.setPrice( pmsItemSku.getPrice() );
            result.setPromotionPrice( pmsItemSku.getPromotionPrice() );
            result.setStock( pmsItemSku.getStock() );
            result.setSkuId( pmsItemSku.getId() );
            list.add( result );
        }
        return list;
    }

    @Override
    public PageInfo<PmsItem> searchItem(PortalSearchItemParams params, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        PmsItemExample example = new PmsItemExample();
        PmsItemExample.Criteria criteria=example.createCriteria();
        criteria.andBrandIdEqualTo( params.getBrandId() ).andStoreIdEqualTo( params.getStoreId() ).andDeleteStatusEqualTo( 0 );
        if(!StringUtils.isEmpty( params.getKeywords() )){
            criteria.andItemNameLike( "%"+params.getKeywords()+"%" );
        }
        example.setOrderByClause( "id" );
        List <PmsItem> pmsItems=pmsItemMapper.selectByExample( example );
        PageInfo<PmsItem> pmsItemPageInfo = new PageInfo <>( pmsItems );
        return pmsItemPageInfo;
    }


}
