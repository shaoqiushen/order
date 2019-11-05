package com.shanyuan.common.exception;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-03-19 15:41
 * <p>
 * desc
 **/
public class BussinessException extends RuntimeException {
    public BussinessException() {
    }

    public BussinessException(String message) {
        super( message );
    }

    public BussinessException(String message, Throwable cause) {
        super( message, cause );
    }

    public BussinessException(Throwable cause) {
        super( cause );
    }

    public BussinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
