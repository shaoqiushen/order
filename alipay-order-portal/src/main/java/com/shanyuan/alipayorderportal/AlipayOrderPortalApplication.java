package com.shanyuan.alipayorderportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan({"com.shanyuan.alipayorderportal","com.shanyuan.common"})
@MapperScan({"com.shanyuan.mapper","com.shanyuan.alipayorderportal.dao","com.shanyuan.common.dao"})
public class AlipayOrderPortalApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run( AlipayOrderPortalApplication.class, args );
    }
    /*将springboot项目打包成war*/
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(AlipayOrderPortalApplication.class);
    }
}
