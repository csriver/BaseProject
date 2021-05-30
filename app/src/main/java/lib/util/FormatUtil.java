package lib.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Describe
 */
public class FormatUtil {


    /*年-月-日 时:分:秒*/
    public static String dateTime() {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format1.format(new Date());
    }

    /*年-月-日*/
    public static String dateDay() {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(new Date());
    }

}
