package com.shanyuan.alipayorderportal;

import com.google.common.collect.Lists;
import com.shanyuan.alipayorderportal.service.SerialNumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlipayOrderPortalApplicationTests {

    @Autowired
    SerialNumberService serialNumberService;

    @Test
    public void contextLoads() {

//        ExtInfo extInfo=JSONObject.parseObject( " [{\n" + "\"ext_key\": \"image_material_id\",  //菜品图片\n" + "\"ext_value\": \"2019061700502200000017592474\"\n" + "},\n" + "{\n" + "\"ext_key\": \"dish_type\", //菜品\n" + "\"ext_value\": \"FAST_FOOD\"\n" + "}", ExtInfo.class );

//        String response = "{\"status\":1,\"code\":\"1000\",\"msg\":\"OK\",\"data\":{\"app\":\"2001\",\"appid\":\"2019101768460358\",\"type\":1,\"out_biz_no\":\"sync20191029161728339403\",\"out_trade_no\":\"6040490759430912\",\"buyer_id\":\"2088802888023441\",\"seller_id\":\"2088231038923230\",\"partner_id\":\"2088231038923230\",\"amount\":\"0.01\",\"trade_no\":\"2019102922001423445706250826\",\"item_order_list\":\"[{\\\"ext_info\\\":[{\\\"ext_key\\\":\\\"dish_type\\\",\\\"ext_value\\\":\\\"chinese_local_dish\\\"},{\\\"ext_key\\\":\\\"flavor\\\",\\\"ext_value\\\":\\\"pungent\\\"},{\\\"ext_key\\\":\\\"cooking_method\\\",\\\"ext_value\\\":\\\"pot_stewed\\\"},{\\\"ext_key\\\":\\\"image_material_id\\\",\\\"ext_value\\\":\\\"2019102900502200000027632100\\\"}],\\\"item_id\\\":\\\"61\\\",\\\"item_name\\\":\\\"商4\\\",\\\"quantity\\\":1,\\\"sku_id\\\":\\\"46\\\",\\\"unit_price\\\":0.01}]\",\"ext_info\":\"[{\\\"ext_key\\\":\\\"merchant_order_link_page\\\",\\\"ext_value\\\":\\\"/pages/order/detail/detail?id=6040490759430912\\\"}]\",\"alipay_response_code\":\"1\",\"alipay_response_sub_code\":null,\"alipay_response_sub_msg\":null,\"order_sync_id\":\"2019102900502300440100000001411903\",\"ctime\":null}}";
//        SycnOrderResponse serverResponse=JSONObject.parseObject( response, SycnOrderResponse.class );
//        System.out.println(serverResponse.getData().getOrder_sync_id());

        //默认编码需要5位，位数不够前面补0
        String formattNum = String.format("%05d", 1);
        StringBuilder sb = new StringBuilder(20);
        //转换成业务需要的格式  bizCode + date + incr
        sb.append(formattNum);
        System.out.println(sb.toString());


//        serialNumberService.generate( "M" );

    }


    @Test
    public void testParse() {
        ExecutorService executorService=Executors.newCachedThreadPool();
        List <String> dateStrList=Lists.newArrayList( "2018-04-01 10:00:01", "2018-04-02 11:00:02", "2018-04-03 12:00:03", "2018-04-04 13:00:04", "2018-04-05 14:00:05" );

        for (String str : dateStrList) {
            executorService.execute( () -> {
                try {
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" );
                    simpleDateFormat.parse( str );

//                    TimeUnit.SECONDS.sleep( 1 );
                    simpleDateFormat = null; //销毁对象
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            } );
        }
    }

    @Test
    public void sf(){
        String a = "a";
        String b = new String( "a" );
        System.out.println(b);
        System.out.println(a.equals( b ));//值相等
        System.out.println(a==b);//同一引用
        System.out.println(a.hashCode()==b.hashCode());

        System.out.println( "Aa".hashCode() == "BB".hashCode() );

        //hashcode相同， 值不一定相等， 值相等，则hashcode一定相等
    }


}
