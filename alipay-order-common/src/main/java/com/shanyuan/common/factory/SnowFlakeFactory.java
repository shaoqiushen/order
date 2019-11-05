package com.shanyuan.common.factory;


import com.shanyuan.common.utils.SnowFlake;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-03-14 13:39
 * <p>
 * desc 雪花算法获取唯一主键单例工厂
 **/
public class SnowFlakeFactory {

    private static SnowFlakeFactory snowFlakeFactory = new SnowFlakeFactory();
    private static SnowFlake snowFlake = new SnowFlake( 2,3 );
    private SnowFlakeFactory(){

    }

    public synchronized static SnowFlakeFactory getInstance(){
        if(snowFlakeFactory == null){
            return new SnowFlakeFactory();
        }
        return snowFlakeFactory;
    }

    public synchronized long getId(){
        return snowFlake.nextId();
    }
}
