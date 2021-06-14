package lib.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @ClassName: Person
 * @Date: 2021/6/11
 * @Author: CS
 * @Description:APP个人缓存数据
 */
@Entity
public class Person {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "personKey")
    private String personKey;

    @ColumnInfo(name = "personValue")
    private String personValue;

    public Person(String personKey,String personValue){
        this.personKey=personKey;
        this.personValue=personValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonKey() {
        return personKey;
    }

    public void setPersonKey(String personKey) {
        this.personKey = personKey;
    }

    public String getPersonValue() {
        return personValue;
    }

    public void setPersonValue(String personValue) {
        this.personValue = personValue;
    }
}
