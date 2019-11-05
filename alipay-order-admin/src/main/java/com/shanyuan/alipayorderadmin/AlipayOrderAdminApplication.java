package com.shanyuan.alipayorderadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@MapperScan({"com.shanyuan.mapper","com.shanyuan.alipayorderadmin.dao"})
@ComponentScan({"com.shanyuan"})
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class AlipayOrderAdminApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run( AlipayOrderAdminApplication.class, args );
    }

    /*将springboot项目打包成war*/
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(AlipayOrderAdminApplication.class);
    }
    /**
     * 显示声明CommonsMultipartResolver为mutipartResolver
     * 图片作压缩
     */
    @Bean(name="multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        //resolver.setDefaultEncoding("UTF-8");
        //resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setResolveLazily(true);
        resolver.setMaxInMemorySize(4096000);
        resolver.setMaxUploadSize(3 * 1024 * 1024);//上传文件大小 3M 3*1024*1024
        return resolver;
    }
}
