package com.shanyuan.alipayorderadmin.service;

import com.shanyuan.common.domain.CommonResult;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-30 10:26
 * <p>
 * desc
 **/
public interface LoginService {
    CommonResult login(String account,String password);
}
