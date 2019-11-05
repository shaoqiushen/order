package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dao.CmsStoreDao;
import com.shanyuan.alipayorderadmin.dto.CmsStoreParams;
import com.shanyuan.alipayorderadmin.dto.CmsStoreResult;
import com.shanyuan.alipayorderadmin.service.CmsStoreService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.service.StoreService;
import com.shanyuan.common.utils.BaiduUtil;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.mapper.CmsStoreMapper;
import com.shanyuan.mapper.UmsOperMapper;
import com.shanyuan.model.CmsStore;
import com.shanyuan.model.CmsStoreExample;
import com.shanyuan.model.UmsOper;
import com.shanyuan.model.UmsOperExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 8:44
 * <p>
 * desc
 **/
@Service
public class CmsStoreServiceImpl implements CmsStoreService {

    @Autowired
    CmsStoreMapper cmsStoreMapper;

    @Autowired
    StoreService storeService;

    @Autowired
    UmsOperMapper umsOperMapper;

    @Autowired
    CmsStoreDao cmsStoreDao;


    @Override
    public CommonResult createStore(CmsStoreParams params) {

        //查询
//        CmsStoreExample storeExample = new CmsStoreExample();
//        storeExample.createCriteria().andAccountEqualTo( params.getAccount() );
//        List <CmsStore> cmsStores=cmsStoreMapper.selectByExample( storeExample );
        UmsOperExample example = new UmsOperExample();
        example.createCriteria().andAccountEqualTo( params.getAccount() );
        List <UmsOper> umsOpers=umsOperMapper.selectByExample( example );
        if(umsOpers.size() >0){
            return new CommonResult().failed( "账号已经存在，建议加上特定前缀" );
        }
        CmsStore cmsStore = new CmsStore();
        BeanUtils.copyProperties( params,cmsStore );
        Map <String, Double> map=BaiduUtil.getLngAndLat( params.getStoreAddr() );
        Double lng=map.get( "lng" );
        Double lat=map.get( "lat" );
        cmsStore.setLongitude( new BigDecimal( lng ) );
        cmsStore.setLatitude( new BigDecimal( lat ) );
        int count=cmsStoreMapper.insertSelective( cmsStore );

        UmsOper umsOper = new UmsOper();
        BeanUtils.copyProperties( params,umsOper );
        umsOper.setType( 1 );//子管理员
        umsOper.setCreateTime( new Date(  ) );
        umsOper.setStoreId( cmsStore.getId() );
        count=umsOperMapper.insertSelective( umsOper );
        return ResultUtil.result( count );
    }

    @Override
    public PageInfo<CmsStoreResult> listStore(Integer pageNum, Integer pageSize,Long brandId) {
//        List <CmsStore> cmsStores=storeService.listStore( pageNum, pageSize,brandId );
        PageHelper.startPage( pageNum, pageSize );
        List <CmsStoreResult> cmsStoreResults=cmsStoreDao.listStoreAccount( brandId );
        PageInfo<CmsStoreResult> pageInfo = new PageInfo <>( cmsStoreResults );
        return pageInfo;
    }

    @Override
    public int countStore(Long brandId) {
        CmsStoreExample example = new CmsStoreExample();
        example.createCriteria().andBrandIdEqualTo( brandId );
        int count=cmsStoreMapper.countByExample( example );
        return count;
    }
}
