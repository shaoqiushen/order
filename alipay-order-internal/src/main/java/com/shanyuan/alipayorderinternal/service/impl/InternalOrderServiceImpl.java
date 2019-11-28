package com.shanyuan.alipayorderinternal.service.impl;

import com.github.pagehelper.PageInfo;
import com.shanyuan.alipayorderinternal.service.InternalOrderService;
import com.shanyuan.common.dao.OrderDao;
import com.shanyuan.common.domain.OmsOrderDetailResult;
import com.shanyuan.common.domain.OmsOrderQueryParams;
import com.shanyuan.common.service.OrderService;
import com.shanyuan.model.OmsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-07 17:52
 * <p>
 * desc
 **/
@Service
public class InternalOrderServiceImpl implements InternalOrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderService orderService;

    @Override
    public PageInfo <OmsOrder> listOrder(Integer pageNum, Integer pageSize, OmsOrderQueryParams params) {
        List <OmsOrder> omsOrders=orderService.listOrder( pageNum, pageSize, params );
        PageInfo <OmsOrder> pageInfo=new PageInfo <>( omsOrders );
        return pageInfo;
    }

    @Override
    public List <OmsOrderDetailResult> listOrderDetail(Long orderId) {
        List <OmsOrderDetailResult> omsOrderDetailResults=orderDao.listOrderDetail( orderId );
        return omsOrderDetailResults;
    }
}
