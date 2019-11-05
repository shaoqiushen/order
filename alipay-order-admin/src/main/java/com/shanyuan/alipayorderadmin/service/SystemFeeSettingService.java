package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.CmsDeliveryParams;
import com.shanyuan.alipayorderadmin.dto.CmsPackageParams;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.CmsDelivery;
import com.shanyuan.model.CmsPackage;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-04 10:23
 * <p>
 * desc
 **/
public interface SystemFeeSettingService {
    CommonResult createDelivery(CmsDeliveryParams params);
    CommonResult updateDelivery(Integer id,CmsDeliveryParams params);
    PageInfo<CmsDelivery> listDelivery(BrandStoreParams params,Integer pageNum,Integer pageSize);
    int deleteDelivery(Integer id);
    CommonResult updateDeliveryStatus(Integer id,Integer enableStatus);
    CmsDelivery getCmsDelivery(Long brandId, Integer storeId, Integer enableStatus);

    CommonResult createPackage(CmsPackageParams params);
    CommonResult updatePackage(Integer id,CmsPackageParams params);
    PageInfo<CmsPackage> listPackage(BrandStoreParams params, Integer pageNum, Integer pageSize);
    int deletePackage(Integer id);
    CommonResult updatePackageStatus(Integer id,Integer enableStatus);
    CmsPackage getCmsPackage(Long brandId, Integer storeId, Integer enableStatus);
}
