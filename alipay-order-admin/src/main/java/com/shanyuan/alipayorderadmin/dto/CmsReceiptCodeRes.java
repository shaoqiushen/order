package com.shanyuan.alipayorderadmin.dto;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-08 10:47
 * <p>
 * desc
 **/
@Data
public class CmsReceiptCodeRes {
    private String storeName;
    private int codeAmount;
    private Integer storeId;
}
