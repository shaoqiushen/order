package com.shanyuan.alipayorderinternal.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.dto.InternalStaffParams;
import com.shanyuan.alipayorderinternal.dto.InternalStaffQueryParams;
import com.shanyuan.alipayorderinternal.dto.InternalStaffResult;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 10:25
 * <p>
 * desc
 **/
public interface InternalStaffService {
    int createStaff(InternalStaffParams params);
    PageInfo<InternalStaffResult> listStaff(InternalStaffQueryParams params,Integer pageNum, Integer pageSize);
}
