package com.shanyuan.common.domain;

import com.shanyuan.model.OmsOrderDetail;
import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-25 17:06
 * <p>
 * desc
 **/
@Data
public class OmsOrderDetailResult extends OmsOrderDetail {
    private String itemName;
    private String tradeNo;
    private Long brandId;
}
