package com.shanyuan.alipayorderportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.dto.PortalObtainPhoneParams;
import com.shanyuan.alipayorderportal.dto.PortalUserAddressParams;
import com.shanyuan.alipayorderportal.dto.PortalUserAuthorizationParams;
import com.shanyuan.alipayorderportal.service.PortalUserService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.UmsAddress;
import com.shanyuan.model.UmsUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 10:43
 * <p>
 * desc
 **/
@Api(value="PortalUserController", description="用户管理")
@RestController
@RequestMapping("/user")
public class PortalUserController {

    @Autowired
    PortalUserService portalUserService;

    @ApiOperation("创建用户收货地址")
    @PostMapping("/createUserAddress")
    public CommonResult createUserAddress(@Validated @RequestBody PortalUserAddressParams params, BindingResult bindingResult) {
        return portalUserService.createUserAddress( params );
    }

    @ApiOperation("查询用户收货地址")
    @PostMapping("/listUserAddress")
    public CommonResult listUserAddress(String userId, @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="10") Integer pageSize) {
        PageInfo <UmsAddress> pageInfo=portalUserService.listUserAddress( pageNum, pageSize, userId );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation("删除用户收货地址")
    @PostMapping("/deleteUserAddress/{id}")
    public CommonResult deleteUserAddress(@PathVariable Integer id) {
        int count=portalUserService.deleteUserAddress( id );
        return ResultUtil.result( count );
    }

    @ApiOperation("修改用户收货地址")
    @PostMapping("/updateUserAddress/{id}")
    public CommonResult updateUserAddress(@PathVariable Integer id, @Validated @RequestBody PortalUserAddressParams params, BindingResult bindingResult) {
        int count=portalUserService.updateUserAddress( id, params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "用户授权登录" )
    @PostMapping("/authorization")
    public CommonResult authorization(@Validated @RequestBody PortalUserAuthorizationParams params,BindingResult bindingResult){
        return portalUserService.authorization( params );
    }

    @ApiOperation( "获取用户手机号" )
    @PostMapping("/obtainPhone")
    public CommonResult obtainPhone(@Validated @RequestBody PortalObtainPhoneParams prams,BindingResult bindingResult){
        return portalUserService.obtainPhone( prams );
    }

    @ApiOperation( "获取个人信息" )
    @PostMapping("/getUserInfo")
    public CommonResult getUserInfo(@RequestParam String userId){
        UmsUser userInfo=portalUserService.getUserInfo( userId );
        return new CommonResult().success( userInfo );
    }

    @ApiOperation( "修改手机号" )
    @PostMapping("/updatePhone")
    public CommonResult updatePhone(@RequestParam String userId,@RequestParam String telephone){
        int count=portalUserService.updatePhone( userId, telephone );
        return ResultUtil.result( count );
    }

    @ApiOperation( "判断用户是否存在" )
    @PostMapping("/userExists")
    public CommonResult userExists(@RequestParam String userId){
        if(portalUserService.userExists( userId )){
            return new CommonResult().success( "用户存在" );
        }else {
            return new CommonResult().error( ExceptionEnum.USER_NOT_EXISTS );
        }
    }
}
