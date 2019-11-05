package com.shanyuan.alipayorderportal.service;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 17:13
 * <p>
 * desc
 **/
public interface PortalSystemFeeService {
    Integer getTableMoney(Long brandId,Integer storeId);
    Integer getDelivery(Long brandId,Integer storeId);
    Integer getPackage(Long brandId,Integer storeId);
}
