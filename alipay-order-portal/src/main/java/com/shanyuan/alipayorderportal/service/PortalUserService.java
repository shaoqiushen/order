package com.shanyuan.alipayorderportal.service;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.dto.PortalObtainPhoneParams;
import com.shanyuan.alipayorderportal.dto.PortalUserAddressParams;
import com.shanyuan.alipayorderportal.dto.PortalUserAuthorizationParams;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.UmsAddress;
import com.shanyuan.model.UmsUser;
import org.springframework.transaction.annotation.Transactional;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 10:44
 * <p>
 * desc
 **/
public interface PortalUserService {
    @Transactional
    CommonResult createUserAddress(PortalUserAddressParams params);
    PageInfo<UmsAddress> listUserAddress(Integer pageNum,Integer pageSize,String userId);
    int deleteUserAddress(Integer id);
    int updateUserAddress(Integer id,PortalUserAddressParams params);
    UmsAddress getUserAddr(Integer id);

    CommonResult obtainPhone(PortalObtainPhoneParams prams);
    CommonResult authorization(PortalUserAuthorizationParams params);
    UmsUser getUserInfo(String userId);
    UmsUser getUserInfoByAliId(String aliUserId,Long brandId);
    int updatePhone(String userId,String telephone);
    boolean userExists(String userId);
}
