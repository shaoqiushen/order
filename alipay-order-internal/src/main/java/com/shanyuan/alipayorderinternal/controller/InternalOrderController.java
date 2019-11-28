package com.shanyuan.alipayorderinternal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.service.InternalOrderService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.domain.OmsOrderDetailResult;
import com.shanyuan.common.domain.OmsOrderQueryParams;
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
 * create 2019-11-07 17:51
 * <p>
 * desc
 **/
@Api(value="InternalOrderController",description="订单管理")
@RestController
@RequestMapping("/internal/order")
public class InternalOrderController {

    @Autowired
    InternalOrderService internalOrderService;


    @ApiOperation( "查询订单" )
    @PostMapping("/listOrder")
    public CommonResult listOrder(@RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="10")Integer pageSize, @Validated @RequestBody OmsOrderQueryParams params, BindingResult bindingResult){
        PageInfo<OmsOrder> pageInfo=internalOrderService.listOrder( pageNum, pageSize, params );
        return new CommonResult().pageSuccess( pageInfo );
    }

    @ApiOperation( "根据订单编号查询订单详情" )
    @PostMapping("/listOrderDetail")
    public CommonResult listOrderDetail(@RequestParam Long orderId){
        List<OmsOrderDetailResult> orderDetailList=internalOrderService.listOrderDetail( orderId );
        return new CommonResult().success( orderDetailList );
    }
}
