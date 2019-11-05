package com.shanyuan.alipayorderadmin.service.impl;

import com.shanyuan.alipayorderadmin.service.LoginService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.mapper.CmsStoreMapper;
import com.shanyuan.mapper.UmsOperMapper;
import com.shanyuan.model.CmsStore;
import com.shanyuan.model.CmsStoreExample;
import com.shanyuan.model.UmsOper;
import com.shanyuan.model.UmsOperExample;
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
        UmsOperExample operExample=new UmsOperExample();
        operExample.createCriteria().andAccountEqualTo( account ).andPasswordEqualTo( password );
        List <UmsOper> umsOpers=umsOperMapper.selectByExample( operExample );
        if (umsOpers.size() == 0) {
            return new CommonResult().failed( "账号或密码不正确" );
        } else {
            brandId=umsOpers.get( 0 ).getBrandId();
            storeId=umsOpers.get( 0 ).getStoreId();
            type=umsOpers.get( 0 ).getType();
        }
        Map map=new HashMap();
        map.put( "brandId", brandId );
        map.put( "storeId", storeId );
        map.put( "type", type );
        return new CommonResult().success( map );
    }
}
