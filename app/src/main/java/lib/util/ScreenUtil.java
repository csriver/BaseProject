package lib.util;

import android.content.Context;

/**
 * @ClassName: ScreenUtil
 * @Date: 2021/6/16
 * @Author: CS
 * @Description: 屏幕相关
 */
public class ScreenUtil {

    /**
     * @param context
     * @return 获取屏幕高度像素
     */
    public static final int getHeightInPx(Context context)
    {
        final int height = context.getResources().getDisplayMetrics().heightPixels;
        return height;
    }

    /**
     * @param context
     * @return 获取屏幕宽度像素
     */
    public static final int getWidthInPx(Context context)
    {
        final int width = context.getResources().getDisplayMetrics().widthPixels;
        return width;
    }

    /**
     * @param context
     * @return 获取屏幕高度dp
     */
    public static final int getHeightInDp(Context context)
    {
        final float height = context.getResources().getDisplayMetrics().heightPixels;
        int heightInDp = px2dip(context, height);
        return heightInDp;
    }

    /**
     * @param context
     * @return 获取屏幕宽度dp
     */
    public static final int getWidthInDp(Context context)
    {
        final float width = context.getResources().getDisplayMetrics().widthPixels;
        int widthInDp = px2dip(context, width);
        return widthInDp;
    }

    /**
     * @param context
     * @param dpValue
     * @return dp转px
     */
    public static int dip2px(Context context, float dpValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * @param context
     * @param dpValue
     * @return dp转px
     */
    public static int dp2px(Context context, float dpValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    /**
     * @param context
     * @param pxValue
     * @return px转dp
     */
    public static int px2dip(Context context, float pxValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * @param context
     * @param pxValue
     * @return px转dp
     */
    public static int px2dp(Context context, float pxValue)
    {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
