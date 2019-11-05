package com.shanyuan.alipayorderportal.dao;

import com.shanyuan.model.OmsCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-18 16:18
 * <p>
 * desc
 **/
public interface PortalCartDao {
    int createCart(@Param( "list" ) List<OmsCart> cartList);
}
