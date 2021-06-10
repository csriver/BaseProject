package com.base.pj.util;


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
    private static final String PACKAGE_NAME="com.base.pj";
    /**
     * @return 获取设备信息
     */
    public static DeviceInfo getDeviceInfo(){
        byte[] data = FileUtil.getStringFromApp(PACKAGE_NAME,"deviceInfo.txt");
        if(data==null){
            return null;
        }
        Gson gson = new Gson();
        return gson.fromJson(Arrays.toString(data),DeviceInfo.class);
    }

    /**
     * @param deviceInfo 保存设备信息
     */
    public static void saveDeviceInfo(DeviceInfo deviceInfo){
        if(deviceInfo==null){
            return;
        }
        Gson gson = new Gson();
        FileUtil.saveStringToApp(PACKAGE_NAME,"deviceInfo.txt",gson.toJson(deviceInfo),true);
    }

    /**
     * @return 获取用户信息
     */
    public static UserInfo getUserInfo(){
        byte[] data = FileUtil.getStringFromApp(PACKAGE_NAME,"userInfo.txt");
        if(data==null){
            return null;
        }
        Gson gson = new Gson();
        return gson.fromJson(Arrays.toString(data), UserInfo.class);
    }

    /**
     * @param userInfo 保存用户信息
     */
    public static void saveUserInfo(UserInfo userInfo){
        if(userInfo==null){
            return;
        }
        Gson gson = new Gson();
        FileUtil.saveStringToApp(PACKAGE_NAME,"userInfo.txt",gson.toJson(userInfo),true);
    }
}
