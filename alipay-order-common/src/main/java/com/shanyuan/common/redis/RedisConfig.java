package com.shanyuan.common.redis;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-03-20 16:57
 * <p>
 * desc
 **/
@Configuration
public class RedisConfig {

    @Autowired
    RedisConfigProperties redis;

    @Bean
    public RedisSerializer fastJsonRedisSerializer(){
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        return new FastJsonRedisSerializer<Object>(Object.class);
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大空闲接连
        jedisPoolConfig.setMaxIdle(redis.getMaxIdle());
        //最小空闲连接
        jedisPoolConfig.setMinIdle(redis.getMinIdle());
        //连接池最大阻塞等待时间
        jedisPoolConfig.setMaxWaitMillis(redis.getMaxWait());
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        //主机地址
        jedisConnectionFactory.setHostName(redis.getHost());
        //端口
        jedisConnectionFactory.setPort(redis.getPort());
        //密码
        jedisConnectionFactory.setPassword(redis.getPassword());
        //索引
        jedisConnectionFactory.setDatabase(redis.getDatabase());
        //超时时间
        jedisConnectionFactory.setTimeout(redis.getTimeOut());
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory, RedisSerializer fastJsonRedisSerializer) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate(factory);
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        //redis   开启事务
//        redisTemplate.setEnableTransactionSupport(true);

        //hash  使用jdk  的序列化
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility( PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);/*new JdkSerializationRedisSerializer()*/
        //StringRedisSerializer  key  序列化//一般可以不做设置
        //redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //keySerializer  对key的默认序列化器。默认值是StringSerializer
        //redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }



}
