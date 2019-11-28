package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.*;
import com.shanyuan.alipayorderadmin.service.OmsReceiptCodeService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.OmsOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 10:46
 * <p>
 * desc
 **/
@Api(value="OmsReceiptCodeController",description="收款码管理")
@RestController
@RequestMapping("/receipt")
public class OmsReceiptCodeController {

    @Autowired
    OmsReceiptCodeService omsReceiptCodeService;

    @ApiOperation( "根据桌号获取按天查询收款信息" )
    @PostMapping("/listReceiptCode")
    public CommonResult listReceiptCode(@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize,
                                        @Validated @RequestBody OmsReceiptQueryParams params, BindingResult bindingResult){
        PageInfo <OmsReceiptCodeResult> pageInfo=omsReceiptCodeService.listReceiptCode( pageNum, pageSize, params );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "根据桌号查询订单信息" )
    @PostMapping("/listOrderByDeskNo/{brandId}")
    public CommonResult listOrderByDeskNo(@PathVariable Long brandId,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize,
                                          @RequestParam String deskNo){
        PageInfo <OmsOrder> pageInfo=omsReceiptCodeService.listOrderByDeskNo( brandId, pageNum, pageSize, deskNo );
        return new CommonResult().pageSuccess( pageInfo );
    }

//    @ApiOperation( "查询店铺的桌位信息" )
//    @PostMapping("/listDeskNo/{brandId}")
//    public CommonResult listDeskNo(@PathVariable Long brandId, Integer storeId, @RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="10")Integer pageSize){
//        PageInfo <CmsReceiptCode> pageInfo=omsReceiptCodeService.listDeskNo( brandId, storeId, pageNum, pageSize );
//        return new CommonResult().pageSuccess( pageInfo );
//    }



    @ApiOperation( "添加收款码" )
    @PostMapping("/createReceiptCode")
    public CommonResult createReceiptCode(@Validated @RequestBody CmsReceiptCodeParams params,BindingResult bindingResult){
        return omsReceiptCodeService.createReceiptCode( params );
    }

    @ApiOperation( "修改收款码" )
    @PostMapping("/updateReceiptCode/{id}")
    public CommonResult updateReceiptCode(@PathVariable Integer id,@Validated @RequestBody CmsReceiptCodeParams params,BindingResult bindingResult){
        return omsReceiptCodeService.updateReceiptCode( id, params );
    }

    @ApiOperation( "根据店铺id获取相应收款码/桌位列表" )
    @PostMapping("/listReceiptCodeByStoreId/{storeId}")
    public CommonResult listReceiptCodeByStoreId(@PathVariable Integer storeId,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <CmsReceiptCodeResult> pageInfo=omsReceiptCodeService.listReceiptCodeByStoreId( storeId, pageNum, pageSize );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "删除收款码" )
    @PostMapping("/deleteReceiptCode/{id}")
    public CommonResult deleteReceiptCode(@PathVariable Integer id){
        int count=omsReceiptCodeService.deleteReceiptCode( id );
        return ResultUtil.result( count );
    }

    @ApiOperation( "根据参数查询收款码列表" )
    @PostMapping("/listReceiptCodeByParams")
    public CommonResult listReceiptCodeByParams(@Validated @RequestBody BrandStoreParams params,BindingResult bindingResult,
                                                @RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <CmsReceiptCodeRes> pageInfo=omsReceiptCodeService.listReceiptCodeByParams( params, pageNum, pageSize );
        return new CommonResult().pageSuccess( pageInfo );
    }
}
