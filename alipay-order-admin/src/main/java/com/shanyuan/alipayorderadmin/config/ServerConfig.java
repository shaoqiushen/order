package com.shanyuan.alipayorderadmin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-07-18 10:18
 * <p>
 * desc
 **/
@Configuration
@ConfigurationProperties(prefix="myserver")
@PropertySource( "classpath:myserver.properties" )
@Data
public class ServerConfig {
    private String serveraddr;
    private String myaddr;
}
