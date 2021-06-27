package com.base.pj.util;


import android.text.TextUtils;

import com.base.pj.model.UserInfo;
import com.base.pj.model.DeviceInfo;
import com.google.gson.Gson;

import java.util.Arrays;

import lib.util.FileUtil;

/**
 * @ClassName: JSONUtil
 * @Date: 2021/6/4
 * @Author: CS
 * @Description:
 */
public class JSONUtil {

    /**
     * @return 获取设备信息
     */
    public static DeviceInfo getDeviceInfoFile(){
        String data = FileUtil.getStringFromApp("deviceInfo.txt");
        if(TextUtils.isEmpty(data)){
            return null;
        }
        Gson gson = new Gson();
        return gson.fromJson(data,DeviceInfo.class);
    }

    /**
     * @param deviceInfo 保存设备信息
     */
    public static void saveDeviceInfoFile(DeviceInfo deviceInfo){
        if(deviceInfo==null){
            return;
        }
        Gson gson = new Gson();
        FileUtil.saveStringToApp("deviceInfo.txt",gson.toJson(deviceInfo),true);
    }

    /**
     * @return 获取用户信息
     */
    public static UserInfo getUserInfo(){
        String data = FileUtil.getStringFromApp("userInfo.txt");
        if(TextUtils.isEmpty(data)){
            return null;
        }
        Gson gson = new Gson();
        return gson.fromJson(data, UserInfo.class);
    }

    /**
     * @param userInfo 保存用户信息
     */
    public static void saveUserInfo(UserInfo userInfo){
        if(userInfo==null){
            return;
        }
        Gson gson = new Gson();
        FileUtil.saveStringToApp("userInfo.txt",gson.toJson(userInfo),true);
    }
}
