package com.shanyuan.alipayorderportal.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.domain.CartParam;
import com.shanyuan.alipayorderportal.dto.*;
import com.shanyuan.common.domain.PmsItemAttrValueResult;
import com.shanyuan.common.domain.PmsItemParams;
import com.shanyuan.model.OmsCart;
import com.shanyuan.model.PmsItem;
import com.shanyuan.model.PmsItemSku;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 15:19
 * <p>
 * desc
 **/
public interface PortalItemService {
    PmsItemParams getItemDetail(Integer itemId);
    List<PmsItemSku> getSkuInfo(List<CartParam> cartParamList);
    List<PmsItemAttrValueResult> getItemAttrValueInfo( Integer itemId);
    /*根据商品id规格获取商品价格*/
    List<PortalItemPriceStockResult> getItemPriceByAttribute(Integer itemId, PortalItemSkuPriceParams params);

    PageInfo<PmsItem> searchItem(PortalSearchItemParams params, Integer pageNum, Integer pageSize);

}
