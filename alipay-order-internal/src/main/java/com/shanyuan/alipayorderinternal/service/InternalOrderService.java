package com.shanyuan.alipayorderinternal.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.common.domain.OmsOrderDetailResult;
import com.shanyuan.common.domain.OmsOrderQueryParams;
import com.shanyuan.model.OmsOrder;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-07 17:52
 * <p>
 * desc
 **/
public interface InternalOrderService {
    PageInfo<OmsOrder> listOrder(Integer pageNum, Integer pageSize, OmsOrderQueryParams params);
    List<OmsOrderDetailResult> listOrderDetail(Long orderId);
}
