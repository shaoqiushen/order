package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.UmsOperParams;
import com.shanyuan.alipayorderadmin.service.UmsOperService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.mapper.UmsOperMapper;
import com.shanyuan.model.UmsOper;
import com.shanyuan.model.UmsOperExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-30 10:06
 * <p>
 * desc
 **/
@Slf4j
@Service
public class UmsOperServiceImpl implements UmsOperService {

    @Autowired
    UmsOperMapper umsOperMapper;

    @Override
    public CommonResult createSubOper(UmsOperParams params) {
        UmsOper umsOper = new UmsOper();
        BeanUtils.copyProperties( params,umsOper );
        umsOper.setCreateTime( new Date(  ) );
        //查询账户是否存在了

        UmsOperExample operExample = new UmsOperExample();
        operExample.createCriteria().andAccountEqualTo( params.getAccount() );
        List <UmsOper> umsOpers=umsOperMapper.selectByExample( operExample );
        if(umsOpers.size() > 0){
            return new CommonResult().failed( "账号已存在，建议加上特定前缀" );
        }
        int count=umsOperMapper.insertSelective( umsOper );
        return ResultUtil.result( count );
    }

    @Override
    public CommonResult updateSubOper(Integer id, UmsOperParams params) {
        UmsOper umsOper = new UmsOper();
        BeanUtils.copyProperties( params,umsOper );
        umsOper.setId( id );
        umsOper.setUpdateTime( new Date(  ) );

        UmsOperExample operExample = new UmsOperExample();
        operExample.createCriteria().andAccountEqualTo( params.getAccount() );
        List <UmsOper> umsOpers=umsOperMapper.selectByExample( operExample );
        if(umsOpers.size() > 0){
            for(UmsOper oper : umsOpers){
                if(oper.getId() != id){
                    return new CommonResult().failed( "账号已存在，建议加上特定前缀" );
                }
            }
        }
        int count=umsOperMapper.updateByPrimaryKeySelective( umsOper );
        return ResultUtil.result( count );
    }

    @Override
    public PageInfo<UmsOper> listSubOper(Integer pageNum, Integer pageSize, Long brandId) {
        PageHelper.startPage( pageNum,pageSize );
        UmsOperExample operExample = new UmsOperExample();
        operExample.setOrderByClause( "id" );
        operExample.createCriteria().andBrandIdEqualTo( brandId );
        List <UmsOper> umsOpers=umsOperMapper.selectByExample( operExample );
        PageInfo<UmsOper> pageInfo = new PageInfo <>( umsOpers );
        return pageInfo;
    }

    @Override
    public int deleteSubOper(Integer id) {
        return umsOperMapper.deleteByPrimaryKey( id );
    }

    @Override
    public UmsOper getOperInfo(String account) {
        UmsOperExample operExample = new UmsOperExample();
        operExample.createCriteria().andAccountEqualTo( account );
        List <UmsOper> umsOpers=umsOperMapper.selectByExample( operExample );
        if(umsOpers.size() > 0){
            return umsOpers.get( 0 );
        }
        return null;
    }
}
