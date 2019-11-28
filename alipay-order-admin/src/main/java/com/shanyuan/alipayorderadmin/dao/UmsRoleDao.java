package com.shanyuan.alipayorderadmin.dao;

import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.UmsRoleResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-12 9:07
 * <p>
 * desc
 **/
public interface UmsRoleDao {
    List<UmsRoleResult> listRole(@Param( "params" ) BrandStoreParams params);
}
