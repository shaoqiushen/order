package com.shanyuan.alipayorderportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.service.PortalStoreService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.CmsStore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-21 17:09
 * <p>
 * desc
 **/
@Api(value="PortalStoreController",description="店铺管理")
@RestController
@RequestMapping("/store")
public class PortalStoreController {

    @Autowired
    PortalStoreService portalStoreService;

    @ApiOperation( "店铺列表" )
    @PostMapping("/list/{brandId}")
    public CommonResult list(@RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="10")Integer pageSize, @PathVariable Long brandId){
        PageInfo <CmsStore> pageInfo=portalStoreService.listStore( pageNum, pageSize, brandId );
        return new CommonResult().pageSuccess( pageInfo );
    }
}
