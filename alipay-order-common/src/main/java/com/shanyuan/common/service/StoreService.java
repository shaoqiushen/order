package com.shanyuan.common.service;

import com.shanyuan.model.CmsStore;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 9:03
 * <p>
 * desc
 **/
public interface StoreService {
    List<CmsStore> listStore(Integer pageNum,Integer pageSize,Long brandId);
}
