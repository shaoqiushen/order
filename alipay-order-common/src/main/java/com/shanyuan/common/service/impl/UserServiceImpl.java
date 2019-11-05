package com.shanyuan.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.common.service.UserService;
import com.shanyuan.mapper.UmsAddressMapper;
import com.shanyuan.model.UmsAddress;
import com.shanyuan.model.UmsAddressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 10:52
 * <p>
 * desc
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UmsAddressMapper umsAddressMapper;

    @Override
    public List<UmsAddress> listUserAddress(Integer pageNum, Integer pageSize, String userId) {
        PageHelper.startPage( pageNum,pageSize );
        UmsAddressExample addressExample = new UmsAddressExample();
        UmsAddressExample.Criteria criteria=addressExample.createCriteria();
        if(!StringUtils.isEmpty( userId )){
            criteria.andUserIdEqualTo( userId );
        }
        addressExample.setOrderByClause( "type desc,id asc" );
        return umsAddressMapper.selectByExample( addressExample );
    }
}
