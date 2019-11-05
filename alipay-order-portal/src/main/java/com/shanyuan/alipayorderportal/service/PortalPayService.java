package com.shanyuan.alipayorderportal.service;

import com.shanyuan.alipayorderportal.dto.PortalPayParams;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.OmsPrepay;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-18 9:58
 * <p>
 * desc
 **/
public interface PortalPayService {
    CommonResult payBuy(PortalPayParams params);
    void alipayNotify(String tradeNo,String outTradeNo);
    OmsPrepay payAgain(Long orderId);
}
