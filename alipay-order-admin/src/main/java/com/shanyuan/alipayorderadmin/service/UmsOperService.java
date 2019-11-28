package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.UmsOperParams;
import com.shanyuan.alipayorderadmin.dto.UmsOperResult;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.UmsOper;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-30 10:05
 * <p>
 * desc
 **/
public interface UmsOperService {
    //添加子管理员
    CommonResult createSubOper(UmsOperParams params);
    //修改子账号
    CommonResult updateSubOper(Integer id,UmsOperParams params);
    //查看子账户列表
    PageInfo<UmsOperResult> listSubOper(BrandStoreParams params, Integer pageNum, Integer pageSize );
    //删除子账户
    int deleteSubOper(Integer id);

    UmsOper getOperInfo(String account);
}
