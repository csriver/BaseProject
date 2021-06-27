package com.base.pj;

import android.app.Application;

import com.base.pj.util.RoomUtil;

import lib.net.RetrofitHelp;
import lib.util.JLog;

/**
 * Created by jcs on 2021/5/30.
 * Describe
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initConfig();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    /**
     * 初始化APP配置
     */
    private void initConfig() {
        JLog.isDebug = true;
        RetrofitHelp.isDebug=true;
        RoomUtil.init(instance);
    }


    /**
     * 初始化三方SDK
     */
    public void initSDK(){

    }


}
