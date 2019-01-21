package com.learn.demo.util;


import com.learn.demo.enums.Season;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间转换工具类
 */
public class DateUtils {

    /**
     * 字符串转换成日期
     * @param time 字符串日期
     * @param format 字符串格式：yyyy-MM-dd
     * @return Date类型的时间
     */
    public static Date stringToDate(String time,String format){
        if(time == null) {
            return null;
        }
        SimpleDateFormat sf = new SimpleDateFormat(format);
        try {
            Date rt = sf.parse(time);
            return rt;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 默认字符串转换成日期
     * @param time 字符串日期
     * @return 返回默认类型为yyyy-MM-dd的日期时间
     */
    public static Date stringToDate(String time){
        return stringToDate(time,"yyyy-MM-dd");
    }

    /**
     * 格式化时间，传入2019-01-08类似的字符串，产生一个以00:00:00结尾
     * 的“2019-01-08  00:00:00”Date类型的时间。
     * @param time 字符串时间类型，格式为yyyy-MM-dd。
     * @return “yyyy-MM-dd 00:00:00”Date类型的时间
     */
    public static Date stringToDateForStart(String time){
        if(time == null) {
            return null;
        }
        return stringToDate(dateToString(stringToDate(time))+" 00:00:00","yyyy-MM-dd HH:mm:SS");
    }

    /**
     * 格式化时间，传入2019-01-08类似的字符串，产生一个以23:59:59结尾
     * 的“2019-01-08  23:59:59”Date类型的时间。
     * @param time 字符串时间类型，格式为yyyy-MM-dd。
     * @return “yyyy-MM-dd 23:59:59”Date类型的时间
     */
    public static Date stringToDateForEnd(String time){
        if(time == null) {
            return null;
        }
        return stringToDate(dateToString(stringToDate(time))+" 23:59:59","yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param time
     * @param i 为增加的天数，负数则为减
     * @return
     */
    public static Date stringToDateForEnd(String time,int i){
        if(time == null) {
            return null;
        }
        Date date =  stringToDate(time);
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DATE, i);
        return stringToDate(dateToString(ca.getTime()) + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 时间转换成字符串
     * @param time Date类型的日期时间
     * @param format 字符串转换成为的格式
     * @return 返回字符串
     */
    public static String dateToString(Date time,String format){
        if(time == null) {
            return null;
        }
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(time);
    }

    /**
     * 默认时间转换成字符串方法
     * @param time Date类型的时间
     * @return yyyy-MM-dd类型的字符串时间
     */
    public static String dateToString(Date time){
        return dateToString(time,"yyyy-MM-dd");
    }

    /**
     * 通过传入的年份和季度(枚举)，计算出该季度的第一天
     * @param year 年
     * @param quarter 季度Q1，Q2，Q3，Q4
     * @return
     */
    public static String getStartTimeFromQuarter(String year,Season quarter){
        String startTime = year+quarter.getStartTime();
        return startTime;
    }
    /**
     * 通过传入的年份和季度(枚举)，计算出该季度的最后一天
     * @param year 年
     * @param quarter 季度Q1，Q2，Q3，Q4
     * @return
     */
    public static String getEndTimeFromQuarter(String year,Season quarter){
        String endTime = year+quarter.getEndTime();
        return endTime;
    }

    /**
     * 获取当前时间月份偏移量
     * @param offMonths 正数表示向后增加月份，负数表示向前减少月份
     * @return -1 表示前一个月，如返回2018-12
     */
    public static String getOffMonth(int offMonths){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,offMonths);
        return dateToString(calendar.getTime(),"yyyy-MM");
    }
//    public static void main(String[] args){
//        System.out.println(getOffMonth(-1));
//        System.out.println(getOffMonth(-12));
//    }
}
