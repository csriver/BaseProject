package com.base.pj.model;

/**
 * @ClassName: DeviceInfo
 * @Date: 2021/6/4
 * @Author: CS
 * @Description:设备信息
 */
public class DeviceInfo extends BaseModel{
    private String androidId;
    //String androidId = Settings.System.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }
}
