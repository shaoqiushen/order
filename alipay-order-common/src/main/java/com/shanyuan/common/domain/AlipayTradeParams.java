package com.shanyuan.common.domain;

import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-23 10:41
 * <p>
 * desc
 **/
@Data
public class AlipayTradeParams {
    //本地项目编号
    private String app;
    private String appid;
    //消费描述
    private String body;
    //支付宝用户id
    private String buyer_id;
    //业务扩展参数，有需要就传场景码，否则传000，点餐业务场景码101
    private int extend_params;
    //点餐场景类型，qr_order（店内扫码点餐），pre_order（预点到店自提），home_delivery （外送到家），direct_payment（直接付款），other（其他）
    private String food_order_type;
    //商户操作员编号,28字符内
    private String operator_id;
    //商户订单号
    private String out_trade_no;
    //门店id
    private String store_id;
    //订单标题
    private String subject;

    //订单总金额
    private String total_amount;
    //回调地址
    private String url;
    //创建订单的方式，1-用自己小程序的appid和私钥公钥调用，2-用服务商第三方应用的appid+app_auth_token和服务商的私钥公钥调用
    private int type;

    private List<ItemOrderDetail> goods_detail;
}
