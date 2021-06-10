package com.base.pj;

import android.app.Application;

import lib.util.JLog;

/**
 * Created by jcs on 2021/5/30.
 * Describe
 */
public class MyApplication extends Application {
    private MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initConfig();
    }

    /**
     * 初始化配置
     */
    private void initConfig() {
        JLog.isDebug = true;
    }

    public MyApplication getInstance() {
        return instance;
    }
}
