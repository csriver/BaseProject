package lib.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * 保存数据至preference
 * @function
 * @version   1.0,
 */
public class SPUtil
{
    /**
     * 存入文件中的工程名
     */
    public static final String PREFERENCES_NAME = "";

    /**
     * 保存至preferences中
     *
     * @param key
     * @return
     */
    public static void setString(Context context, String key, String value)
    {
        if (context == null)
        {
            return;
        }
        if(TextUtils.isEmpty(key)){
            return;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 从preferences中获取
     *
     * @param key
     * @param defValue
     */
    public static String getString(Context context, String key, String defValue)
    {
        if (context == null)
        {
            return defValue;
        }
        if(TextUtils.isEmpty(key)){
            return defValue;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    /**
     * 保存至preferences中
     *
     * @param key
     * @return
     */
    public static void setInt(Context context, String key, int value)
    {
        if (context == null)
        {
            return;
        }
        if(TextUtils.isEmpty(key)){
            return;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * 从preferences中获取
     *
     * @param key
     * @param defValue
     */
    public static int getInt(Context context, String key, int defValue)
    {
        if (context == null)
        {
            return defValue;
        }
        if(TextUtils.isEmpty(key)){
            return defValue;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    /**
     * 删除preferences中的字串数据
     *
     * @param key
     * @return
     */
    public static void delString(Context context, String key)
    {
        if (context == null)
        {
            return;
        }
        if(TextUtils.isEmpty(key)){
            return;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 保存至preferences中
     *
     * @param key
     * @return
     */
    public static void setLong(Context context, String key, Long value)
    {
        if (context == null)
        {
            return;
        }
        if(TextUtils.isEmpty(key)){
            return;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * 从preferences中获取
     *
     * @param key
     * @param def
     */
    public static Long getLong(Context context, String key, long def)
    {
        if (context == null)
        {
            return def;
        }
        if(TextUtils.isEmpty(key)){
            return def;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sp.getLong(key, def);
    }


    /**
     * 保存至preferences中
     *
     * @param key
     * @return
     */
    public static void setFloat(Context context, String key, float value)
    {
        if (context == null)
        {
            return;
        }
        if(TextUtils.isEmpty(key)){
            return;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * 从preferences中获取
     *
     * @param key
     * @param def
     */
    public static float getFloat(Context context, String key, float def)
    {
        if (context == null)
        {
            return def;
        }
        if(TextUtils.isEmpty(key)){
            return def;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sp.getFloat(key, def);
    }

    public static void setBoolean(Context context, String key, boolean value)
    {
        if (context == null)
        {
            return;
        }
        if(TextUtils.isEmpty(key)){
            return;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue)
    {
        if (context == null)
        {
            return defaultValue;
        }
        if(TextUtils.isEmpty(key)){
            return defaultValue;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultValue);
    }
}
