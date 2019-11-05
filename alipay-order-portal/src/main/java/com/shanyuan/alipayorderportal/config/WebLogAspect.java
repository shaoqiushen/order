package com.shanyuan.alipayorderportal.config;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 11:00
 * <p>
 * desc      统一日志处理器
 **/
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    //定义切点
    @Pointcut("execution(public * com.shanyuan.alipayorderportal.controller..*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("Request Args   : {}", new Gson().toJson(joinPoint.getArgs()));
        // 记录下请求内容
        log.info( "URL : {}, HTTP_METHOD : {},IP : {}",request.getRequestURL().toString(),request.getMethod(),request.getRemoteAddr() );
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            log.info("PARAMS name:{},value:{}", name, request.getParameter(name));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
    }
}
