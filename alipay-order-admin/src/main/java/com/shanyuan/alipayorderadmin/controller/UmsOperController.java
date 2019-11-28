package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.UmsOperParams;
import com.shanyuan.alipayorderadmin.dto.UmsOperResult;
import com.shanyuan.alipayorderadmin.service.UmsOperService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.UmsOper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-30 10:05
 * <p>
 * desc
 **/
@Api(value="UmsOperController",description="管理员管理")
@RestController
@RequestMapping("/oper")
public class UmsOperController {

    @Autowired
    UmsOperService umsOperService;

    @ApiOperation( "创建子账号" )
    @PostMapping("/createSubOper")
    public CommonResult createSubOper(@Validated @RequestBody UmsOperParams params, BindingResult bindingResult){
        return umsOperService.createSubOper( params );
    }

    @ApiOperation( "修改子账号" )
    @PostMapping("/updateSubOper/{id}")
    public CommonResult updateSubOper(@PathVariable Integer id, @Validated @RequestBody UmsOperParams params, BindingResult bindingResult){
        return umsOperService.updateSubOper( id, params );
    }

    @ApiOperation( "子账号列表" )
    @PostMapping("/listSubOper")
    public CommonResult listSubOper(@Validated @RequestBody BrandStoreParams params, BindingResult bindingResult,
                                    @RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <UmsOperResult> pageInfo=umsOperService.listSubOper( params,pageNum, pageSize );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "删除子账户" )
    @PostMapping("/deleteSubOper/{id}")
    public CommonResult deleteSubOper(@PathVariable Integer id){
        int count=umsOperService.deleteSubOper( id );
        return ResultUtil.result( count );
    }

}
