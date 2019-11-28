package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.service.TransactionAmountService;
import com.shanyuan.common.domain.*;
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
 * create 2019-11-06 17:54
 * <p>
 * desc
 **/
@Api(value="TransactionAmountController",description="交易额管理")
@RequestMapping("/transaction")
@RestController
public class TransactionAmountController {

    @Autowired
    TransactionAmountService transactionAmountService;

    @ApiOperation( "交易额列表" )
    @PostMapping("/listTransaction")
    public CommonResult listTransaction(
                                        @RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="10")Integer pageSize,
                                        @Validated @RequestBody HomeTransactionChartParams params, BindingResult bindingResult){
        PageInfo <TransOrderInfo> transactionAmount=transactionAmountService.getTransactionAmount( params, pageNum, pageSize );
        return new CommonResult().pageSuccess( transactionAmount );
    }


    @ApiOperation( "交易额详情" )
    @PostMapping("/getTransactionDetail")
    public CommonResult getTransactionDetail(@Validated @RequestBody TransactionParams params, BindingResult bindingResult,
                                             @RequestParam(defaultValue="1")Integer pageNum, @RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <OmsOrder> transactionDetail=transactionAmountService.getTransactionDetails( params, pageNum, pageSize );
        return new CommonResult().pageSuccess( transactionDetail );
    }

    @ApiOperation( "根据订单id获取订单详情" )
    @PostMapping("/getOrderDetails")
    public CommonResult getOrderDetails(@RequestParam Long orderId){
        List <OmsOrderDetailResult> orderDetails=transactionAmountService.getOrderDetails( orderId );
        return new CommonResult().success( orderDetails );
    }

}
