package com.shanyuan.alipayorderportal.service;

import com.shanyuan.alipayorderportal.dto.PortalCartParams;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.OmsCart;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 17:05
 * <p>
 * desc
 **/
public interface PortalCartService {
    CommonResult createCart(PortalCartParams params);
    List<OmsCart> getCartInfo(Long brandId, String userId);
    int deleteCart(List<Integer> ids);
}
