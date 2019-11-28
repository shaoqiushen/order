package com.shanyuan.alipayorderinternal.dao;

import com.shanyuan.alipayorderinternal.dto.InternalStaffQueryParams;
import com.shanyuan.alipayorderinternal.dto.InternalStaffResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 11:34
 * <p>
 * desc
 **/
public interface InternalStaffDao {
    List<InternalStaffResult> listStaff(@Param( "params" ) InternalStaffQueryParams params);
}
