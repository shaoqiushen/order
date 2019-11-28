package com.shanyuan.alipayorderinternal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.dto.InternalStaffParams;
import com.shanyuan.alipayorderinternal.dto.InternalStaffQueryParams;
import com.shanyuan.alipayorderinternal.dto.InternalStaffResult;
import com.shanyuan.alipayorderinternal.service.InternalStaffService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 10:24
 * <p>
 * desc
 **/
@Api(value="InternalStaffController",description="员工管理")
public class InternalStaffController {

    @Autowired
    InternalStaffService internalStaffService;

    @ApiOperation( "添加员工" )
    @PostMapping("/createStaff")
    public CommonResult createStaff(@Validated @RequestBody InternalStaffParams params, BindingResult b){
        int count=internalStaffService.createStaff( params );
        return ResultUtil.result(count );
    }

    @ApiOperation( "员工列表" )
    @PostMapping("/listStaff")
    public CommonResult listStaff(@Validated @RequestBody InternalStaffQueryParams params, BindingResult bindingResult, @RequestParam(defaultValue="1")Integer pageNum,
                                  @RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <InternalStaffResult> pageInfo=internalStaffService.listStaff( params, pageNum, pageSize );
        return new CommonResult().pageSuccess( pageInfo );
    }
}
