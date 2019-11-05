package com.shanyuan.common.utils;


import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-17 14:57
 * <p>
 * desc
 **/
@Component
public class GeneratorKeyUtil {



    /*生成一个uuid*/
    public static String getUid(){
        String uid=UUID.randomUUID().toString();
        return uid.replace( "-","" );
    }
}
