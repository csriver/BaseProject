package com.base.pj.model;

/**
 * @ClassName: PrivacyInfo
 * @Date: 2021/6/17
 * @Author: CS
 * @Description:
 */
public class PrivacyInfo extends BaseModel{
    //隐私协议是否已同意
    private boolean isAgreed;
    public PrivacyInfo(boolean isAgreed){
        this.isAgreed=isAgreed;
    }

    public boolean isAgreed() {
        return isAgreed;
    }

    public void setAgreed(boolean agreed) {
        isAgreed = agreed;
    }
}
