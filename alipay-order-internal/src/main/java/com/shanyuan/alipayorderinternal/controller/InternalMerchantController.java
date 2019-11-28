package com.shanyuan.alipayorderinternal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.dto.InternalMerchantParams;
import com.shanyuan.alipayorderinternal.dto.InternalStoreParams;
import com.shanyuan.alipayorderinternal.service.InternalMerchantService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.MysMerchant;
import com.shanyuan.model.MysStore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 9:36
 * <p>
 * desc
 **/
@Api(value="InternalMerchantController",description="商户管理")
@RestController
@RequestMapping("/internal/merchant")
public class InternalMerchantController {

    @Autowired
    InternalMerchantService internalMerchantService;

    @ApiOperation( "创建商户" )
    @PostMapping("/createMerchant")
    public CommonResult createMerchant(@Validated @RequestBody InternalMerchantParams params, BindingResult  bindingResult){
        int count=internalMerchantService.createMerchant( params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改商户" )
    @PostMapping("/updateMerchant/{id}")
    public CommonResult updateMerchant(@PathVariable Integer id,@Validated @RequestBody InternalMerchantParams params, BindingResult  bindingResult){
        int count=internalMerchantService.updateMerchant( id, params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "商户列表" )
    @PostMapping("/listMerchant")
    public CommonResult listMerchant(@RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="10")Integer pageSize,@RequestParam(required=false)String merName){
        PageInfo <MysMerchant> pageInfo=internalMerchantService.listMerchant( pageNum, pageSize, merName );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "删除商户" )
    @PostMapping("/deleteMerchant/{id}")
    public CommonResult deleteMerchant(@PathVariable Integer id){
        int count=internalMerchantService.deleteMerchant( id );
        return ResultUtil.result( count );
    }

    @ApiOperation( "创建店铺" )
    @PostMapping("/createStore")
    public CommonResult createStore(@Validated @RequestBody InternalStoreParams params,BindingResult bindingResult){
        int count=internalMerchantService.createStore( params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改店铺" )
    @PostMapping("/updateStore/{id}")
    public CommonResult updateStore(@PathVariable Integer id,@Validated @RequestBody InternalStoreParams params,BindingResult bindingResult){
        int count=internalMerchantService.updateStore( id, params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "根据商户id查询店铺" )
    @PostMapping("/listStore/{merId}")
    public CommonResult listStore(@PathVariable Integer merId){
        List <MysStore> mysStores=internalMerchantService.listStore( merId );
        return new CommonResult().success( mysStores );
    }

    @ApiOperation( "删除店铺" )
    @PostMapping("/deleteStore/{id}")
    public CommonResult deleteStore(@PathVariable Integer id){
        int count=internalMerchantService.deleteStore( id );
        return ResultUtil.result( count );
    }
}
