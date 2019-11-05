package com.shanyuan.alipayorderportal.dto;

import com.shanyuan.alipayorderportal.domain.OrderDetail;
import com.shanyuan.model.OmsOrder;
import lombok.Data;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-18 14:27
 * <p>
 * desc
 **/
@Data
public class PortalOrderDetailResult extends OmsOrder {
    private Integer id;
    private Long orderId;
    private String storeName;
    private Integer tableMoney;
    private List<OrderDetail> orderDetailList;
}
