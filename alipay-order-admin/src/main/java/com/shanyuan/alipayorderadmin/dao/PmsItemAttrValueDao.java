package com.shanyuan.alipayorderadmin.dao;

import com.shanyuan.model.PmsItemAttrValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 14:25
 * <p>
 * desc
 **/
public interface PmsItemAttrValueDao {
    int insertList(@Param( "list" ) List<PmsItemAttrValue> list);
}
