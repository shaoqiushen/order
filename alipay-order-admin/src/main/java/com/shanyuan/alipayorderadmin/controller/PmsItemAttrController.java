package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.PmsItemAttrParams;
import com.shanyuan.alipayorderadmin.service.PmsItemAttrService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.PmsItemAttr;
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
@Api(value="PmsItemAttrController",description="产品属性管理")
@RestController
@RequestMapping("/itemAttr")
public class PmsItemAttrController {

    @Autowired
    PmsItemAttrService pmsItemAttrService;

    @ApiOperation( "创建产品属性" )
    @PostMapping("/create")
    public CommonResult create(@Validated @RequestBody PmsItemAttrParams params, BindingResult bindingResult){
        int count=pmsItemAttrService.createItemAttr( params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "删除产品属性" )
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count=pmsItemAttrService.deleteItemAttr( id );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改产品属性" )
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Integer id,@Validated @RequestBody PmsItemAttrParams params, BindingResult bindingResult){
        int count=pmsItemAttrService.updateItemAttr( id, params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "产品属性列表" )
    @GetMapping("/list/{attrCategoryId}")
    public CommonResult list(@PathVariable Integer attrCategoryId,Integer attrType,
                             @RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <PmsItemAttr> pmsItemAttrPageInfo=pmsItemAttrService.listItemAttr(attrCategoryId,attrType, pageNum, pageSize );
        return new CommonResult().pageSuccess( pmsItemAttrPageInfo );
    }
}
