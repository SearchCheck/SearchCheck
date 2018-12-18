package com.gxl.searchcheck.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * author:Tomze
 * date:2018/12/18 14:18
 * description:日期转换工具类
 */
public class DateUtils {
    public static final SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat FORMAT_DATE_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 根据格式格式化日期
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, SimpleDateFormat format) {
        return format.format(date);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return 2018-12-18
     */
    public static String formatDate(Date date) {
        return FORMAT_DATE.format(date);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return 2018-12-18 14:21:23
     */
    public static String formatDateTime(Date date) {
        return FORMAT_DATE_TIME.format(date);
    }

    /**
     * 将时间戳解析成日期
     *
     * @param timeInMillis
     * @return 2018-12-18
     */
    public static String parseDate(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        Date date = calendar.getTime();
        return formatDate(date);
    }

    /**
     * 将时间戳解析成日期
     *
     * @param timeInMillis
     * @return 2018-12-18 14:21:23
     */
    public static String parseDateTime(long timeInMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        Date date = calendar.getTime();
        return formatDateTime(date);
    }

    /**
     * 解析日期
     *
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
        Date mDate = null;
        try {
            mDate = FORMAT_DATE.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mDate;
    }

    /**
     * 解析日期
     *
     * @param datetime
     * @return
     */
    public static Date parseDateTime(String datetime) {
        Date mDate = null;
        try {
            mDate = FORMAT_DATE_TIME.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mDate;
    }
}
