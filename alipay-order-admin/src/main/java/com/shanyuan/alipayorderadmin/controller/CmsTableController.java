package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.CmsTableParams;
import com.shanyuan.alipayorderadmin.service.CmsTableService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.CmsTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 15:53
 * <p>
 * desc
 **/
@Api(value="CmsTableController",description="茶位管理")
@RestController
@RequestMapping("/table")
public class CmsTableController {

    @Autowired
    CmsTableService cmsTableService;

    @ApiOperation( "添加茶位费" )
    @PostMapping("/create")
    public CommonResult create(@Validated @RequestBody CmsTableParams params, BindingResult bindingResult){
        return cmsTableService.create( params );
    }

    @ApiOperation( "茶位费列表" )
    @PostMapping("/list")
    public CommonResult list(@RequestBody BrandStoreParams params, @RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <CmsTable> list=cmsTableService.list( params, pageNum, pageSize );
        return new CommonResult().pageSuccess( list );
    }

    @ApiOperation( "修改茶位费启用状态" )
    @PostMapping("/updateEnableStatus/{id}")
    public CommonResult updateEnableStatus(@PathVariable Integer id,@RequestParam Integer enableStatus){
        return cmsTableService.updateEnableStatus( id, enableStatus );
    }

    @ApiOperation( "修改茶位费信息" )
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Integer id,@Validated @RequestBody CmsTableParams params,BindingResult bindingResult){
        return cmsTableService.update( id, params );
    }

    @ApiOperation( "删除茶位费" )
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count=cmsTableService.delete( id );
        return ResultUtil.result( count );
    }
}
