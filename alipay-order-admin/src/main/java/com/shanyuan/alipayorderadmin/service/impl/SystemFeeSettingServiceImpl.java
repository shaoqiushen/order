package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.CmsDeliveryParams;
import com.shanyuan.alipayorderadmin.dto.CmsPackageParams;
import com.shanyuan.alipayorderadmin.service.SystemFeeSettingService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.mapper.CmsDeliveryMapper;
import com.shanyuan.mapper.CmsPackageMapper;
import com.shanyuan.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-04 10:23
 * <p>
 * desc
 **/
@Service
public class SystemFeeSettingServiceImpl implements SystemFeeSettingService {

    @Autowired
    CmsDeliveryMapper cmsDeliveryMapper;

    @Autowired
    CmsPackageMapper cmsPackageMapper;


    @Override
    public CommonResult createDelivery(CmsDeliveryParams params) {
        CmsDelivery cmsDelivery = new CmsDelivery();
        BeanUtils.copyProperties( params,cmsDelivery );
        CmsDelivery cmsDeliveryInfo=getCmsDelivery( params.getBrandId(), params.getStoreId(), 1 );
        if(cmsDeliveryInfo != null){
            return new CommonResult().failed( "已存在生效的茶位费信息" );
        }
        cmsDelivery.setCreateTime( new Date(  ) );
        int count=cmsDeliveryMapper.insertSelective( cmsDelivery );
        return ResultUtil.result( count );
    }

    @Override
    public CommonResult updateDelivery(Integer id, CmsDeliveryParams params) {
        CmsDelivery cmsDelivery = new CmsDelivery();
        BeanUtils.copyProperties( params,cmsDelivery );
        cmsDelivery.setId( id );
        CmsDelivery cmsDeliveryInfo=getCmsDelivery( params.getBrandId(), params.getStoreId(), 1 );
        if(cmsDeliveryInfo != null){
            if(cmsDeliveryInfo.getId() != id && params.getEnableStatus()==1){
                return new CommonResult().failed( "已存在生效的茶位费信息" );
            }
        }
        cmsDelivery.setUpdateTime( new Date(  ) );
        int count=cmsDeliveryMapper.updateByPrimaryKeySelective( cmsDelivery );
        return ResultUtil.result( count );
    }

    @Override
    public PageInfo<CmsDelivery> listDelivery(BrandStoreParams params, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        CmsDeliveryExample example = new CmsDeliveryExample();
        example.setOrderByClause( "id" );
        example.createCriteria().andBrandIdEqualTo( params.getBrandId() )
                .andStoreIdEqualTo( params.getStoreId() );
        List <CmsDelivery> cmsDeliveries=cmsDeliveryMapper.selectByExample( example );
        PageInfo<CmsDelivery> pageInfo = new PageInfo <>( cmsDeliveries );
        return pageInfo;
    }

    @Override
    public int deleteDelivery(Integer id) {
        return cmsDeliveryMapper.deleteByPrimaryKey( id );
    }

    @Override
    public CommonResult updateDeliveryStatus(Integer id, Integer enableStatus) {
        CmsDelivery cmsDelivery = new CmsDelivery();
        cmsDelivery.setId( id );
        cmsDelivery.setEnableStatus( enableStatus );
        if(enableStatus == 1){
            //说明要修改为启用状态//若系统中已存在 启用的数据//则修改失败
            CmsDelivery cmsDeliveryInfo=cmsDeliveryMapper.selectByPrimaryKey( id );
            if(cmsDeliveryInfo != null){
                return new CommonResult().failed( "系统中已存在启用的数据" );
            }
        }
        cmsDelivery.setUpdateTime( new Date(  ) );
        int count=cmsDeliveryMapper.updateByPrimaryKeySelective( cmsDelivery );
        return ResultUtil.result( count );
    }

    @Override
    public CmsDelivery getCmsDelivery(Long brandId, Integer storeId, Integer enableStatus) {
        CmsDeliveryExample example = new CmsDeliveryExample();
        example.createCriteria().andBrandIdEqualTo( brandId ).andStoreIdEqualTo( storeId ).andEnableStatusEqualTo( enableStatus );
        List<CmsDelivery> cmsDeliveries=cmsDeliveryMapper.selectByExample( example );
        if(cmsDeliveries.size()>0){
            return cmsDeliveries.get( 0 );
        }
        return null;
    }

    @Override
    public CommonResult createPackage(CmsPackageParams params) {
        CmsPackage cmsPackage = new CmsPackage();
        BeanUtils.copyProperties( params,cmsPackage );
        CmsPackage cmsPackageInfo=getCmsPackage( params.getBrandId(), params.getStoreId(), 1 );
        if(cmsPackageInfo != null){
            return new CommonResult().failed( "已存在生效的茶位费信息" );
        }
        cmsPackage.setCreateTime( new Date(  ) );
        int count=cmsPackageMapper.insertSelective( cmsPackage );
        return ResultUtil.result( count );
    }

    @Override
    public CommonResult updatePackage(Integer id, CmsPackageParams params) {
        CmsPackage cmsPackage = new CmsPackage();
        BeanUtils.copyProperties( params,cmsPackage );
        cmsPackage.setId( id );
        CmsPackage cmsPackageInfo=getCmsPackage( params.getBrandId(), params.getStoreId(), 1 );
        if(cmsPackageInfo != null){
            if(cmsPackageInfo.getId() != id && params.getEnableStatus()==1){
                return new CommonResult().failed( "已存在生效的茶位费信息" );
            }
        }
        cmsPackage.setUpdateTime(new Date(  ));
        int count=cmsPackageMapper.updateByPrimaryKeySelective( cmsPackage );
        return ResultUtil.result( count );
    }

    @Override
    public PageInfo <CmsPackage> listPackage(BrandStoreParams params, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        CmsPackageExample example = new CmsPackageExample();
        example.setOrderByClause( "id" );
        example.createCriteria().andBrandIdEqualTo( params.getBrandId() )
                .andStoreIdEqualTo( params.getStoreId() );
        List <CmsPackage> cmsPackages=cmsPackageMapper.selectByExample( example );
        PageInfo<CmsPackage> pageInfo = new PageInfo <>( cmsPackages );

        return pageInfo;
    }

    @Override
    public int deletePackage(Integer id) {
        return cmsPackageMapper.deleteByPrimaryKey( id );
    }

    @Override
    public CommonResult updatePackageStatus(Integer id, Integer enableStatus) {
        CmsPackage cmsPackage = new CmsPackage();
        cmsPackage.setId( id );
        cmsPackage.setEnableStatus( enableStatus );
        if(enableStatus == 1){
            //说明要修改为启用状态//若系统中已存在 启用的数据//则修改失败
            CmsPackage cmsPackageInfo=cmsPackageMapper.selectByPrimaryKey( id );
            if(cmsPackageInfo != null){
                return new CommonResult().failed( "系统中已存在启用的数据" );
            }
        }
        cmsPackage.setUpdateTime( new Date(  ) );
        int count=cmsPackageMapper.updateByPrimaryKeySelective( cmsPackage );
        return ResultUtil.result( count );
    }

    @Override
    public CmsPackage getCmsPackage(Long brandId, Integer storeId, Integer enableStatus) {
        CmsPackageExample example = new CmsPackageExample();
        example.createCriteria().andBrandIdEqualTo( brandId ).andStoreIdEqualTo( storeId ).andEnableStatusEqualTo( enableStatus );
        List<CmsPackage> cmsPackages=cmsPackageMapper.selectByExample( example );
        if(cmsPackages.size()>0){
            return cmsPackages.get( 0 );
        }
        return null;
    }
}
