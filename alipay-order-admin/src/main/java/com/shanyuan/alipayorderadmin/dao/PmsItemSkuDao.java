package com.shanyuan.alipayorderadmin.dao;

import com.shanyuan.model.PmsItemSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 14:29
 * <p>
 * desc
 **/
public interface PmsItemSkuDao {
    /*批量插入*/
    int insertList(@Param( "list" )List<PmsItemSku> list);
    /*批量更新*/
    int updateList(@Param( "list" )List<PmsItemSku> list);
    /*批量删除*/
    int deleteList(@Param( "ids" ) List<Integer> ids);
}
