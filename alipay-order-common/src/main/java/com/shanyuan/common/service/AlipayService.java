package com.shanyuan.common.service;

import com.shanyuan.common.domain.AlipayTradeParams;
import com.shanyuan.common.domain.AlipayTradeResult;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-23 10:40
 * <p>
 * desc
 **/
public interface AlipayService {
    AlipayTradeResult createTrade(AlipayTradeParams params);
}
