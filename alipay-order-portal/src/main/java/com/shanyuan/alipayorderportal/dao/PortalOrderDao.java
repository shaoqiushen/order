package com.shanyuan.alipayorderportal.dao;

import com.shanyuan.alipayorderportal.dto.PayOrderDetailsResult;
import com.shanyuan.alipayorderportal.dto.PortalOrderDetailResult;
import com.shanyuan.alipayorderportal.dto.PortalOrderQueryParams;
import com.shanyuan.alipayorderportal.dto.PortalOrderQueryResult;
import com.shanyuan.model.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-18 9:43
 * <p>
 * desc
 **/
public interface PortalOrderDao {
    int insertOrderDetail(@Param( "list" ) List<OmsOrderDetail> omsOrderDetails);
    PortalOrderDetailResult getUserOrderDetail(@Param( "orderId" )Long orderId);
    List<PortalOrderQueryResult> listOrderInfoByParams(@Param( "portalOrderQueryParams" ) PortalOrderQueryParams portalOrderQueryParams,
                                                       @Param( "startNum" ) int startNum, @Param( "endNum" ) int endNum);
    int countOrder(@Param( "portalOrderQueryParams" ) PortalOrderQueryParams portalOrderQueryParams);

    List<PayOrderDetailsResult> getOrderDetails(@Param( "orderId" )Long orderId);


}
