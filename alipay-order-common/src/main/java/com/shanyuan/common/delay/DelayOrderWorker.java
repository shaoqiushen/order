package com.shanyuan.common.delay;

import com.shanyuan.common.config.ApplicationContextProvider;
import com.shanyuan.mapper.OmsOrderMapper;
import com.shanyuan.model.OmsOrder;
import com.shanyuan.model.OmsOrderExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-07-26 16:31
 * <p>
 * desc
 **/
public class DelayOrderWorker  implements Runnable{

    private long orderId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId=orderId;
    }

    public OmsOrderMapper getOmsOrderMapper() {
        return omsOrderMapper;
    }

    public void setOmsOrderMapper(OmsOrderMapper omsOrderMapper) {
        this.omsOrderMapper=omsOrderMapper;
    }

    @Autowired
    OmsOrderMapper omsOrderMapper;

    // 延时队列 ,消费者从其中获取消息进行消费


    public DelayOrderWorker(){
        this.omsOrderMapper=ApplicationContextProvider.getBean( OmsOrderMapper.class );
    }




    @Override
    public void run() {

            try {
                //处理逻辑
                //查询订单的状态是否未支付
                OmsOrderExample example = new OmsOrderExample();
                example.createCriteria().andOrderIdEqualTo( orderId );
                List <OmsOrder> omsOrders=omsOrderMapper.selectByExample( example );
                if(omsOrders.size()>0){
                    Integer orderStatus=omsOrders.get( 0 ).getOrderStatus();
                    if(orderStatus == 0){
                        //待付款则修改为关闭
                        OmsOrder omsOrder = new OmsOrder();
                        omsOrder.setOrderStatus( 7 );//关闭
                        omsOrder.setUpdateTime( new Date(  ) );
                        omsOrder.setCancelDesc( "订单超时关闭" );
                        omsOrderMapper.updateByExampleSelective( omsOrder,example);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
