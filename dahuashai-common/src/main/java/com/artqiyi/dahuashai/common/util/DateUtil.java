/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai-web
 * Author: author  wushyue@gmail.com
 * Create On: Apr 27, 2018 10:36:24 AM
 * Modify On: Apr 27, 2018 10:36:24 AM by wushyue@gmail.com
 */
package com.artqiyi.dahuashai.common.util;

import com.artqiyi.dahuashai.common.constant.GameConstants;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author wushuang
 */
public class DateUtil {


    public static final String MONTH_FORMAT_MID = "yyyy-MM";
    public static final String MONTH_FORMAT_SLASH = "yyyy/MM";
    public static final String MONTH_FORMAT = "yyyyMM";
    public static final String DAY_FORMAT = "yyyy-MM-dd";
    public static final String DAY_FORMAT_SLASH = "yyyy/MM/dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DATESEC_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATESEC_FORMAT_NO_DASH= "yyyyMMddHHmmss";
    public static final String HMS_FORMAT = "HH:mm:ss";
    public static final String HM_FORMAT = "HH:mm";
    public static final String CRON_FORMAT = "ss mm HH dd MM ? yyyy";


    /**
     * @param dateTimeStr
     * @param datePattern like yyyy-MM-dd HH:mm
     * @return
     */
    public static  DateTime convertToDateTime(String dateTimeStr, String datePattern) {
        DateTimeFormatter format = DateTimeFormat.forPattern(datePattern);
        DateTime dateTime = DateTime.parse(dateTimeStr, format);
        return dateTime;
    }

    /**
     * yyyy-MM转成date类型
     * @param dateStr
     * @param datePattern
     * @return
     * @throws Exception
     */
    public static Date parseMonth(String dateStr, String datePattern) throws Exception {
        if (dateStr == null || dateStr.length() <= 0)
            return null;
        return new SimpleDateFormat(datePattern).parse(dateStr);
    }

    /**
     * 将Date类型 格式化为yyyy-MM之类的字符串, 取决datePattern
     *
     * @param date
     * @param datePattern - 如yyyymm
     * @return String
     */
    public static String formatMonth(Date date, String datePattern) {
        if (date == null)
            return null;
        return new SimpleDateFormat(datePattern).format(date);
    }

    /**
     * yyyy-MM-dd转成date类型
     * @param dateStr
     * @return
     * @throws Exception
     */
    public static Date parseDate(String dateStr) throws Exception {
        if (dateStr == null || dateStr.length() <= 0)
            return null;
        return new SimpleDateFormat(DAY_FORMAT_SLASH).parse(dateStr);
    }

    /**
     * yyyy-MM-dd转成date类型
     * @param dateStr
     * @param pattern
     * @return
     * @throws Exception
     */
    public static Date parseDate(String dateStr, String pattern) throws Exception {
        if (dateStr == null || dateStr.length() <= 0) {
            throw new IllegalArgumentException("parseDate() exception");
        }
        return new SimpleDateFormat(pattern).parse(dateStr);
    }

    /**
     * date类型 格式化为yyyy-MM-dd
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static String formatDate(Date date, String format) {
        if (date == null)
            return null;
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 毫秒数 格式化为yyyy-MM-dd
     *
     * @param time
     * @return
     * @throws Exception
     */
    public static String formatDate(long time, String format) {
        Date date = new Date(time);
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * yyyy-MM-dd HH:mm 转成date类型
     *
     * @param timeStr
     * @return
     * @throws Exception
     */
    public static Date parseMinute(String timeStr) throws Exception {
        if (timeStr == null || timeStr.length() <= 0)
            return null;
        return new SimpleDateFormat(DATETIME_FORMAT).parse(timeStr);
    }

    /**
     * date类型 格式化为yyyy-MM-dd HH:mm
     * @param time
     * @return
     */
    public static String formatMinute(Date time) {
        if (time == null)
            return null;
        return new SimpleDateFormat(DATETIME_FORMAT).format(time);
    }

    /**
     * yyyy-MM-dd HH:mm:ss 转成date类型
     *
     * @param timeStr
     * @return
     * @throws Exception
     */
    public static Date parseSecond(String timeStr) throws Exception {
        if (timeStr == null || timeStr.length() <= 0)
            return null;
        return new SimpleDateFormat(DATESEC_FORMAT).parse(timeStr);
    }

    /**
     * date转 HH:mm:ss
     */
    public static DateTime parseHMS(Date time) {
        if (time == null)
            return null;
        DateTime date = new DateTime(time);
        String timeStr = date.toString(HMS_FORMAT);
        return DateTimeFormat.forPattern(HMS_FORMAT).parseDateTime(timeStr);
    }

    /**
     * HH:mm 转成date类型
     *
     * @param timeStr
     * @return
     * @throws Exception
     */
    public static Date parseTime(String timeStr) throws Exception {
        if (timeStr == null || timeStr.length() <= 0) {
            throw new IllegalArgumentException("parseTime() exception");
        }
        return new SimpleDateFormat(HM_FORMAT).parse(timeStr);
    }

    /**
     * date类型 格式化为yyyy-MM-dd HH:mm:ss
     * @param time
     * @return
     */
    public static String formatSecond(Date time) {
        if (time == null)
            return null;
        return new SimpleDateFormat(DATESEC_FORMAT).format(time);
    }

    /**
     * 比较时间是否交叉
     *
     * @param beginTime1
     * @param endTime1
     * @param beginTime2
     * @param endTime2
     * @return
     */
    public static boolean betweenTime(Date beginTime1, Date endTime1, Date beginTime2, Date endTime2) {
        if (beginTime1 == null || endTime1 == null || beginTime2 == null || endTime2 == null)
            return false;
        DateTime curBegin = parseHMS(beginTime1);
        DateTime curEnd = parseHMS(endTime1);
        if (curEnd.isBefore(curBegin)) {
            curBegin = curBegin.minusDays(1);
        }
        DateTime oldBegin = parseHMS(beginTime2);
        DateTime oldEnd = parseHMS(endTime2);
        if (oldEnd.isBefore(oldBegin)) {
            oldBegin = oldBegin.minusDays(1);
        }
        if (curEnd.isBefore(oldBegin) || curBegin.isAfter(oldEnd)) {
            return false;
        }

        return true;
    }

    /**
     * 比较日期是否交叉
     *
     * @param begin1 inclusive
     * @param end1   exclusive
     * @param begin2 inclusive
     * @param end2   exclusive
     * @return
     */
    public static boolean betweenDate(Date begin1, Date end1, Date begin2, Date end2) {
        if (begin1 == null || end1 == null || begin2 == null || end2 == null)
            return true;
        DateTime curBegin = new DateTime(begin1);
        DateTime curEnd = new DateTime(end1);
        if (!curEnd.isAfter(curBegin)) {
            return true;
        }
        DateTime oldBegin = new DateTime(begin2);
        DateTime oldEnd = new DateTime(end2);
        if (!curEnd.isAfter(oldBegin) || !curBegin.isBefore(oldEnd)) {
            return false;
        }
        return true;
    }

    public static String minDayOfMonth(DateTime dateTime, String dateTimePattern) {
        String formatedDateTime = dateTime.dayOfMonth().withMinimumValue().toString(dateTimePattern);
        return formatedDateTime;
    }

    public static String maxDayOfMonth(DateTime dateTime, String dateTimePattern) {
        String formatedDateTime = dateTime.dayOfMonth().withMaximumValue().toString(dateTimePattern);
        return formatedDateTime;
    }

    public static String currentMinDayOfMonth(String dateTimePattern) {
        DateTime now = DateTime.now();
        return minDayOfMonth(now, dateTimePattern);
    }

    public static String currentMaxDayOfMonth(String dateTimePattern) {
        DateTime now = DateTime.now();
        return maxDayOfMonth(now, dateTimePattern);
    }

    public static String currentMinDayOfMonth() {
        DateTime now = DateTime.now();
        return minDayOfMonth(now, DAY_FORMAT);
    }

    public static String currentMaxDayOfMonth() {
        DateTime now = DateTime.now();
        return maxDayOfMonth(now, DAY_FORMAT);
    }

    /**
     * 获取当年第一天日期
     * @return
     */
    public static Date getYearFirst() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    public static String getPreMonth() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        return DateUtil.formatMonth(c.getTime(), DateUtil.MONTH_FORMAT_MID);
    }

    /**
     * 取得一天的开始时间
     *
     * @param
     * @return Date
     * @throws
     */
    public static Date getCurrentStartTimeDaily() {
        DateTime dateTime = new DateTime();
        Date date = dateTime.withTimeAtStartOfDay().toDate();
        return date;
    }

    /**
     * 取得前N天的开始时间
     *
     * @param
     * @return Date
     * @throws
     */
    public static Date getPreNDayStartTime(Integer preDayNum) {
        DateTime dateTime = getPreNDay(preDayNum);
        Date date = dateTime.withTimeAtStartOfDay().toDate();
        return date;
    }
    

    /**
     * 取得一天的结束时间
     *
     * @param
     * @return Date
     * @throws
     */
    public static Date getCurrentEndTimeDaily() {
        DateTime dateTime = new DateTime();
        Date date = dateTime.millisOfDay().withMaximumValue().toDate();
        return date;
    }


    /**
     * 取得N天的结束时间
     *
     * @param
     * @return Date
     * @throws
     */
    public static Date getPreNDayEndTime(Integer preDayNum) {
        DateTime dateTime = getPreNDay(preDayNum);
        Date date = dateTime.millisOfDay().withMaximumValue().toDate();
        return date;
    }

    /**
     * 取当天的前n天的开始时间
     *
     * @param
     * @return Date
     * @throws
     */
    public static Date getPreDay(Integer preDayNum) {
        DateTime dateTime = new DateTime();
        //dateTime.minusDays(preDayNum);
        Date date = dateTime.minusDays(preDayNum).withTimeAtStartOfDay().toDate();
        return date;
    }

    public static DateTime getPreNDay(Integer preDayNum) {
        DateTime dateTime = new DateTime();
        //dateTime.minusDays(preDayNum);
        DateTime preDateTime = dateTime.minusDays(preDayNum).withTimeAtStartOfDay();
        return preDateTime;
    }

    /**
     * 将日期类型转换成指定格式的日期字符串
     *
     * @param date       待转换的日期
     * @param dateFormat 日期格式字符串
     * @return String
     */
    public static String convertDateToStr(Date date, String dateFormat) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    /**
     * 获取游戏结算时间
     * @param awardTime
     * @return
     */
    public static Date getEndTime(String awardTime){
        String[] split = awardTime.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        c.set(Calendar.HOUR_OF_DAY,Integer.valueOf(split[0]));
        c.set(Calendar.MINUTE,Integer.valueOf(split[1]));
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);
        //如果当前时间小于定时任务配置的时间,在当天结算
        if (hour < h || (hour == h && m - minute > GameConstants.THRESHOLD)) {
            return c.getTime();
        }

        //否则第二天结算
        c.add(Calendar.DAY_OF_MONTH,1);
        return c.getTime();
    }


    public static void main(String[] args) {
        System.out.println(formatDate(System.currentTimeMillis(),CRON_FORMAT));
    //    System.out.println(getThisWeekMonday(new DateTime().withMillisOfDay(0).toDate()));
//        System.out.println(formatDate(getYearFirst(),DAY_FORMAT));
//        // 当前月的第一天和最后一天
////        System.out.println( String.format("min:%s, max:%s", DateTime.now().dayOfMonth().withMinimumValue().toString("yyyy-MM-dd"),
////                        DateTime.now().dayOfMonth().withMaximumValue().toString("yyyy-MM-dd")));
//
//        System.out.println(formatDate(getCurrentStartTimeDaily(),DATESEC_FORMAT));
//        System.out.println(formatDate(getCurrentEndTimeDaily(),DATESEC_FORMAT));
//        System.out.println(formatDate(getPreDay(2),DATESEC_FORMAT));
//
//        String testDate = "20180517105021";
//        Date dt=null;
//        try {
//            dt= DateUtil.parseDate(testDate,DATESEC_FORMAT_NO_DASH);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(formatDate(getPreNDayStartTime(2),DATESEC_FORMAT));
//        System.out.println(formatDate(getPreNDayEndTime(2),DATESEC_FORMAT));
        System.out.println(DateUtil.formatDate(new Date(), DateUtil.DATESEC_FORMAT_NO_DASH));
    }


}
