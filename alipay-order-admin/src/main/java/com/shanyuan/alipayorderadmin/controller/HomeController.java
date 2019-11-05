package com.shanyuan.alipayorderadmin.controller;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dto.HomeDateSummaryResult;
import com.shanyuan.alipayorderadmin.dto.HomeTransactionChartParams;
import com.shanyuan.alipayorderadmin.dto.HomeTransactionChartResult;
import com.shanyuan.alipayorderadmin.service.HomeService;
import com.shanyuan.common.domain.CommonResult;
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
 * create 2019-10-22 14:07
 * <p>
 * desc
 **/
@Api(value="HomeController",description="首页管理")
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @ApiOperation( "获取最新下单信息" )
    @PostMapping("/getNewOrderInfo/{brandId}")
    public CommonResult getNewOrderInfo(@PathVariable Long brandId,@RequestParam Integer storeId,@RequestParam(defaultValue="1")Integer pageNum,@RequestParam(defaultValue="10")Integer pageSize){
        PageInfo <OmsOrder> newOrderInfo=homeService.getNewOrderInfo( brandId, storeId, pageNum, pageSize );
        return new CommonResult().pageSuccess( newOrderInfo );
    }

    @ApiOperation( "获取数据汇总" )
    @PostMapping("/getDataSummary/{brandId}")
    public CommonResult getDataSummary(@PathVariable Long brandId,@RequestParam Integer storeId){
        HomeDateSummaryResult dataSummary=homeService.getDataSummary( brandId, storeId );
        return new CommonResult().success( dataSummary );
    }

    @ApiOperation( "获取交易图表/适用总账户，不传storeId即可" )
    @PostMapping("/getTransactionChart/{brandId}")
    public CommonResult getTransactionChart(@PathVariable Long brandId, @Validated @RequestBody HomeTransactionChartParams params, BindingResult bindingResult){
        HomeTransactionChartResult transactionChart=homeService.getTransactionChart( brandId, params );
        return new CommonResult().success( transactionChart );
    }

    @ApiOperation( "获取总账户首页数据汇总" )
    @PostMapping("/getMasterDataSummary/{brandId}")
    public CommonResult getMasterDataSummary(@PathVariable Long brandId){
        HomeDateSummaryResult masterDataSummary=homeService.getMasterDataSummary( brandId );
        return new CommonResult().success( masterDataSummary );
    }
}
