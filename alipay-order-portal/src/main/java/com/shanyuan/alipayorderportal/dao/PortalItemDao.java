package com.shanyuan.alipayorderportal.dao;

import com.shanyuan.alipayorderportal.domain.CartParam;
import com.shanyuan.common.domain.PmsItemAttrValueResult;
import com.shanyuan.model.OmsCart;
import com.shanyuan.model.PmsItemSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 17:45
 * <p>
 * desc
 **/
public interface PortalItemDao {
    List<PmsItemSku> getItemSkuInfo(@Param( "list" ) List<CartParam> cartParamList);
    List<PmsItemAttrValueResult> getItemAttrValueInfo(@Param( "itemId" ) Integer itemId);
}
