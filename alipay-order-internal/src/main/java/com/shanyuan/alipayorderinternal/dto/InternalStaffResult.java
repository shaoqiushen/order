package com.shanyuan.alipayorderinternal.dto;

import com.shanyuan.model.MysStaff;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 11:33
 * <p>
 * desc
 **/
@Data
public class InternalStaffResult extends MysStaff {
    private String signTime;
    private String storeName;
}
