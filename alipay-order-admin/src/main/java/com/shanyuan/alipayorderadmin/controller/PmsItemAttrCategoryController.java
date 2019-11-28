package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.PmsItemAttrCategoryParams;
import com.shanyuan.alipayorderadmin.service.PmsItemAttrCategoryService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.PmsItemAttrCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 15:58
 * <p>
 * desc
 **/
@Api(value="PmsItemAttrCategoryController",description="产品属性目录管理")
@RestController
@RequestMapping("/itemAttrCategory")
public class PmsItemAttrCategoryController {

    @Autowired
    PmsItemAttrCategoryService pmsItemAttrCategoryService;

    @ApiOperation( "创建产品属性目录" )
    @PostMapping("/create")
    public CommonResult create(@Validated @RequestBody PmsItemAttrCategoryParams params, BindingResult bindingResult){
        int count=pmsItemAttrCategoryService.createItemAttrCategory( params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "查看产品属性分类列表" )
    @PostMapping("/list")
    public CommonResult list(@RequestBody BrandStoreParams params, @RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <PmsItemAttrCategory> pmsItemAttrCategoryPageInfo=pmsItemAttrCategoryService.listItemAttrCategory(params, pageNum, pageSize );
        return new CommonResult().pageSuccess( pmsItemAttrCategoryPageInfo );
    }

    @ApiOperation( "修改产品属性分类" )
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Integer id,@Validated @RequestBody PmsItemAttrCategoryParams params, BindingResult bindingResult){
        int count=pmsItemAttrCategoryService.updateItemAttrCategory( id, params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "删除产品属性" )
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count=pmsItemAttrCategoryService.deleteItemAttrCategory( id );
        return ResultUtil.result( count );
    }
}
