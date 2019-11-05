package com.shanyuan.alipayorderportal.dto;

import com.shanyuan.alipayorderportal.domain.EncryptData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-31 14:04
 * <p>
 * desc
 **/
@Data
@ApiModel
public class PortalObtainPhoneParams {
    @ApiModelProperty(value="appid",required=true)
    @NotEmpty(message="appid不允许为空")
    private String appid;

//    @ApiModelProperty(value="加密数据",required=true,example="{\"response\":\"L+YTXDTltoqoFaTlQqJ9VbG236aRYoEWvD6Y0yqTs1ZGIsEVpGYD1rYvupvTdvT7FWJndmCyH3eOi85k9VkaZA==\", \"sign\":\"bRTZ/zXKSIo8dE79ZHhCl9BJp+LPVcMGkkEnKj8YpLPEcfv6vifYlLaSH2aRQ+pAIp1EC+Z4K1SVYefLU6M40qyeX+fvIzgr/VowQq/gFgjZ72NOiLMVbrwepvL4sBTv8aca5M2acFt+LMmWFTNQ1LZEeGZdK4Uh7Y9B6FqX53AWKkyLSPJPK3fAE1IyG/1G19CNjQJvC/k6ur8fyO5fuJSbiJNUvOtW0tfVbNt4wu0+d66H5lHc/iZtnO6Avydc38WL7vR/0yVK4MiCv/B56APBjiTge9N0g5XmDb4HfyVUAt3XcclRsHqyEOI9P7DbIJvLZLErRrFlaUsI4T7WjA==\"}")
//    @NotEmpty(message="加密数据不允许为空")
//    private String encryptedData;

//    @ApiModelProperty(value="加密响应",required=true,example="L+YTXDTltoqoFaTlQqJ9VbG236aRYoEWvD6Y0yqTs1ZGIsEVpGYD1rYvupvTdvT7FWJndmCyH3eOi85k9VkaZA==")
//    @NotEmpty(message="response不允许为空")
//    private String response;
//    @ApiModelProperty(value="加密签名",required=true,example="bRTZ/zXKSIo8dE79ZHhCl9BJp+LPVcMGkkEnKj8YpLPEcfv6vifYlLaSH2aRQ+pAIp1EC+Z4K1SVYefLU6M40qyeX+fvIzgr/VowQq/gFgjZ72NOiLMVbrwepvL4sBTv8aca5M2acFt+LMmWFTNQ1LZEeGZdK4Uh7Y9B6FqX53AWKkyLSPJPK3fAE1IyG/1G19CNjQJvC/k6ur8fyO5fuJSbiJNUvOtW0tfVbNt4wu0+d66H5lHc/iZtnO6Avydc38WL7vR/0yVK4MiCv/B56APBjiTge9N0g5XmDb4HfyVUAt3XcclRsHqyEOI9P7DbIJvLZLErRrFlaUsI4T7WjA==")
//    @NotEmpty(message="签名不允许为空")
//    private String sign;
    @ApiModelProperty(value="加密数据串",required=true)
    private EncryptData encryptedData;

}
