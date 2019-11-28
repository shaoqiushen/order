package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.CmsTableParams;
import com.shanyuan.alipayorderadmin.service.CmsTableService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.mapper.CmsTableMapper;
import com.shanyuan.model.CmsTable;
import com.shanyuan.model.CmsTableExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 15:54
 * <p>
 * desc
 **/
@Service
public class CmsTableServiceImpl implements CmsTableService {

    @Autowired
    CmsTableMapper cmsTableMapper;

    @Override
    public CommonResult create(CmsTableParams params) {
        CmsTable cmsTable = new CmsTable();
        BeanUtils.copyProperties( params,cmsTable );
        CmsTable cmsTableInfo=getCmsTable( params.getBrandId(), params.getStoreId(), 1 );
        if(cmsTableInfo != null){
            return new CommonResult().failed( "已存在生效的茶位费信息" );
        }
        int count=cmsTableMapper.insertSelective( cmsTable );
        return ResultUtil.result( count );
    }

    @Override
    public PageInfo<CmsTable> list(BrandStoreParams params, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        CmsTableExample tableExample = new CmsTableExample();
        tableExample.setOrderByClause( "id" );
        tableExample.createCriteria().andBrandIdEqualTo( params.getBrandId() )
                .andStoreIdEqualTo( params.getStoreId() );
        List <CmsTable> cmsTables=cmsTableMapper.selectByExample( tableExample );
        PageInfo<CmsTable> pageInfo = new PageInfo <>( cmsTables );

        return pageInfo;
    }

    @Override
    public CommonResult updateEnableStatus(Integer id, Integer enableStatus) {
        CmsTable cmsTable = new CmsTable();
        cmsTable.setId( id );
        cmsTable.setEnableStatus( enableStatus );
        if(enableStatus == 1){
            //说明要修改为启用状态//若系统中已存在 启用的数据//则修改失败
            CmsTable cmsTableInfo=cmsTableMapper.selectByPrimaryKey( id );
            if(cmsTableInfo != null){
                CmsTableExample example = new CmsTableExample();
                example.createCriteria().andBrandIdEqualTo( cmsTableInfo.getBrandId() )
                        .andStoreIdEqualTo( cmsTableInfo.getStoreId() )
                        .andEnableStatusEqualTo( 1 );
                List <CmsTable> cmsTables=cmsTableMapper.selectByExample( example );
                if(cmsTables.size()>0){
                    return new CommonResult().failed( "系统中已存在启用的数据" );
                }
            }
        }
        int count=cmsTableMapper.updateByPrimaryKeySelective( cmsTable );
        return ResultUtil.result( count );
    }

    @Override
    public CommonResult update(Integer id, CmsTableParams params) {
        CmsTable cmsTable = new CmsTable();
        BeanUtils.copyProperties( params,cmsTable );
        cmsTable.setId( id );
        CmsTable cmsTableInfo=getCmsTable( params.getBrandId(), params.getStoreId(), 1 );
        if(cmsTableInfo != null){
            if(cmsTableInfo.getId() != id && params.getEnableStatus()==1){
                return new CommonResult().failed( "已存在生效的茶位费信息" );
            }
        }
        int count=cmsTableMapper.updateByPrimaryKeySelective( cmsTable );
        return ResultUtil.result( count );
    }

    @Override
    public int delete(Integer id) {
        return cmsTableMapper.deleteByPrimaryKey( id );
    }

    @Override
    public CmsTable getCmsTable(Long brandId, Integer storeId, Integer enableStatus) {
        CmsTableExample example =new CmsTableExample();
        example.createCriteria().andBrandIdEqualTo( brandId ).andStoreIdEqualTo( storeId ).andEnableStatusEqualTo( enableStatus );
        List <CmsTable> cmsTables=cmsTableMapper.selectByExample( example );
        if(cmsTables.size()>0){
            return cmsTables.get( 0 );
        }
        return null;
    }
}
