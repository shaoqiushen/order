package com.shanyuan.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.common.service.StoreService;
import com.shanyuan.mapper.CmsStoreMapper;
import com.shanyuan.model.CmsStore;
import com.shanyuan.model.CmsStoreExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 9:03
 * <p>
 * desc
 **/
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    CmsStoreMapper cmsStoreMapper;


    @Override
    public List<CmsStore> listStore(Integer pageNum, Integer pageSize,Long brandId) {
        PageHelper.startPage( pageNum,pageSize );
        CmsStoreExample storeExample = new CmsStoreExample();
        storeExample.setOrderByClause( "open_status desc,id" );
        storeExample.createCriteria().andBrandIdEqualTo( brandId );
        return cmsStoreMapper.selectByExample( storeExample );
    }
}
