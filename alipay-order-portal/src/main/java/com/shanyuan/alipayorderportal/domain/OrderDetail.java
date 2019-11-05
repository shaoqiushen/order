package com.shanyuan.alipayorderportal.domain;

import com.shanyuan.model.OmsOrderDetail;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-21 11:36
 * <p>
 * desc
 **/
@Data
public class OrderDetail extends OmsOrderDetail {
    private String itemName;
}
