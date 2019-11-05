package com.shanyuan.alipayorderportal.service.impl;

import com.shanyuan.alipayorderportal.service.PortalSystemFeeService;
import com.shanyuan.mapper.CmsDeliveryMapper;
import com.shanyuan.mapper.CmsPackageMapper;
import com.shanyuan.mapper.CmsTableMapper;
import com.shanyuan.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 17:13
 * <p>
 * desc
 **/
@Service
public class PortalSystemFeeServiceImpl implements PortalSystemFeeService {

    @Autowired
    CmsTableMapper cmsTableMapper;

    @Autowired
    CmsDeliveryMapper cmsDeliveryMapper;

    @Autowired
    CmsPackageMapper cmsPackageMapper;

    @Override
    public Integer getTableMoney(Long brandId, Integer storeId) {
        //查询是否有茶位费
        CmsTableExample tableExample = new CmsTableExample();
        tableExample.createCriteria().andBrandIdEqualTo( brandId ).andStoreIdEqualTo( storeId ).andEnableStatusEqualTo( 1 );
        List<CmsTable> cmsTables=cmsTableMapper.selectByExample( tableExample );
        if(cmsTables.size()>0){
            return cmsTables.get( 0 ).getPrice();
        }
        return null;
    }

    @Override
    public Integer getDelivery(Long brandId, Integer storeId) {
        //查询是否有茶位费
        CmsDeliveryExample cmsDeliveryExample = new CmsDeliveryExample();
        cmsDeliveryExample.createCriteria().andBrandIdEqualTo( brandId ).andStoreIdEqualTo( storeId ).andEnableStatusEqualTo( 1 );
        List<CmsDelivery> cmsDeliveries=cmsDeliveryMapper.selectByExample( cmsDeliveryExample );
        if(cmsDeliveries.size()>0){
            return cmsDeliveries.get( 0 ).getPrice();
        }
        return null;
    }

    @Override
    public Integer getPackage(Long brandId, Integer storeId) {
        //查询是否有茶位费
        CmsPackageExample cmsPackageExample = new CmsPackageExample();
        cmsPackageExample.createCriteria().andBrandIdEqualTo( brandId ).andStoreIdEqualTo( storeId ).andEnableStatusEqualTo( 1 );
        List<CmsPackage> cmsPackages=cmsPackageMapper.selectByExample( cmsPackageExample );
        if(cmsPackages.size()>0){
            return cmsPackages.get( 0 ).getPrice();
        }
        return null;
    }
}
