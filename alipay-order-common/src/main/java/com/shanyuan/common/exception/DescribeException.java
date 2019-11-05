package com.shanyuan.common.exception;

import com.shanyuan.common.enums.ExceptionEnum;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 11:29
 * <p>
 * desc
 **/
public class DescribeException extends RuntimeException{

    private Integer code;

    /**
     * 继承exception，加入错误状态值
     * @param exceptionEnum
     */
    public DescribeException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    /**
     * 自定义错误信息
     * @param msg
     * @param code
     */
    public DescribeException(int code,String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
