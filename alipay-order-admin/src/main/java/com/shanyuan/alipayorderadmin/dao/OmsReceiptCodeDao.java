package com.shanyuan.alipayorderadmin.dao;

import com.shanyuan.alipayorderadmin.dto.OmsReceiptCodeResult;
import com.shanyuan.alipayorderadmin.dto.OmsReceiptQueryParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 10:48
 * <p>
 * desc
 **/
public interface OmsReceiptCodeDao {
    List<OmsReceiptCodeResult> listReceiptCode(@Param( "params" ) OmsReceiptQueryParams params);
}
