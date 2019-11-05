package com.shanyuan.alipayorderadmin.dao;

import com.shanyuan.alipayorderadmin.dto.CmsStoreResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 14:41
 * <p>
 * desc
 **/
public interface CmsStoreDao {
    List<CmsStoreResult> listStoreAccount(@Param( "brandId" ) Long brandId);
}
