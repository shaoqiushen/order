package com.shanyuan.common.dao;

import com.shanyuan.common.domain.OmsOrderDetailResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-25 17:07
 * <p>
 * desc
 **/
public interface OrderDao {
    List<OmsOrderDetailResult> listOrderDetail(@Param("orderId") Long orderId);
}
