package com.shanyuan.alipayorderadmin.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-31 10:22
 * <p>
 * desc
 **/
@Data
@ApiModel
public class BrandStoreParams {
    private Long brandId;
    private Integer storeId;
}
