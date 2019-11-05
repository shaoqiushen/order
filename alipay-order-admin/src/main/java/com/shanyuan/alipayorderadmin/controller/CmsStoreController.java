package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.CmsStoreParams;
import com.shanyuan.alipayorderadmin.dto.CmsStoreResult;
import com.shanyuan.alipayorderadmin.service.CmsStoreService;
import com.shanyuan.common.domain.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 8:43
 * <p>
 * desc
 **/
@Api(value="CmsStoreController",description="店铺管理")
@RestController
@RequestMapping("/store")
public class CmsStoreController {

    @Autowired
    CmsStoreService cmsStoreService;

    @ApiOperation( "创建店铺" )
    @PostMapping("/create")
    public CommonResult create(@Validated @RequestBody CmsStoreParams params, BindingResult bindingResult){
        return cmsStoreService.createStore( params );
    }

    @ApiOperation( "店铺列表" )
    @GetMapping("/list")
    public CommonResult list(@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize,Long brandId){
        PageInfo <CmsStoreResult> pageInfo=cmsStoreService.listStore( pageNum, pageSize,brandId );
        return new CommonResult().pageSuccess( pageInfo );
    }
}
