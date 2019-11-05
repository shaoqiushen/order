package com.shanyuan.alipayorderportal.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.model.CmsStore;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-21 17:11
 * <p>
 * desc
 **/
public interface PortalStoreService {
    PageInfo<CmsStore> listStore(Integer pageNum,Integer pageSize,Long brandId);
    CmsStore getStoreInfo(Integer id);
}
