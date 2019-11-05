package com.shanyuan.alipayorderadmin.config;

import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.common.exception.DescribeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 11:24
 * <p>
 * desc      统一异常处理
 **/
@ControllerAdvice
@Slf4j
public class ExceptionHandle {
    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public CommonResult exceptionGet(Exception e) {
        if (e instanceof DescribeException) {
            DescribeException MyException=( DescribeException ) e;
            return new CommonResult().error( MyException.getCode(), MyException.getMessage() );
        }

        log.error( "【未知系统异常】{}", e );
        return new CommonResult().error( ExceptionEnum.UNKNOW_ERROR );
    }
}
