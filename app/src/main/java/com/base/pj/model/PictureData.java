package com.base.pj.model;

/**
 * @ClassName: PictureData
 * @Date: 2021/6/16
 * @Author: CS
 * @Description: 图片
 */
public class PictureData extends BaseModel{
    public int code;
    public String imgurl;
    public int width;
    public int height;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
