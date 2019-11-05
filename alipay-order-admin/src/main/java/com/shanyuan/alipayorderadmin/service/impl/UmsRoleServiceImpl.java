package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.UmsRoleParams;
import com.shanyuan.alipayorderadmin.service.UmsRoleService;
import com.shanyuan.mapper.UmsRoleMapper;
import com.shanyuan.model.UmsRole;
import com.shanyuan.model.UmsRoleExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-05 14:55
 * <p>
 * desc
 **/
@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired
    UmsRoleMapper umsRoleMapper;

    @Override
    public int create(UmsRoleParams params) {
        UmsRole umsRole = new UmsRole();
        BeanUtils.copyProperties( params,umsRole );
        return umsRoleMapper.insert( umsRole );
    }

    @Override
    public int delete(Integer id) {
        return umsRoleMapper.deleteByPrimaryKey( id );
    }

    @Override
    public int update(Integer id, UmsRoleParams params) {
        UmsRole umsRole = new UmsRole();
        BeanUtils.copyProperties( params,umsRole );
        umsRole.setId( id );
        return umsRoleMapper.updateByPrimaryKeySelective( umsRole );
    }

    @Override
    public PageInfo<UmsRole> list(Long brandId, Integer storeId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        UmsRoleExample example = new UmsRoleExample();
        example.setOrderByClause( "id" );
        UmsRoleExample.Criteria criteria=example.createCriteria();
        criteria.andBrandIdEqualTo( brandId );
        if(storeId != -1){
            criteria.andStoreIdEqualTo( storeId );
        }
        List <UmsRole> umsRoles=umsRoleMapper.selectByExample( example );
        PageInfo<UmsRole> pageInfo = new PageInfo <>( umsRoles );
        return pageInfo;
    }
}
