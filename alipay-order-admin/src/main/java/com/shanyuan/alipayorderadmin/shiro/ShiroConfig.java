package com.shanyuan.alipayorderadmin.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-05 11:28
 * <p>
 * desc
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFileter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager( securityManager );

        //设置未登陆的时候跳转地址
        shiroFilterFactoryBean.setLoginUrl( "/login/notLogin" );
        //设置登陆成功后跳转地址
        //shiroFilterFactoryBean.setSuccessUrl( "/login/loginSuc" );
        //设置无权限时跳转的地址
        shiroFilterFactoryBean.setUnauthorizedUrl( "/login/unAuth" );


        //配置拦截器
        Map<String, Filter> filterMap = new LinkedHashMap<>(1);


        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        filterChainDefinitionMap.put("/login/**", "anon");

        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap( filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 自定义身份验证
     * @return
     */
    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager(  );
        defaultWebSecurityManager.setRealm( myRealm() );
        defaultWebSecurityManager.setSessionManager( sessionManager() );
        return defaultWebSecurityManager;
    }

    @Bean
    public SessionManager sessionManager(){
        return new MySessionManager();
    }
}
