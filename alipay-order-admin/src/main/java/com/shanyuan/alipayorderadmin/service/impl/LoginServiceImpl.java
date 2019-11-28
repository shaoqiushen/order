package com.shanyuan.alipayorderadmin.service.impl;

import com.shanyuan.alipayorderadmin.service.LoginService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.mapper.CmsStoreMapper;
import com.shanyuan.mapper.UmsOperMapper;
import com.shanyuan.mapper.UmsRoleMapper;
import com.shanyuan.model.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-30 10:26
 * <p>
 * desc
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UmsOperMapper umsOperMapper;

    @Autowired
    CmsStoreMapper cmsStoreMapper;

    @Autowired
    UmsRoleMapper umsRoleMapper;

    @Override
    public CommonResult login(String account, String password) {
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        //交给shiro执行登录
        try{
            subject.login(token);
        }catch ( AuthenticationException e ){
            return new CommonResult().error( ExceptionEnum.ACCPAS_ERROR );
        }
        Long brandId=null;
        Integer storeId=null;
        int type=0;//0超级管理员;//1普通管理员
        String permission = "";
        UmsOperExample operExample=new UmsOperExample();
        operExample.createCriteria().andAccountEqualTo( account ).andPasswordEqualTo( password );
        List <UmsOper> umsOpers=umsOperMapper.selectByExample( operExample );
        if (umsOpers.size() == 0) {
            return new CommonResult().failed( "账号或密码不正确" );
        } else {
            UmsOper umsOper=umsOpers.get( 0 );
            brandId=umsOper.getBrandId();
            storeId=umsOper.getStoreId();
            type=umsOper.getType();
            Integer roleId=umsOper.getRoleId();
            UmsRole umsRole=umsRoleMapper.selectByPrimaryKey( roleId );
            permission = umsRole.getPermission();
        }
        Map map=new HashMap();
        map.put( "brandId", brandId );
        map.put( "storeId", storeId );
        map.put( "type", type );
        map.put( "permission",permission );
        return new CommonResult().success( map );
    }
}
