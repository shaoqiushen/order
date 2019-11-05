package com.shanyuan.common.enums;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-16 11:30
 * <p>
 * desc
 **/
public enum ExceptionEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    CREATE_ITEM_ERROR(10001,"创建产品信息失败"),
    UPDATE_ITEM_ERROR(10002,"修改产品信息失败"),
    CREATE_CART_ERROR(10003,"添加购物车失败"),
    QUERY_ERROR(20001,"查询异常"),
    GET_ALI_USERINFO_ERROR(20002,"获取支付宝用户信息失败"),
    CREATE_ORDER_ERROR(30001,"创建订单失败"),
    PAY_CALLBACK_ERROR(30002,"支付回调失败"),
    PAY_ERROR(30003,"支付失败"),

    USER_NOT_EXISTS(40001,"用户不存在"),
    STORE_NOT_EXISTS(40002,"店铺不存在"),
    ORDER_NOT_EXISTS(40003,"订单不存在"),
    ORDER_STATUS_ERROR(40005,"订单状态不正确"),
    CREATE_USER_ADDR_ERROR(40006,"创建收货地址失败"),

    ACCPAS_ERROR(50001,"用户名或密码错误"),



    NOT_LOGIN(90000,"未登录或登录超时，请重新登录"),
    NOT_AUTH(90001,"对不起，您不具备操作权限");


    private int code;
    private String msg;

    ExceptionEnum(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg=msg;
    }
}
