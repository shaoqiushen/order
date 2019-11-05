package com.shanyuan.alipayorderportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.service.PortalHomeService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.enums.ExceptionEnum;
import com.shanyuan.common.exception.DescribeException;
import com.shanyuan.model.CmsCarousel;
import com.shanyuan.model.PmsItem;
import com.shanyuan.model.PmsItemCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 10:45
 * <p>
 * desc
 **/
@RestController
@Api(value="HomeController", description="首页管理")
@RequestMapping("/home")
public class PortalHomeController {

    @Autowired
    PortalHomeService portalHomeService;

    @ApiOperation("查询产品分类列表")
    @GetMapping("/listItemCategory")
    public CommonResult listItemCategory(Long brandId,Integer storeId) {
        List <PmsItemCategory> pmsItemCategories=portalHomeService.listItemCategory( brandId,storeId );
        return new CommonResult().success( pmsItemCategories );
    }

    @ApiOperation("根据分类id查询产品信息列表")
    @GetMapping("/listItem/{itemCategoryId}")
    public CommonResult listItem(@PathVariable Integer itemCategoryId, @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="10") Integer pageSize) {
        PageInfo <PmsItem> pmsItemPageInfo=portalHomeService.listItem( itemCategoryId, pageNum, pageSize );
        return new CommonResult().pageSuccess( pmsItemPageInfo );
    }

    @ApiOperation("查询轮播图")
    @GetMapping("/listCarousel/{brandId}")
    public CommonResult listCarousel(@PathVariable Long brandId,Integer position,@RequestParam(required=false) Integer storeId,
                                     @RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="3") Integer pageSize) {
        PageInfo <CmsCarousel> pageInfo=portalHomeService.listCarousel( brandId,position,storeId, pageNum, pageSize );
        return new CommonResult().pageSuccess( pageInfo );
    }

}
