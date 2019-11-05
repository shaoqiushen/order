package com.shanyuan.alipayorderadmin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shanyuan.alipayorderadmin.config.ServerConfig;
import com.shanyuan.alipayorderadmin.domain.OrderRefund;
import com.shanyuan.alipayorderadmin.domain.ServerRefundResponse;
import com.shanyuan.alipayorderadmin.service.RefundService;
import com.shanyuan.common.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 9:18
 * <p>
 * desc
 **/
@Service
public class RefundServiceImpl implements RefundService {

    @Autowired
    ServerConfig serverConfig;


    @Override
    public ServerRefundResponse refund(OrderRefund orderRefund) {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append( "appid="+orderRefund.getAppid() )
                .append( "&out_trade_no="+orderRefund.getOut_trade_no() )
                .append( "&refund_amount="+orderRefund.getRefund_amount() )
                .append( "&refund_reason="+orderRefund.getRefund_reason() )
                .append( "&trade_no="+orderRefund.getTrade_no() )
                .append( "&type="+orderRefund.getType() );
        String response=HttpUtils.getResponse( serverConfig.getServeraddr() + "/pay/refund", stringBuffer.toString() );
        ServerRefundResponse serverCommonResponse=JSONObject.parseObject( response, ServerRefundResponse.class );
        return serverCommonResponse;
    }
}
