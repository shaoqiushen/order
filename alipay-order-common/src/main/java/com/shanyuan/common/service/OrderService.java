package com.shanyuan.common.service;

import com.shanyuan.common.domain.OmsOrderQueryParams;
import com.shanyuan.model.OmsOrder;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-07 17:04
 * <p>
 * desc
 **/
public interface OrderService {
    List<OmsOrder> listOrder(Integer pageNum, Integer pageSize, OmsOrderQueryParams params);
}
