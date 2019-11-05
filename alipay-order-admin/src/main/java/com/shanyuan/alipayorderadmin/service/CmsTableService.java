package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.CmsTableParams;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.CmsTable;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 15:54
 * <p>
 * desc
 **/
public interface CmsTableService {
    CommonResult create(CmsTableParams params);
    PageInfo<CmsTable> list(BrandStoreParams params,Integer pageNum,Integer pageSize);
    CommonResult updateEnableStatus(Integer id,Integer enableStatus);
    CommonResult update(Integer id,CmsTableParams params);
    int delete(Integer id);
    CmsTable getCmsTable(Long brandId,Integer storeId,Integer enableStatus);
}
