package com.shanyuan.alipayorderportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.dto.PortalItemPriceStockResult;
import com.shanyuan.alipayorderportal.dto.PortalItemSkuPriceParams;
import com.shanyuan.alipayorderportal.dto.PortalSearchItemParams;
import com.shanyuan.alipayorderportal.service.PortalItemService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.domain.PmsItemAttrValueResult;
import com.shanyuan.common.domain.PmsItemParams;
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
 * create 2019-10-17 15:18
 * <p>
 * desc
 **/
@Api(value="PortalItemController", description="产品管理")
@RestController
@RequestMapping("/item")
public class PortalItemController {

    @Autowired
    PortalItemService portalItemService;

    @ApiOperation("根据产品id获取详情信息")
    @GetMapping("/getItemDetail/{itemId}")
    public CommonResult getItemDetail(@PathVariable Integer itemId) {
        PmsItemParams itemDetail=portalItemService.getItemDetail( itemId );
        return new CommonResult().success( itemDetail );
    }

    @ApiOperation("根据产品id获取参数、规格信息")
    @PostMapping("/getAttributeParamsByItemId/{itemId}")
    public CommonResult getAttributeParamsByItemId(@PathVariable Integer itemId) {
        List <PmsItemAttrValueResult> itemAttrValueInfo=portalItemService.getItemAttrValueInfo( itemId );
        return new CommonResult().success( itemAttrValueInfo );
    }

    @ApiOperation("根据商品id,规格信息查询商品的价格")
    @PostMapping("/getItemPriceByAttribute/{itemId}")
    public CommonResult getProductPriceByAttribute(@PathVariable Integer itemId, @RequestBody PortalItemSkuPriceParams params) {
        List <PortalItemPriceStockResult> itemPriceByAttribute=portalItemService.getItemPriceByAttribute( itemId, params );
        return new CommonResult().success( itemPriceByAttribute );
    }

    @ApiOperation( "搜索产品" )
    @PostMapping("/searchItem")
    public CommonResult searchItem(@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize,
                                   @Validated @RequestBody PortalSearchItemParams params, BindingResult bindingResult){
        PageInfo <PmsItem> pmsItemPageInfo=portalItemService.searchItem( params, pageNum, pageSize );
        return new CommonResult().pageSuccess( pmsItemPageInfo );
    }
}
