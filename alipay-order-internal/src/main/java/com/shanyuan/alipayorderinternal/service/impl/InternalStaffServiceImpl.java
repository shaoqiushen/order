package com.shanyuan.alipayorderinternal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.dao.InternalStaffDao;
import com.shanyuan.alipayorderinternal.dto.InternalStaffParams;
import com.shanyuan.alipayorderinternal.dto.InternalStaffQueryParams;
import com.shanyuan.alipayorderinternal.dto.InternalStaffResult;
import com.shanyuan.alipayorderinternal.service.InternalStaffService;
import com.shanyuan.mapper.MysStaffMapper;
import com.shanyuan.model.MysStaff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 10:25
 * <p>
 * desc
 **/
@Service
public class InternalStaffServiceImpl implements InternalStaffService {

    @Autowired
    MysStaffMapper mysStaffMapper;

    @Autowired
    InternalStaffDao internalStaffDao;

    @Override
    public int createStaff(InternalStaffParams params) {
        MysStaff mysStaff = new MysStaff();
        BeanUtils.copyProperties( params,mysStaff );
        return mysStaffMapper.insertSelective( mysStaff );
    }

    @Override
    public PageInfo <InternalStaffResult> listStaff(InternalStaffQueryParams params, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum,pageSize );
        List <InternalStaffResult> internalStaffResults=internalStaffDao.listStaff( params );
        PageInfo<InternalStaffResult> pageInfo = new PageInfo <>( internalStaffResults );
        return pageInfo;
    }


}
