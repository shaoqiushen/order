package com.shanyuan.alipayorderadmin.component;

import com.shanyuan.common.domain.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 10:35
 * <p>
 * desc 自定义切面，返回校验参数失败异常信息
 **/
@Aspect
@Component
@Order(2)//加载顺序
public class BindingResultAspect {
    @Pointcut("execution(public * com.shanyuan.alipayorderadmin.controller.*.*(..))")
    public void BindingResult() {
    }

    @Around("BindingResult()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = ( BindingResult ) arg;
                if (result.hasErrors()) {
                    return new CommonResult().validateFailed(result);
                }
            }
        }
        return joinPoint.proceed();
    }
}
