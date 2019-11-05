package com.shanyuan.alipayorderportal.controller;

import com.shanyuan.alipayorderportal.dto.PortalCartParams;
import com.shanyuan.alipayorderportal.service.PortalCartService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import com.shanyuan.model.OmsCart;
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
 * create 2019-10-17 17:04
 * <p>
 * desc
 **/
@Api(value="PortalCartController", description="购物车管理")
@RestController
@RequestMapping("/cart")
public class PortalCartController {

    @Autowired
    PortalCartService portalCartService;

    @ApiOperation("创建购物车")
    @PostMapping("/create")
    public CommonResult create(@Validated @RequestBody PortalCartParams params, BindingResult bindingResult) {
        return portalCartService.createCart( params );
    }

    @ApiOperation("获取用户购物车信息")
    @GetMapping("/getCartInfo/{brandId}")
    public CommonResult getCartInfo(@PathVariable Long brandId, @RequestParam String userId) {
        List <OmsCart> cartInfo=portalCartService.getCartInfo( brandId, userId );
        return new CommonResult().success( cartInfo );
    }
}
