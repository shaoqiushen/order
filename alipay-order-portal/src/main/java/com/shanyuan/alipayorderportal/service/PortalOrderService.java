package com.shanyuan.alipayorderportal.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.dto.PortalOrderDetailResult;
import com.shanyuan.alipayorderportal.dto.PortalOrderParams;
import com.shanyuan.alipayorderportal.dto.PortalOrderQueryParams;
import com.shanyuan.alipayorderportal.dto.PortalOrderQueryResult;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 11:44
 * <p>
 * desc
 **/
public interface PortalOrderService {
    @Transactional
    CommonResult create(PortalOrderParams params);
    int deleteOrder(Long orderId);
    int insertOrder(OmsOrder omsOrder);
    int insertOrderDetail(List<OmsOrderDetail> omsOrderDetails);
    OmsOrder getOrderInfo(Long orderId);
    PageInfo<OmsOrder> listUserOrder(PortalOrderQueryParams params, Integer pageNum, Integer pageSize);
    PortalOrderDetailResult getUserOrderDetail(Long orderId);
    PageInfo<PortalOrderQueryResult> listOrderInfoByParams(PortalOrderQueryParams portalOrderQueryParams, Integer pageNum, Integer pageSize);
    int cancelOrder(Long orderId);


}
