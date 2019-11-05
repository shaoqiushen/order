package com.shanyuan.alipayorderportal.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.service.PortalStoreService;
import com.shanyuan.mapper.CmsStoreMapper;
import com.shanyuan.model.CmsStore;
import com.shanyuan.model.CmsStoreExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-21 17:11
 * <p>
 * desc
 **/
@Service
public class PortalStoreServiceImpl implements PortalStoreService {

    @Autowired
    CmsStoreMapper cmsStoreMapper;

    @Override
    public PageInfo<CmsStore> listStore(Integer pageNum, Integer pageSize,Long brandId) {
        PageHelper.startPage( pageNum,pageSize );
        CmsStoreExample storeExample = new CmsStoreExample();
        storeExample.setOrderByClause( "id " );
        storeExample.createCriteria().andBrandIdEqualTo( brandId );
        List <CmsStore> cmsStores=cmsStoreMapper.selectByExample( storeExample );
        PageInfo<CmsStore> pageInfo = new PageInfo <>( cmsStores );
        return pageInfo;
    }

    @Override
    public CmsStore getStoreInfo(Integer id) {
        return cmsStoreMapper.selectByPrimaryKey( id );
    }
}
