package com.shanyuan.alipayorderportal.dto;

import com.shanyuan.alipayorderportal.domain.OrderDetail;
import com.shanyuan.model.OmsOrder;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-06 15:48
 * <p>
 * desc
 **/
@Data
public class PortalOrderQueryResult extends OmsOrder {
    private String storeName;
    private List<OrderDetail> orderDetailList;
}
