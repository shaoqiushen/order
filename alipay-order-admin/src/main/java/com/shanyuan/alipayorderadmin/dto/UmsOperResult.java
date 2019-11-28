package com.shanyuan.alipayorderadmin.dto;

import com.shanyuan.model.UmsOper;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-11 8:53
 * <p>
 * desc
 **/
@Data
public class UmsOperResult extends UmsOper {
    private String roleName;
    private Integer storeId;
    private String storeName;
}
