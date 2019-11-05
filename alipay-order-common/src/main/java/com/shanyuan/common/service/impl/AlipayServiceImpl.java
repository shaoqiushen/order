package com.shanyuan.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shanyuan.common.domain.AlipayTradeParams;
import com.shanyuan.common.domain.AlipayTradeResult;
import com.shanyuan.common.service.AlipayService;
import com.shanyuan.common.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-23 10:40
 * <p>
 * desc
 **/
@Service
public class AlipayServiceImpl implements AlipayService {

//    private static final String PAY_URL = "http://192.168.2.88:8080/alipay/pay/createtrade";
    private static final String PAY_URL = "https://www.shanyuankj.com/alipay/pay/createtrade";


    @Override
    public AlipayTradeResult createTrade(AlipayTradeParams params) {
        StringBuffer sb = new StringBuffer(  );
        sb.append( "appid="+params.getAppid() )
                .append( "&app="+params.getApp() )
                .append( "&body="+params.getBody() )
                .append( "&buyer_id="+params.getBuyer_id() )
                .append( "&extend_params="+params.getExtend_params() )
                .append( "&food_order_type="+params.getFood_order_type() )
                .append( "&goods_detail="+JSONObject.toJSONString( params.getGoods_detail() ) )
//                .append( "&operator_id="+params.getOperator_id() )
                .append( "&out_trade_no="+params.getOut_trade_no() )
                .append( "&store_id="+params.getStore_id() )
                .append( "&subject="+params.getSubject() )
                .append( "&total_amount="+params.getTotal_amount() )
                .append( "&url="+params.getUrl() )
                .append( "&type="+params.getType() );
        System.out.println(JSONObject.toJSONString( params.getGoods_detail()));
        String response=HttpUtils.getResponse( PAY_URL, sb.toString() );

        AlipayTradeResult alipayTradeResult=JSONObject.parseObject( response.replace( "\\", "" ).replace( "\"{","{" ).replace( "}\"}","}}" ), AlipayTradeResult.class );
        return alipayTradeResult;
    }
}
