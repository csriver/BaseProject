package com.base.pj.util;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.Arrays;
import java.util.List;

import lib.room.PJCache;
import lib.room.PJCacheDao;
import lib.room.PJCacheDatabase;
import lib.util.JLog;

/**
 * @ClassName: RoomUtil
 * @Date: 2021/6/11
 * @Author: CS
 * @Description:  数据库操作
 */
public class RoomUtil {
    /*数据库名称*/
    public static final String DATABASE_NAME = "pjcache_database";
    /*数据库实例*/
    private static PJCacheDao pjCacheDao;

    /*手机信息key*/
    public static final String key_phone = "key_phone";
    /*隐私协议key*/
    public static final String key_privacy = "key_privacy";

    /**
     * 初始化数据库
     * @param context
     */
    public static void init(Context context){
        if(pjCacheDao == null){
            PJCacheDatabase PJCacheDatabase = Room.databaseBuilder(context, PJCacheDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
            pjCacheDao = PJCacheDatabase.getPJCacheDao();
        }
    }

    /**
     * 获取所有数据
     * @return
     */
    public static LiveData<List<PJCache>> getAllPJCacheLive(){
        if(pjCacheDao == null){
            return null;
        }
        JLog.d("getAllPJCacheLive","getAllPJCacheLive");
        return pjCacheDao.getAllPJCache();
    }


    /**获取用户数据
     * @param key
     * @return
     */
    public static PJCache getPJCacheByKey(String key){
        if(pjCacheDao == null){
            return null;
        }
        JLog.d("getPJCacheByKey","keys="+ key);
        return pjCacheDao.getPJCacheByKey(key);
    }

    /**获取用户数据
     * @param keys
     * @return
     */
    public static List<PJCache> getPJCacheByKeys(String... keys){
        if(pjCacheDao == null){
            return null;
        }
        JLog.d("getPJCacheByKeys","keys="+ Arrays.toString(keys));
        return pjCacheDao.getPJCacheByKeys(keys);
    }

    /**
     * 插入或者更新
     * @param cache
     */
    public static void insertOrUpdatePJCache(PJCache cache){
        if(pjCacheDao == null){
            return;
        }
        PJCache pjCache = pjCacheDao.getPJCacheByKey(cache.getPjKey());
        if(pjCache == null){
            JLog.d("insertOrUpdatePJCache","insertPJCache");
            pjCacheDao.insertPJCache(cache);
        }else {
            JLog.d("insertOrUpdatePJCache","updatePJCache");
            pjCacheDao.updatePJCache(cache);
        }
    }

    /**
     * 删除
     * @param keys
     */
    public static void deletePJCacheByKeys(String... keys){
        if(pjCacheDao == null){
            return;
        }
        JLog.d("deletePJCacheByKeys","keys="+ Arrays.toString(keys));
        pjCacheDao.deletePJCacheByKeys(keys);
    }

    /**
     * 删除
     * @param caches
     */
    public static void deletePJCache(PJCache... caches){
        if(pjCacheDao == null){
            return;
        }
        JLog.d("deletePJCache","caches="+ Arrays.toString(caches));
        pjCacheDao.deletePJCache(caches);
    }

    /**
     * 清空数据库
     */
    public static void clearPJCache(){
        if(pjCacheDao == null){
            return;
        }
        JLog.d("clearPJCache","clearPJCache");
        pjCacheDao.deleteAllPJCache();
    }
}
