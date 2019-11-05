package com.shanyuan.alipayorderportal.controller;

import com.shanyuan.alipayorderportal.dto.PortalPayParams;
import com.shanyuan.alipayorderportal.service.PortalPayService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.model.OmsPrepay;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-18 9:57
 * <p>
 * desc
 **/
@Api(value="PortalPayController", description="支付管理")
@RestController
@RequestMapping("/pay")
public class PortalPayController {

    @Autowired
    PortalPayService portalPayService;

    @ApiOperation("在线支付")
    @PostMapping("/payBuy")
    public CommonResult payBuy(@Validated @RequestBody PortalPayParams params, BindingResult bindingResult) {
        return portalPayService.payBuy( params );
    }

    @ApiOperation("再次支付:订单信息payFlag=1时调用")
    @PostMapping("/payAgain")
    public CommonResult payAgain(@RequestParam Long orderId) {
        OmsPrepay omsPrepay=portalPayService.payAgain( orderId );
        return new CommonResult().success( omsPrepay );
    }

    @ApiOperation("支付回调方法")
    @PostMapping("/alipayNotify")
    public void alipayNotify(String trade_no, String out_trade_no, String msg) {
        if (msg.equals( "SUCCESS" )) {
            portalPayService.alipayNotify( trade_no, out_trade_no );
        }
    }
}
