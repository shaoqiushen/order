package com.shanyuan.alipayorderadmin.shiro;

import com.shanyuan.alipayorderadmin.service.UmsOperService;
import com.shanyuan.mapper.UmsRoleMapper;
import com.shanyuan.model.UmsOper;
import com.shanyuan.model.UmsRole;
import com.shanyuan.model.UmsRoleExample;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    UmsRoleMapper umsRoleMapper;


    /*权限认证*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String)principalCollection.getPrimaryPrincipal();//账号
        UmsOper operInfo=umsOperService.getOperInfo( username );
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(operInfo.getRoleId()+"");
        //设置该用户拥有的角色

        authorizationInfo.setRoles( set );
        UmsRoleExample example = new UmsRoleExample();
        example.createCriteria().andIdEqualTo(operInfo.getRoleId() );
        List <UmsRole> umsRoles=umsRoleMapper.selectByExample( example );
        if(umsRoles.size()>0){
            UmsRole umsRole=umsRoles.get( 0 );
            String permission=umsRole.getPermission();
            String[] split=permission.split( "\\|" );
            for(String str : split){
                //添加权限
                authorizationInfo.addStringPermission( str );
            }
        }
        return authorizationInfo;
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
