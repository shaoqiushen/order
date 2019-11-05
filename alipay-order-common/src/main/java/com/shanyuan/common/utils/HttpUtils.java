package com.shanyuan.common.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class HttpUtils {
	
	@SuppressWarnings("unused")
	public static String getResponse(String requsetUrl, String content) {
        StringBuffer responseSb=null;
        try {
            URL url=new URL( requsetUrl );
            HttpURLConnection httpConn=( HttpURLConnection ) url.openConnection();
            httpConn.setDoOutput( true ); // 使用 URL 连接进行输出
            httpConn.setDoInput( true ); // 使用 URL 连接进行输入
            httpConn.setUseCaches( false ); // 忽略缓存
            httpConn.setRequestMethod( "POST" ); // 设置URL请求方法
            OutputStream outputStream=httpConn.getOutputStream();
            outputStream.write( content.getBytes( "UTF-8" ) );
            outputStream.close();
            BufferedReader responseReader=new BufferedReader( new InputStreamReader( httpConn.getInputStream(), "UTF-8" ) );
            String readLine;
            responseSb=new StringBuffer();
            while ((readLine=responseReader.readLine()) != null) {
                responseSb.append( readLine );
            }

        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return responseSb.toString();
    }

}
