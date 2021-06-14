package com.base.pj.util;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

import lib.room.Person;
import lib.room.PersonDao;
import lib.room.PersonDatabase;
import lib.util.JLog;

/**
 * @ClassName: RoomUtil
 * @Date: 2021/6/11
 * @Author: CS
 * @Description:  数据库操作
 */
public class RoomUtil {
    /*手机信息*/
    public static final String key_phone = "key_phone";

    private static PersonDao personDao;

    public static void init(Context context){
        if(personDao == null){
            PersonDatabase personDatabase = Room.databaseBuilder(context, PersonDatabase.class, "person_database").allowMainThreadQueries().build();
            personDao = personDatabase.getUserDataDao();
        }
    }

    /**
     * 获取所有数据
     * @return
     */
    public static LiveData<List<Person>> getAllPersonLive(){
        if(personDao == null){
            return null;
        }
        return personDao.getAllPerson();
    }

    /**
     * 获取用户数据
     * @return
     */
    public static Person getPersonLive(String key){
        if(personDao == null){
            return null;
        }
        return personDao.getPerson(key);
    }

    /**
     * 插入或者更新
     * @param person
     */
    public static void insertOrUpdatePerson(Person person){
        if(personDao == null){
            return;
        }
        Person persons = personDao.getPerson(person.getPersonKey());
        JLog.d("insertOrUpdatePerson","persons="+persons);
        if(persons == null){
            personDao.insertPerson(person);
        }else {
            personDao.updatePersonByKey(person.getPersonValue(),person.getPersonKey());
        }
    }

    /**
     * 删除
     * @param key
     */
    public static void deletePerson(String key){
        if(personDao == null){
            return;
        }
        personDao.deletePerson(key);
    }
}
