package com.shanyuan.alipayorderadmin.dao;

import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.UmsOperResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-11 8:52
 * <p>
 * desc
 **/
public interface UmsOperDao {
    List<UmsOperResult> listSubOper(@Param( "params" ) BrandStoreParams params);
}
