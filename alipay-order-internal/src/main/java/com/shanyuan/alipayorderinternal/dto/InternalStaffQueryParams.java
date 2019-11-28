package com.shanyuan.alipayorderinternal.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 11:32
 * <p>
 * desc
 **/
@Data
public class InternalStaffQueryParams {
    @ApiModelProperty("员工姓名")
    private String staffName;
    @ApiModelProperty("店铺名称")
    private String storeName;
}
