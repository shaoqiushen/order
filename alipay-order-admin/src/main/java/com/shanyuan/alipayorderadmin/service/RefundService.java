package com.shanyuan.alipayorderadmin.service;

import com.shanyuan.alipayorderadmin.domain.OrderRefund;
import com.shanyuan.alipayorderadmin.domain.ServerRefundResponse;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 9:18
 * <p>
 * desc
 **/
public interface RefundService {
    ServerRefundResponse refund(OrderRefund orderRefund);
}
