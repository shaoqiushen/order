package com.shanyuan.common.utils;

import com.shanyuan.common.delay.DelayOrderQueueManager;
import com.shanyuan.common.delay.DelayOrderWorker;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-18 10:44
 * <p>
 * desc 延迟队列
 **/
@Component
public class DelayUtil {

    //推送延迟队列
    public void putDelay(int milliseconds, Long orderId) {
        //定义任务
        DelayOrderWorker work=new DelayOrderWorker();// 任务3
        work.setOrderId( orderId );
        //延迟队列管理类，将任务转化消息体并将消息体放入延迟对列中等待执行
        DelayOrderQueueManager manager=DelayOrderQueueManager.getInstance();
        //推送
        manager.put( work, milliseconds, TimeUnit.MILLISECONDS );
    }
}
