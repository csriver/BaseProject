package com.base.pj.model;

/**
 * @ClassName: UserInfo
 * @Date: 2021/6/4
 * @Author: CS
 * @Description:用户信息
 */
public class UserInfo extends BaseModel{
    private String name;
    private String phone;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
