package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.PmsItemCategoryParams;
import com.shanyuan.alipayorderadmin.service.PmsItemCategoryService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.PmsItemCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 15:56
 * <p>
 * desc
 **/
@Api(value="PmsItemCategoryController",description="产品分类管理")
@RestController
@RequestMapping("/itemCategory")
public class PmsItemCategoryController {

    @Autowired
    PmsItemCategoryService pmsItemCategoryService;

    @ApiOperation( "创建产品分类目录" )
    @PostMapping("/create")
    public CommonResult create(@Validated @RequestBody PmsItemCategoryParams params, BindingResult bindingResult){
        int count=pmsItemCategoryService.createItemCategory( params );
        return ResultUtil.result(count);
    }
    @ApiOperation( "查看产品目录" )
    @PostMapping("/list")
    public CommonResult list(@RequestBody BrandStoreParams params,@RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <PmsItemCategory> pmsItemCategoryPageInfo=pmsItemCategoryService.listItemCategory( params,pageNum, pageSize );
        return new CommonResult().pageSuccess( pmsItemCategoryPageInfo );
    }

    @ApiOperation( "删除产品目录" )
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count=pmsItemCategoryService.deleteItemCategory( id );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改产品目录" )
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Integer id,@Validated @RequestBody PmsItemCategoryParams params, BindingResult bindingResult){
        int count=pmsItemCategoryService.updateItemCategory( id, params );
        return ResultUtil.result( count );
    }
}
