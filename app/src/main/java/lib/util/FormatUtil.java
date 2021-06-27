package lib.util;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Describe
 */
public class FormatUtil {


    /*年-月-日 时:分:秒*/
    @SuppressLint("SimpleDateFormat")
    public static String dateTime() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(new Date());
    }

    /*年-月-日*/
    @SuppressLint("SimpleDateFormat")
    public static String dateDay() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }

    /**
     * @param time 精确到秒
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Date getDateTime(String time){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param date 精确到日
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static Date getDateDate(String date){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
