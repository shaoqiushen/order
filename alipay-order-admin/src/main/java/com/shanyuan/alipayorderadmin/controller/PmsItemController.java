package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.service.PmsItemService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.domain.PmsItemParams;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.PmsItem;
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
 * create 2019-10-16 14:12
 * <p>
 * desc
 **/
@Api(value="PmsItemController",description="产品管理")
@RestController
@RequestMapping("/item")
public class PmsItemController {

    @Autowired
    PmsItemService pmsItemService;

    @ApiOperation( "创建产品" )
    @PostMapping("/create")
    public CommonResult create(@Validated @RequestBody PmsItemParams params, BindingResult bindingResult){
        int count=pmsItemService.createItem( params );
        return ResultUtil.result(count);
    }

    @ApiOperation( "根据产品id获取产品编辑信息" )
    @GetMapping("/getItemInfo/{itemId}")
    public CommonResult getItemInfo(@PathVariable Integer itemId){
        PmsItemParams itemInfo=pmsItemService.getItemInfo( itemId );
        return new CommonResult().success( itemInfo );
    }

    @ApiOperation( "修改产品" )
    @PostMapping("/updateItemInfo/{itemId}")
    public CommonResult updateItemInfo(@PathVariable Integer itemId,@Validated @RequestBody PmsItemParams params,BindingResult bindingResult){
        int count=pmsItemService.updateItemInfo( itemId, params );
        return ResultUtil.result( count );
    }

    @ApiOperation( "修改产品上下架,支持批量" )
    @PostMapping("/updatePublishStatus")
    public CommonResult updatePublishStatus(@RequestParam("ids") List<Integer> ids, @RequestParam("publishStatus") Integer publishStatus){
        int count=pmsItemService.updatePublishStatus( ids, publishStatus );
        return ResultUtil.result( count );
    }

    @ApiOperation( "删除产品，支持批量" )
    @PostMapping("/deleteItem")
    public CommonResult deleteItem(@RequestParam("ids") List<Integer> ids){
        int count=pmsItemService.deleteItem( ids );
        return ResultUtil.result( count );
    }

    @ApiOperation( "分页查询商品列表" )
    @PostMapping("/listItem/{brandId}")
    public CommonResult listItem(@PathVariable Long brandId,Integer storeId,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <PmsItem> pmsItemPageInfo=pmsItemService.listItem( brandId,storeId, pageNum, pageSize );
        return new CommonResult().pageSuccess( pmsItemPageInfo );
    }

}
