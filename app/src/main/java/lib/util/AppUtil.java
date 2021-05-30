package lib.util;

import android.app.Application;
import android.content.pm.ApplicationInfo;

/**
 * Describe
 */
public class AppUtil {



    /**
     * 判断当前应用是否是debug状态
     */
    public static boolean isApkInDebug(Application app) {
        try {
            ApplicationInfo info = app.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}
