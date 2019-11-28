package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.service.OmsOrderService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.domain.OmsOrderDetailResult;
import com.shanyuan.common.domain.OmsOrderQueryParams;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.OmsOrder;
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
 * create 2019-10-22 9:53
 * <p>
 * desc
 **/
@Api(value="OmsOrderController",description="订单管理")
@RestController
@RequestMapping("/order")
public class OmsOrderController {

    @Autowired
    OmsOrderService omsOrderService;

    @ApiOperation( "查询订单" )
    @PostMapping("/listOrder")
    public CommonResult listOrder(@RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="10")Integer pageSize, @Validated @RequestBody OmsOrderQueryParams params, BindingResult bindingResult){
        PageInfo <OmsOrder> pageInfo=omsOrderService.listOrder( pageNum, pageSize, params );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "根据订单编号查询订单详情" )
    @PostMapping("/listOrderDetail")
    public CommonResult listOrderDetail(@RequestParam Long orderId){
        List <OmsOrderDetailResult> orderDetailList=omsOrderService.listOrderDetail( orderId );
        return new CommonResult().success( orderDetailList );
    }

    @ApiOperation( "订单详细中的产品退订" )
    @PostMapping("/unsubscribe/")
    public CommonResult unsubscribe(@RequestParam("ids")List<Integer> ids,@RequestParam Integer cancelStatus,@RequestParam(required=false) String cancelDesc){
        return omsOrderService.unsubscribe( ids, cancelStatus, cancelDesc );
    }

    @ApiOperation( "修改订单状态" )
    @PostMapping("/updateOrderStatus/{id}")
    public CommonResult updateOrderStatus(@PathVariable Integer id,@RequestParam Integer orderStatus){
        int count=omsOrderService.updateOrderStatus( id, orderStatus );
        return ResultUtil.result( count );
    }
}
