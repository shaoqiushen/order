package com.shanyuan.alipayorderadmin.controller;

import com.shanyuan.alipayorderadmin.service.LoginService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.enums.ExceptionEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-30 10:25
 * <p>
 * desc
 **/
@Api(value="LoginController",description="登录管理")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @ApiOperation( "登录" )
    @PostMapping("/login")
    public CommonResult login(@RequestParam String account,@RequestParam String password){
        return loginService.login( account,password );
    }

    @RequestMapping("/notLogin")
    public CommonResult notLogin() throws IOException {

        return new CommonResult().error( ExceptionEnum.NOT_LOGIN);
    }

    @RequestMapping("/unAuth")
    public CommonResult unAuth(){
        return new CommonResult().error( ExceptionEnum.NOT_AUTH);
    }
}
