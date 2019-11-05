package com.shanyuan.alipayorderadmin.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-28 14:06
 * <p>
 * desc
 **/
@Data
public class AliImgParams {
    private String img_path = "";
    private String app="2001";
//    private MultipartFile file;
    private String local_goods_id;
    //业务场景描述，比如订单信息同步场景对应SYNC_ORDER
    private String scene = "SYNC_ORDER";
    //创建订单的方式，1-用自己小程序的appid和私钥公钥调用，2-用服务商第三方应用的appid+app_auth_token和服务商的私钥公钥调用
    private Integer type = 1;
    private String appid;
}
