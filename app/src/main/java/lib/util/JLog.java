package lib.util;

import android.util.Log;

/**
 * Created by jcs on 2019/7/2.
 * Describe
 */
public class JLog {
    private static final String TAG = "JLog";
    public static boolean isDebug = false;

    public static void e(String c, String info) {
        loge(TAG, c + "->" + info);
    }

    public static void w(String c, String info) {
        logw(TAG, c + "->" + info);
    }

    public static void d(String c, String info) {
        logd(TAG, c + "->" + info);
    }

    public static void i(String c, String info) {
        logi(TAG, c + "->" + info);
    }

    public static void loge(String tag, String msg) {  //信息太长,分段打印
        if (!isDebug) {
            return;
        }
        //因为String的length是字符数量不是字节数量所以为了防止中文字符过多，
        //  把4*1024的MAX字节打印长度改为2001字符数
        int max_str_length = 2001 - tag.length();
        //大于4000时
        while (msg.length() > max_str_length) {
            Log.e(tag, msg.substring(0, max_str_length));
            msg = msg.substring(max_str_length);
        }
        //剩余部分
        Log.e(tag, msg);
    }

    public static void logw(String tag, String msg) {  //信息太长,分段打印
        if (!isDebug) {
            return;
        }
        //因为String的length是字符数量不是字节数量所以为了防止中文字符过多，
        //  把4*1024的MAX字节打印长度改为2001字符数
        int max_str_length = 2001 - tag.length();
        //大于4000时
        while (msg.length() > max_str_length) {
            Log.w(tag, msg.substring(0, max_str_length));
            msg = msg.substring(max_str_length);
        }
        //剩余部分
        Log.w(tag, msg);
    }

    public static void logd(String tag, String msg) {  //信息太长,分段打印
        if (!isDebug) {
            return;
        }
        //因为String的length是字符数量不是字节数量所以为了防止中文字符过多，
        //  把4*1024的MAX字节打印长度改为2001字符数
        int max_str_length = 2001 - tag.length();
        //大于4000时
        while (msg.length() > max_str_length) {
            Log.d(tag, msg.substring(0, max_str_length));
            msg = msg.substring(max_str_length);
        }
        //剩余部分
        Log.d(tag, msg);
    }

    public static void logi(String tag, String msg) {  //信息太长,分段打印
        if (!isDebug) {
            return;
        }
        //因为String的length是字符数量不是字节数量所以为了防止中文字符过多，
        //  把4*1024的MAX字节打印长度改为2001字符数
        int max_str_length = 2001 - tag.length();
        //大于4000时
        while (msg.length() > max_str_length) {
            Log.i(tag, msg.substring(0, max_str_length));
            msg = msg.substring(max_str_length);
        }
        //剩余部分
        Log.i(tag, msg);
    }

}
