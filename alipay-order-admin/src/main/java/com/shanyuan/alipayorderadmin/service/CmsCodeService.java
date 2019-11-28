package com.shanyuan.alipayorderadmin.service;

import com.shanyuan.alipayorderadmin.dto.CmsCodeParams;

import javax.servlet.http.HttpServletResponse;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-05 17:54
 * <p>
 * desc
 **/
public interface CmsCodeService {
    int createCode(Long brandId,Integer storeId,String deskNo, HttpServletResponse response);
}
