package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.CmsStoreParams;
import com.shanyuan.alipayorderadmin.dto.CmsStoreResult;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.CmsStore;
import org.springframework.transaction.annotation.Transactional;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 8:44
 * <p>
 * desc
 **/
public interface CmsStoreService {
    @Transactional
    CommonResult createStore(CmsStoreParams params);
    PageInfo<CmsStoreResult> listStore(Integer pageNum, Integer pageSize, Long brandId);

    int countStore(Long brandId);
}
