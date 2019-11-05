package com.shanyuan.alipayorderadmin;

import com.google.common.base.Function;
import com.shanyuan.alipayorderadmin.domain.Person;
import com.shanyuan.alipayorderadmin.service.PmsItemService;
import com.shanyuan.alipayorderadmin.service.impl.PmsItemServiceImpl;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlipayOrderAdminApplicationTests {

    @Autowired
    PmsItemServiceImpl pmsItemService;
    @Test
    public void contextLoads() {
        String imgPath = "https://oss.shanyuankj.com/alipay-order/images/admin/20191024/d2ad41e8a59e450d9634bf655c335d36.jpeg";
        File file = new File( imgPath );

//        String substring=imgPath.substring( imgPath.lastIndexOf( "." ), imgPath.length() );
//        System.out.println(substring);
//        System.out.println( file.getName() );
//        try {
//            pmsItemService.upload( "https://oss.shanyuankj.com/alipay-order/images/admin/20191024/d2ad41e8a59e450d9634bf655c335d36.jpeg",43 );
//        } catch ( IOException e ) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void test(){
//        List<Integer> list = new ArrayList <>(  );
//        list.add( 1 );
//        list.add( 185 );
//        list.add( 550 );
//        list.add( 65 );
//        list.add( 3 );
//
//        list.stream().filter( w -> w.intValue() > 5 ).forEach( s -> System.out.println(s));
        char a = 'A';
        System.out.println((byte)301);

    }




}
