package com.shanyuan.common.domain;

import com.github.pagehelper.PageInfo;
import com.shanyuan.common.enums.ExceptionEnum;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-04-15 16:58
 * <p>
 * desc      统一响应实体类
 **/
@Data
public class CommonResult {
    //操作成功
    public static final int SUCCESS = 0;
    //操作失败
    public static final int FAILED = 9999;
    //参数校验失败
    public static final int VALIDATE_FAILED = 5555;
    //返回码
    private int code;
    //返回消息
    private String msg;
    //返回数据
    private Object data;


    /*返回成功报文*/
    public CommonResult success(Object data){
        this.code=SUCCESS;
        this.msg="操作成功";
        this.data=data;
        return this;
    }

    /**
     * 自定义返回成功报文
     */
    public CommonResult success(String msg,Object data) {
        this.code = SUCCESS;
        this.msg = msg;
        this.data = data;
        return this;
    }

    /*返回分页数据*/
    public CommonResult pageSuccess(PageInfo pageInfo){
        Map<String,Object> result = new HashMap <>(  );
        result.put("pageSize", pageInfo.getPageSize());
        result.put("totalPage", pageInfo.getPages());
        result.put("total", pageInfo.getTotal());
        result.put("pageNum", pageInfo.getPageNum());
        result.put("list", pageInfo.getList());
        this.code = SUCCESS;
        this.msg = "操作成功";
        this.data = result;
        return this;
    }

    /*返回普通失败报文*/
    public CommonResult failed(){
        this.code=FAILED;
        this.msg="操作失败";
        return this;
    }

    /*返回普通失败报文*/
    public CommonResult failed(String msg){
        this.code=FAILED;
        this.msg=msg;
        return this;
    }

    /*返回自定义失败报文*/
    public CommonResult failed(int code,String msg){
        this.code=code;
        this.msg=msg;
        return this;
    }

    /*自定义异常报文*/
    public CommonResult error(ExceptionEnum exceptionEnum){
        this.code=exceptionEnum.getCode();
        this.msg=exceptionEnum.getMsg();
        this.data=null;
        return this;
    }

    /*自定义异常报文*/
    public CommonResult error(int code,String msg ){
        this.code=code;
        this.msg=msg;
        this.data=null;
        return this;
    }

    /**
     * 参数验证失败使用
     *
     * @param message 错误信息
     */
    public CommonResult validateFailed(String message) {
        this.code = VALIDATE_FAILED;
        this.msg = message;
        return this;
    }

    /**
     * 参数验证失败使用
     * @param result 错误信息
     */
    public CommonResult validateFailed(BindingResult result) {
        this.validateFailed(result.getFieldError().getDefaultMessage());
        return this;
    }

}
