package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.UmsRoleParams;
import com.shanyuan.alipayorderadmin.service.UmsRoleService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.UmsRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-05 14:55
 * <p>
 * desc
 **/
@Api(value="UmsRoleController",description="角色权限管理")
@RestController
@RequestMapping("/role")
public class UmsRoleController {

    @Autowired
    UmsRoleService umsRoleService;

    @ApiOperation( "创建角色" )
    @PostMapping("/create")
    public CommonResult create(@Validated @RequestBody UmsRoleParams params, BindingResult bindingResult){
        int count=umsRoleService.create( params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改角色" )
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Integer id,@Validated @RequestBody UmsRoleParams params, BindingResult bindingResult){
        int count=umsRoleService.update( id, params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "删除角色" )
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count=umsRoleService.delete( id );
        return ResultUtil.result( count );
    }

    @ApiOperation( "角色列表" )
    @PostMapping("/list/{brandId}")
    public CommonResult list(@PathVariable Long brandId,@RequestParam(required=false,defaultValue="-1")Integer storeId,
                             @RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <UmsRole> list=umsRoleService.list( brandId, storeId, pageNum, pageSize );
        return new CommonResult().pageSuccess( list );
    }
}
