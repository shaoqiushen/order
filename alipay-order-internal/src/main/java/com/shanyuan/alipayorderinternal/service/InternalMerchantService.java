package com.shanyuan.alipayorderinternal.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.dto.InternalMerchantParams;
import com.shanyuan.alipayorderinternal.dto.InternalStoreParams;
import com.shanyuan.model.MysMerchant;
import com.shanyuan.model.MysStore;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 9:36
 * <p>
 * desc
 **/
public interface InternalMerchantService {
    int createMerchant(InternalMerchantParams params);
    int updateMerchant(Integer id,InternalMerchantParams params);
    PageInfo<MysMerchant> listMerchant(Integer pageNum,Integer pageSize,String merName);
    int deleteMerchant(Integer id);

    int createStore(InternalStoreParams params);
    int updateStore(Integer id,InternalStoreParams params);
    List<MysStore> listStore(Integer merId);
    int deleteStore(Integer id);
}
