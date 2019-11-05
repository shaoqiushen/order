package com.shanyuan.common.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-10-22 10:04
 * <p>
 * desc
 **/
@Component
public class MyDateUtil {

    /**
     * descrition: String 时间格式转date
     * create_user: shenshaoqiu
     * create_date: 2019/10/22
     * create_time: 10:05
     * param:
     * return:
     **/
    public static Date StringTransToDate(String time) {
        SimpleDateFormat dateFormat=new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date parse=null;
        try {
            parse=dateFormat.parse( time );
        } catch ( ParseException e ) {
            e.printStackTrace();
        }
        return parse;
    }

    //Date 转String
    public static String DateTransToString(Date date) {
        SimpleDateFormat formatter=new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String dateString=formatter.format( date );
        return dateString;
    }

    public static String nowDateString() {
        SimpleDateFormat dateFormat=new SimpleDateFormat( "yyyy-MM-dd" );
        return dateFormat.format( new Date() );
    }

    public static String nowDateString(String pattern) {
        SimpleDateFormat dateFormat=new SimpleDateFormat( pattern );
        return dateFormat.format( new Date() );
    }

    /*获得昨天*/
    public static String getYesterday() {
        SimpleDateFormat format=new SimpleDateFormat( "yyyy-MM-dd" );
        Calendar cal=Calendar.getInstance();
        cal.add( Calendar.DATE, -1 );
        Date time=cal.getTime();
        return format.format( time );
    }

    /**
     * 获取两个日期之间的所有日期
     *
     * @param startTime 开始日期
     * @param endTime   结束日期
     * @return
     */
    public static List <String> getDays(String startTime, String endTime) {

        // 返回的日期集合
        List <String> days=new ArrayList <String>();

        DateFormat dateFormat=new SimpleDateFormat( "yyyy-MM-dd" );
        try {
            Date start=dateFormat.parse( startTime );
            Date end=dateFormat.parse( endTime );

            Calendar tempStart=Calendar.getInstance();
            tempStart.setTime( start );

            Calendar tempEnd=Calendar.getInstance();
            tempEnd.setTime( end );
            tempEnd.add( Calendar.DATE, +1 );// 日期加1(包含结束)
            while (tempStart.before( tempEnd )) {
                days.add( dateFormat.format( tempStart.getTime() ) );
                tempStart.add( Calendar.DAY_OF_YEAR, 1 );
            }

        } catch ( ParseException e ) {
            e.printStackTrace();
        }

        return days;
    }

    //获取两个时间相差的秒数
    public static long timeUnixMillis(String startTime, String endTime) {
        long a=0L;
        SimpleDateFormat format=new SimpleDateFormat( "yyyyMMdd HH:mm:ss" );
        try {
            Date date1=new Date();
            if (StringUtils.isEmpty( startTime )) {
                date1=format.parse( startTime );
            }
            Date date2=format.parse( endTime );
            a=(date2.getTime() - date1.getTime())/1000;
        } catch ( ParseException e ) {
            e.printStackTrace();
        }
        return a;
    }
}
