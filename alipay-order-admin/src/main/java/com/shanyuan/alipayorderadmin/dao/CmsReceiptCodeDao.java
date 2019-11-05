package com.shanyuan.alipayorderadmin.dao;

import com.shanyuan.alipayorderadmin.dto.CmsReceiptCodeResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 15:20
 * <p>
 * desc
 **/
public interface CmsReceiptCodeDao {
    List<CmsReceiptCodeResult> listReceiptCodeByStoreId(@Param( "storeId" )Integer storeId);
}
