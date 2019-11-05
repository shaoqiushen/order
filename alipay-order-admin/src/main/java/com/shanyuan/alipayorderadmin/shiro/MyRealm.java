package com.shanyuan.alipayorderadmin.shiro;

import com.shanyuan.alipayorderadmin.service.UmsOperService;
import com.shanyuan.model.UmsOper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-05 11:15
 * <p>
 * desc
 **/
public class MyRealm extends AuthorizingRealm {

    @Autowired
    UmsOperService umsOperService;


    /*权限认证*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /*身份认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account=(String)token.getPrincipal();//获取账号
        String password=new String((char[])token.getCredentials());//获取密码
        //匹配账号密码是否正确
        UmsOper operInfo=umsOperService.getOperInfo( account );
        if(operInfo != null && password.equals( operInfo.getPassword() )){
            //返回成功实例
            return new SimpleAuthenticationInfo( account, password,getName());
        }else {
            throw new UnknownAccountException("账号或密码不正确");
        }
    }
}
