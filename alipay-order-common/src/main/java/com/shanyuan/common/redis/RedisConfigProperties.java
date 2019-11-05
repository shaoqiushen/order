package com.shanyuan.common.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-03-20 16:45
 * <p>
 * desc
 **/
@Configuration
@ConfigurationProperties(prefix="redis")
@PropertySource( value="classpath:redis.properties" )
@Data
public class RedisConfigProperties {
    //主机地址
    public String host;
    //端口
    public int port;
    //密码没有不填写
    public String password;
    // Redis数据库索引（默认为0）

    public int database;
    //最大活跃连接
    public int maxActive;
    //连接池最大阻塞等待时间（使用负值表示没有限制）
    public int maxWait;
    //连接池中的最大空闲连接
    public int maxIdle;
    //连接池中的最小空闲连接
    public int minIdle;
    //连接超时时间（毫秒）
    public int timeOut;

}
