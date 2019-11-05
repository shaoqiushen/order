package com.shanyuan.alipayorderadmin.dto;

import com.shanyuan.model.CmsReceiptCode;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 15:21
 * <p>
 * desc
 **/
@Data
public class CmsReceiptCodeResult extends CmsReceiptCode {
    private Integer receiptTotal;
}
