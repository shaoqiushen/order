package com.shanyuan.alipayorderportal.service.impl;

import com.aliyun.oss.ServiceException;
import com.shanyuan.alipayorderportal.service.SerialNumberService;
import com.shanyuan.common.redis.RedisOperator;
import com.shanyuan.common.utils.MyDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-11-01 10:47
 * <p>
 * desc 流水号生成
 **/
@Service
public class SerialNumberServiceImpl implements SerialNumberService {

    @Autowired
    RedisOperator redisOperator;
    /**
     * 定义流水号工单默认前缀
     */
    private static final String SERIAL_NUMBER = "order:serial:";

    @Override
    public String generate(String brandId,String storeId) {

//        if(StringUtils.isEmpty(brandId)){
//            throw new ServiceException("流水号业务类型不能为空");
//        }

        //获取当前时间,返回格式如yyyyMMdd
        String date =MyDateUtil.nowDateString("yyyyMMdd");
        //构造redis过期时间 UnixMillis
        //设置过期时间为当前时间的最后一秒
//        long expire = TimeUtil.time2UnixMillis(date + " 23:59:59",ItsmConstants.FORMATTER_YYYYMMDD_TIME);
        long expire = MyDateUtil.timeUnixMillis(date,date + " 23:59:59");

        //构造redis的key
        String key = SERIAL_NUMBER + date +":"+ brandId+":"+storeId;

        //判断key是否存在
        Boolean exists = redisOperator.exists(key);

        long incr=redisOperator.incr( key );
        //设置过期时间
        if(!exists){
            redisOperator.expire( key,expire );
        }

        //默认编码需要5位，位数不够前面补0
        String formattNum = String.format("%05d", incr);
        StringBuilder sb = new StringBuilder(20);
        //转换成业务需要的格式  bizCode + date + incr
        sb.append(formattNum);
        return sb.toString();
    }
}
