package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.OmsOrderDetailResult;
import com.shanyuan.alipayorderadmin.dto.OmsOrderQueryParams;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 9:54
 * <p>
 * desc
 **/
public interface OmsOrderService {
    PageInfo<OmsOrder> listOrder(Integer pageNum, Integer pageSize, OmsOrderQueryParams params);
    List<OmsOrderDetailResult> listOrderDetail(Long orderId);
    @Transactional
    CommonResult unsubscribe(List<Integer> ids, Integer cancelStatus, String cancelDesc);
    int updateOrderStatus(Integer id,Integer orderStatus);
}
