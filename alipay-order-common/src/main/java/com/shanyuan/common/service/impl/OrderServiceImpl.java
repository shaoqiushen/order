package com.shanyuan.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.shanyuan.common.domain.OmsOrderQueryParams;
import com.shanyuan.common.service.OrderService;
import com.shanyuan.common.utils.MyDateUtil;
import com.shanyuan.mapper.OmsOrderMapper;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-07 17:04
 * <p>
 * desc
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Override
    public List<OmsOrder> listOrder(Integer pageNum, Integer pageSize, OmsOrderQueryParams params) {
        PageHelper.startPage( pageNum, pageSize );
        OmsOrderExample example=new OmsOrderExample();
        example.setOrderByClause( "id desc" );
        OmsOrderExample.Criteria criteria=example.createCriteria();
        if (params.getOrderId() != null) {
            criteria.andOrderIdEqualTo( params.getOrderId() );
        }
        if (!StringUtils.isEmpty( params.getStartTime() )) {
            criteria.andCreateTimeGreaterThanOrEqualTo( MyDateUtil.stringTransToDate( params.getStartTime() + " 00:00:00" ) );
        }
        if (!StringUtils.isEmpty( params.getEndTime() )) {
            criteria.andCreateTimeLessThanOrEqualTo( MyDateUtil.stringTransToDate( params.getEndTime() + " 23:59:59" ) );
        }
        if(params.getOrderStatus() != null){
            criteria.andOrderStatusEqualTo( params.getOrderStatus() );
        }
        if(params.getStoreId() != null){
            criteria.andStoreIdEqualTo( params.getStoreId() );
        }
        criteria.andOrderTypeEqualTo( params.getOrderType() );
        criteria.andBrandIdEqualTo( params.getBrandId() );
        criteria.andDeleteStatusEqualTo( 0 );
        List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
        return omsOrders;
    }
}
