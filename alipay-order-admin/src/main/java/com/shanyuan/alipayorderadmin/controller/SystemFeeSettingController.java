package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.BrandStoreParams;
import com.shanyuan.alipayorderadmin.dto.CmsDeliveryParams;
import com.shanyuan.alipayorderadmin.dto.CmsPackageParams;
import com.shanyuan.alipayorderadmin.service.SystemFeeSettingService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.CmsDelivery;
import com.shanyuan.model.CmsPackage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-04 10:22
 * <p>
 * desc
 **/
@Api(value="SystemFeeSettingController",description="系统费用设置管理")
@RequestMapping("/system")
@RestController
public class SystemFeeSettingController {

    @Autowired
    SystemFeeSettingService systemFeeSettingService;


    @ApiOperation( "创建配送费" )
    @PostMapping("/createDelivery")
    public CommonResult createDelivery(@Validated @RequestBody CmsDeliveryParams params, BindingResult bindingResult){
        return systemFeeSettingService.createDelivery( params );
    }

    @ApiOperation( "修改配送费" )
    @PostMapping("/updateDelivery/{id}")
    public CommonResult updateDelivery(@PathVariable Integer id,@Validated @RequestBody CmsDeliveryParams params, BindingResult bindingResult){
        return systemFeeSettingService.updateDelivery( id,params );
    }

    @ApiOperation( "配送费列表" )
    @PostMapping("/listDelivery")
    public CommonResult listDelivery(@Validated @RequestBody BrandStoreParams params,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <CmsDelivery> cmsDeliveryPageInfo=systemFeeSettingService.listDelivery( params, pageNum, pageSize );
        return new CommonResult().pageSuccess( cmsDeliveryPageInfo );
    }

    @ApiOperation( "修改配送费启用状态" )
    @PostMapping("/updateDeliveryStatus/{id}")
    public CommonResult updateDeliveryStatus(@PathVariable Integer id,@RequestParam Integer enableStatus){
        return systemFeeSettingService.updateDeliveryStatus( id, enableStatus );
    }


    @ApiOperation( "创建包装费" )
    @PostMapping("/createPackage")
    public CommonResult createPackage(@Validated @RequestBody CmsPackageParams params, BindingResult bindingResult){
        return systemFeeSettingService.createPackage( params );
    }

    @ApiOperation( "修改包装费" )
    @PostMapping("/updatePackage/{id}")
    public CommonResult updatePackage(@PathVariable Integer id,@Validated @RequestBody CmsPackageParams params, BindingResult bindingResult){
        return systemFeeSettingService.updatePackage( id,params );
    }

    @ApiOperation( "包装费列表" )
    @PostMapping("/listPackage")
    public CommonResult listPackage(@Validated @RequestBody BrandStoreParams params,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <CmsPackage> cmsPackagePageInfo=systemFeeSettingService.listPackage( params, pageNum, pageSize );
        return new CommonResult().pageSuccess( cmsPackagePageInfo );
    }

    @ApiOperation( "修改包装费启用状态" )
    @PostMapping("/updatePackageStatus/{id}")
    public CommonResult updatePackageStatus(@PathVariable Integer id,@RequestParam Integer enableStatus){
        return systemFeeSettingService.updatePackageStatus( id, enableStatus );
    }
}
