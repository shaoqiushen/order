package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.CmsCarouselParams;
import com.shanyuan.alipayorderadmin.service.CmsCarouselService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.CmsCarousel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 9:45
 * <p>
 * desc
 **/
@Api(value="CmsCarouselController",description="轮播图管理")
@RestController
@RequestMapping("/carousel")
public class CmsCarouselController {

    @Autowired
    CmsCarouselService cmsCarouselService;

    @ApiOperation( "创建轮播图" )
    @PostMapping("/create")
    public CommonResult create(@Validated @RequestBody CmsCarouselParams params, BindingResult bindingResult){
        int count=cmsCarouselService.createCarousel( params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "轮播图列表" )
    @GetMapping("/list/{brandId}")
    public CommonResult list(@PathVariable Long brandId,@RequestParam(required=false) Integer storeId,
                             @RequestParam(defaultValue="1")Integer pageNume,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <CmsCarousel> pageInfo=cmsCarouselService.listCarousel( pageNume, pageSize, brandId,storeId );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "删除轮播图" )
    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Integer id){
        int count=cmsCarouselService.deleteCarousel( id );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改轮播图" )
    @PostMapping("/update/{id}")
    public CommonResult update(@PathVariable Integer id,@Validated @RequestBody CmsCarouselParams params, BindingResult bindingResult){
        int count=cmsCarouselService.updateCarousel( id, params );
        return ResultUtil.result( count );
    }
}
