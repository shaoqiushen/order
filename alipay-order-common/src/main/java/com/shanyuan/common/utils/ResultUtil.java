package com.shanyuan.common.utils;

import com.shanyuan.common.domain.CommonResult;
import org.springframework.stereotype.Component;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-23 11:58
 * <p>
 * desc
 **/
@Component
public class ResultUtil {

    public static CommonResult result(Integer count){
        if(count > 0){
            return new CommonResult().success( count );
        }else{
            return new CommonResult().failed();
        }
    }
}
