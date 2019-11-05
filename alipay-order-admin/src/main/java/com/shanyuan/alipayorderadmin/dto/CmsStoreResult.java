package com.shanyuan.alipayorderadmin.dto;

import com.shanyuan.model.CmsStore;
import lombok.Data;


/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 14:40
 * <p>
 * desc
 **/
@Data
public class CmsStoreResult extends CmsStore {
    private String account;
    private String password;
    private Integer type;
}
