package com.shanyuan.alipayorderportal.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderportal.dto.PortalOrderDetailResult;
import com.shanyuan.alipayorderportal.dto.PortalOrderParams;
import com.shanyuan.alipayorderportal.dto.PortalOrderQueryParams;
import com.shanyuan.alipayorderportal.dto.PortalOrderQueryResult;
import com.shanyuan.alipayorderportal.service.PortalOrderService;
import com.shanyuan.alipayorderportal.service.PortalSystemFeeService;
import com.shanyuan.common.domain.CommonResult;
import com.shanyuan.common.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-17 11:41
 * <p>
 * desc
 **/
@Api(value="PortalOrderController", description="订单管理")
@RestController
@RequestMapping("/order")
public class PortalOrderController {

    @Autowired
    PortalOrderService portalOrderService;

    @Autowired
    PortalSystemFeeService portalSystemFeeService;

    @ApiOperation("创建订单")
    @PostMapping("/create")
    public CommonResult create(@Validated @RequestBody PortalOrderParams params, BindingResult bindingResult) {
        return portalOrderService.create( params );
    }

//    @ApiOperation("查看用户订单")
//    @PostMapping("/listUserOrder")
//    public CommonResult listUserOrder(@RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="10") Integer pageSize, @Validated @RequestBody PortalOrderQueryParams params, BindingResult bindingResult) {
//        PageInfo <OmsOrder> pageInfo=portalOrderService.listUserOrder( params, pageNum, pageSize );
//        return new CommonResult().pageSuccess( pageInfo );
//    }

    @ApiOperation("获取订单详情")
    @PostMapping("/getUserOrderDetail")
    public CommonResult getUserOrderDetail(@RequestParam Long orderId) {
        PortalOrderDetailResult userOrderDetail=portalOrderService.getUserOrderDetail( orderId );
        return new CommonResult().success( userOrderDetail );
    }

    @ApiOperation("查询用户订单信息")
    @PostMapping("/listOrderInfoByParams")
    public CommonResult listOrderInfoByParams(@RequestParam(defaultValue="1") Integer pageNum, @RequestParam(defaultValue="10") Integer pageSize, @Validated @RequestBody PortalOrderQueryParams portalOrderQueryParams, BindingResult bindingResult) {

        PageInfo <PortalOrderQueryResult> portalOrderQueryResultPageInfo=portalOrderService.listOrderInfoByParams( portalOrderQueryParams, pageNum, pageSize );
        return new CommonResult().pageSuccess( portalOrderQueryResultPageInfo );
    }

    @ApiOperation( "删除订单" )
    @PostMapping("/deleteOrder")
    public CommonResult deleteOrder(@RequestParam Long orderId){
        int count=portalOrderService.deleteOrder( orderId );
        return ResultUtil.result( count );
    }

    @ApiOperation( "获取茶位费" )
    @PostMapping("/getTableMoney/{brandId}")
    public CommonResult getTableMoney(@PathVariable Long brandId,@RequestParam Integer storeId){
        Integer tableMoney=portalSystemFeeService.getTableMoney( brandId, storeId );
        Map<String,Integer> map = new HashMap <>(  );
        map.put( "tableMoney",tableMoney );
        return new CommonResult().success( map );
    }

    @ApiOperation( "获取配送费" )
    @PostMapping("/getDelivery/{brandId}")
    public CommonResult getDelivery(@PathVariable Long brandId,@RequestParam Integer storeId){
        Integer delivery=portalSystemFeeService.getDelivery( brandId, storeId );
        Map<String,Integer> map = new HashMap <>(  );
        map.put( "freightAmount",delivery );
        return new CommonResult().success( map );
    }

    @ApiOperation( "获取包装费" )
    @PostMapping("/getPackage/{brandId}")
    public CommonResult getPackage(@PathVariable Long brandId,@RequestParam Integer storeId){
        Integer aPackage=portalSystemFeeService.getPackage( brandId, storeId );
        Map<String,Integer> map = new HashMap <>(  );
        map.put( "packageMoney",aPackage );
        return new CommonResult().success( map );
    }


}
