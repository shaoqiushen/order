package com.shanyuan.alipayorderadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderadmin.dao.TransOrderDao;
import com.shanyuan.alipayorderadmin.dto.HomeDateSummaryResult;
import com.shanyuan.alipayorderadmin.dto.HomeTransactionChartResult;
import com.shanyuan.alipayorderadmin.service.CmsStoreService;
import com.shanyuan.alipayorderadmin.service.HomeService;
import com.shanyuan.alipayorderadmin.service.OmsReceiptCodeService;
import com.shanyuan.common.domain.HomeTransactionChartParams;
import com.shanyuan.common.domain.TransOrderInfo;
import com.shanyuan.common.utils.MyDateUtil;
import com.shanyuan.mapper.OmsOrderMapper;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 14:07
 * <p>
 * desc
 **/
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Autowired
    TransOrderDao transOrderDao;

    @Autowired
    CmsStoreService cmsStoreService;

    @Autowired
    OmsReceiptCodeService omsReceiptCodeService;

    @Override
    public PageInfo <OmsOrder> getNewOrderInfo(Long brandId, Integer storeId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum, pageSize );
        OmsOrderExample example=new OmsOrderExample();
        example.setOrderByClause( "id desc" );
        example.createCriteria().andBrandIdEqualTo( brandId ).andStoreIdEqualTo( storeId ).andOrderStatusEqualTo( 1 );
        List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
        PageInfo <OmsOrder> pageInfo=new PageInfo <>( omsOrders );
        return pageInfo;
    }

    /*子账户首页查询*/
    @Override
    public HomeDateSummaryResult getDataSummary(Long brandId, Integer storeId) {
        HomeDateSummaryResult result = new HomeDateSummaryResult();
        //查询收款码总数
        int receiptCodeTotal=omsReceiptCodeService.countCode( brandId, storeId );
        result.setReceiptCodeTotal( receiptCodeTotal );
        //查询交易额
        //获取当前时间
        String nowDate=MyDateUtil.nowDateString();
        Map mapNow=this.getTransactionTotal( brandId, storeId, nowDate+" 00:00:00",nowDate+" 23:59:59" );
        //今日交易额
        result.setToDayTransactionAmount( (int)mapNow.get( "transactionTotal" ) );
        //今日订单数
        result.setToDayOrderTotal( (int)mapNow.get( "orderTotal" ) );

        String yesterday=MyDateUtil.getYesterday();
        Map mapYes=this.getTransactionTotal( brandId, storeId, yesterday+" 00:00:00",yesterday+" 23:59:59" );
        //昨日交易额
        result.setYesDayTransactionAmount( (int)mapYes.get( "transactionTotal" ) );
        //昨日订单数
        result.setYesDayOrderTotal( (int)mapYes.get( "orderTotal" ) );

        return result;
    }

    @Override
    public HomeTransactionChartResult getTransactionChart(Long brandId, HomeTransactionChartParams params) {
        HomeTransactionChartResult result = new HomeTransactionChartResult();
        //获取两个日期之间相差的日期
        List <String> days=MyDateUtil.getDays( params.getStartTime(), params.getEndTime() );
        result.setDayList( days );
        //计算数据
        List <TransOrderInfo> transOrderInfo=this.getTransOrderInfo( brandId, params );
        result.setTransOrderInfoList( transOrderInfo );
        return result;
    }

    /*总账户首页数据查询*/
    @Override
    public HomeDateSummaryResult getMasterDataSummary(Long brandId) {
        HomeDateSummaryResult result = new HomeDateSummaryResult();
        //查询收款码总数
        int receiptCodeTotal=omsReceiptCodeService.countCode( brandId, -1 );
        result.setReceiptCodeTotal( receiptCodeTotal );
        //查询店铺总数
        int storeAmount=cmsStoreService.countStore( brandId );
        result.setStoreAmount( storeAmount );
        //查询交易额
        //获取当前时间
        String nowDate=MyDateUtil.nowDateString();
        Map mapNow=this.getTransactionTotal( brandId, -1, nowDate+" 00:00:00",nowDate+" 23:59:59" );
        //今日交易额
        result.setToDayTransactionAmount( (int)mapNow.get( "transactionTotal" ) );
        //今日订单数
        result.setToDayOrderTotal( (int)mapNow.get( "orderTotal" ) );

        String yesterday=MyDateUtil.getYesterday();
        Map mapYes=this.getTransactionTotal( brandId, -1, yesterday+" 00:00:00",yesterday+" 23:59:59" );
        //昨日交易额
        result.setYesDayTransactionAmount( (int)mapYes.get( "transactionTotal" ) );
        //昨日订单数
        result.setYesDayOrderTotal( (int)mapYes.get( "orderTotal" ) );

        return result;
    }

    private Map getTransactionTotal(Long brandId, Integer storeId, String startTime,String endTime) {

        OmsOrderExample example=new OmsOrderExample();
        OmsOrderExample.Criteria criteria=example.createCriteria();
        criteria.andBrandIdEqualTo( brandId ).
                andPaymentTimeGreaterThanOrEqualTo( MyDateUtil.stringTransToDate( startTime ) ).
                andPaymentTimeLessThanOrEqualTo( MyDateUtil.stringTransToDate(endTime) );
        if(storeId != -1){
            criteria.andStoreIdEqualTo( storeId );
        }
        List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
        int transactionTotal=0;
        if (omsOrders.size() > 0) {
            for (OmsOrder omsOrder : omsOrders) {
                transactionTotal+=omsOrder.getPayAmount();
            }
        }
        Map map = new HashMap(  );
        map.put( "transactionTotal",transactionTotal );
        map.put( "orderTotal",omsOrders.size() );
        return map;
    }

    private List<TransOrderInfo> getTransOrderInfo(Long brandId, HomeTransactionChartParams params){
        params.setStartTime( params.getStartTime()+" 00:00:00" );
        params.setEndTime( params.getEndTime()+" 23:59:59" );
        List <TransOrderInfo> transOrderInfo=transOrderDao.getTransOrderInfo( brandId, params );
        return transOrderInfo;
    }


}
