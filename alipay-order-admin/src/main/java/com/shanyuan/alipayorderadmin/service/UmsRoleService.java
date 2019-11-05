package com.shanyuan.alipayorderadmin.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.UmsRoleParams;
import com.shanyuan.model.UmsRole;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-05 14:55
 * <p>
 * desc
 **/
public interface UmsRoleService {
    //创建角色
    int create(UmsRoleParams params);
    //删除角色
    int delete(Integer id);
    //修改角色
    int update(Integer id, UmsRoleParams params);
    //角色列表
    PageInfo<UmsRole> list(Long brandId, Integer storeId, Integer pageNum, Integer pageSize);
}
