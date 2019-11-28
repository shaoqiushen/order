package com.shanyuan.alipayorderinternal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.dto.InternalMerchantParams;
import com.shanyuan.alipayorderinternal.dto.InternalStoreParams;
import com.shanyuan.alipayorderinternal.service.InternalMerchantService;
import com.shanyuan.mapper.MysMerchantMapper;
import com.shanyuan.mapper.MysStoreMapper;
import com.shanyuan.model.MysMerchant;
import com.shanyuan.model.MysMerchantExample;
import com.shanyuan.model.MysStore;
import com.shanyuan.model.MysStoreExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 9:36
 * <p>
 * desc
 **/
@Service
public class InternalMerchantServiceImpl implements InternalMerchantService {

    @Autowired
    MysMerchantMapper mysMerchantMapper;

    @Autowired
    MysStoreMapper mysStoreMapper;

    @Override
    public int createMerchant(InternalMerchantParams params) {
        MysMerchant mysMerchant = new MysMerchant();
        BeanUtils.copyProperties( params,mysMerchant );
        mysMerchant.setCreateTime( new Date(  ) );
        return mysMerchantMapper.insertSelective( mysMerchant );
    }

    @Override
    public int updateMerchant(Integer id, InternalMerchantParams params) {
        MysMerchant mysMerchant = new MysMerchant();
        BeanUtils.copyProperties( params,mysMerchant );
        mysMerchant.setId( id );
        mysMerchant.setUpdateTime( new Date(  ) );
        return mysMerchantMapper.updateByPrimaryKeySelective( mysMerchant );
    }

    @Override
    public PageInfo<MysMerchant> listMerchant(Integer pageNum, Integer pageSize, String merName) {
        PageHelper.startPage( pageNum,pageSize );
        MysMerchantExample example = new MysMerchantExample();
        example.setOrderByClause( "id" );
        MysMerchantExample.Criteria criteria=example.createCriteria();
        if(!StringUtils.isEmpty( merName )){
            criteria.andBusinessNameLike( "%"+merName+"%" );
        }
        List <MysMerchant> mysMerchants=mysMerchantMapper.selectByExample( example );
        PageInfo<MysMerchant> pageInfo = new PageInfo <>( mysMerchants );
        return pageInfo;
    }

    @Override
    public int deleteMerchant(Integer id) {
        return mysMerchantMapper.deleteByPrimaryKey( id );
    }

    @Override
    public int createStore(InternalStoreParams params) {
        MysStore mysStore = new MysStore();
        BeanUtils.copyProperties( params ,mysStore);
        mysStore.setCreateTime( new Date(  ) );
        return mysStoreMapper.insertSelective( mysStore );
    }

    @Override
    public int updateStore(Integer id, InternalStoreParams params) {
        MysStore mysStore = new MysStore();
        BeanUtils.copyProperties( params ,mysStore);
        mysStore.setId( id );
        mysStore.setUpdateTime( new Date(  ) );
        return mysStoreMapper.updateByPrimaryKeySelective( mysStore );
    }

    @Override
    public List<MysStore> listStore(Integer merId) {
        MysStoreExample example = new MysStoreExample();
        example.setOrderByClause( "id" );
        example.createCriteria().andMerIdEqualTo( merId );
        List <MysStore> mysStores=mysStoreMapper.selectByExample( example );
        return mysStores;
    }

    @Override
    public int deleteStore(Integer id) {
        return mysStoreMapper.deleteByPrimaryKey( id );
    }
}
