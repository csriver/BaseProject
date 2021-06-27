package lib.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lib.util.FormatUtil;

/**
 * @ClassName: PJCache
 * @Date: 2021/6/11
 * @Author: CS
 * @Description: APP个人缓存数据，以key/value形式保存，key为主键，value为JSON格式内容
 */
@Entity
public class PJCache {

    //数据存储主键
    @NonNull
    @PrimaryKey
    private String pjKey;

    //数据存储时间(更新时间)
    @ColumnInfo(name = "pjTime")
    private String pjTime;

    //数据存储内容
    @ColumnInfo(name = "pjValue")
    private String pjValue;

    public PJCache(String pjKey, String pjValue){
        this.pjKey=pjKey;
        this.pjValue=pjValue;
        this.pjTime= FormatUtil.dateTime();
    }

    public String getPjTime() {
        return pjTime;
    }

    public void setPjTime(String pjTime) {
        this.pjTime = pjTime;
    }

    public String getPjKey() {
        return pjKey;
    }

    public void setPjKey(String pjKey) {
        this.pjKey = pjKey;
    }

    public String getPjValue() {
        return pjValue;
    }

    public void setPjValue(String pjValue) {
        this.pjValue = pjValue;
    }
}
