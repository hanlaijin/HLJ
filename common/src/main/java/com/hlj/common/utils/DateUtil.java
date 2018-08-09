package com.hlj.common.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hanlaijin@xiaomi.com
 * @since 17-7-25
 */
public class DateUtil {

    public static String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date strToDate(String format, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(format);
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToStr(String format, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(format);
        return simpleDateFormat.format(date);
    }

    public static int getDateDiff(Date start, Date end) {
        long minutes = (end.getTime() - start.getTime()) / (1000 * 60);
        return Integer.parseInt(String.valueOf(minutes));
    }

    public static Date getDiffDateTime(Date date, int diff) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, diff);
        return calendar.getTime();
    }

    public static Date getDiffSecondTime(Date date, int diff) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, diff);
        return calendar.getTime();
    }

    public static Date getDateByMonthDiff(Date date, int diff){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, diff);
        return calendar.getTime();
    }

    public static Date getTodayZero() {
        Calendar today = Calendar.getInstance();
        today.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE), 0, 0, 0);
        Date date = new Date();
        date.setTime(today.getTimeInMillis() / 1000 * 1000);
        return date;
    }

    public static Date getFirstDayOfTheMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}
