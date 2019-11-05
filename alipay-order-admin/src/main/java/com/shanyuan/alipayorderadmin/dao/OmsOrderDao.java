package com.shanyuan.alipayorderadmin.dao;

import com.shanyuan.alipayorderadmin.dto.OmsOrderDetailResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-25 17:07
 * <p>
 * desc
 **/
public interface OmsOrderDao {
    List<OmsOrderDetailResult> listOrderDetail(@Param( "orderId" ) Long orderId);
    List<OmsOrderDetailResult> getOrderInfo(@Param( "ids" ) List<Integer> ids);
}
