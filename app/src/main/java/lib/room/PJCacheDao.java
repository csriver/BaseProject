package lib.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @ClassName: PJCacheDao
 * @Date: 2021/6/11
 * @Author: CS
 * @Description:
 */
@Dao
public interface PJCacheDao {
    @Insert
    void insertPJCache(PJCache... PJCaches);

    @Update
    void updatePJCache(PJCache... PJCaches);

    @Delete
    void deletePJCache(PJCache... PJCaches);

    @Query("UPDATE PJCache SET pjTime = :time AND pjValue = :value WHERE pjKey = :key")
    void updatePJCacheByKey(String time,String value,String key);

    @Query("DELETE FROM PJCache WHERE pjKey IN (:keys)")
    void deletePJCacheByKeys(String... keys);

    @Query("DELETE FROM PJCache")
    void deleteAllPJCache();

    @Query("SELECT * FROM PJCache WHERE pjKey LIKE :key")
    PJCache getPJCacheByKey(String key);

    @Query("SELECT * FROM PJCache WHERE pjKey IN (:keys)")
    List<PJCache> getPJCacheByKeys(String... keys);

    @Query("SELECT * FROM PJCache")
    LiveData<List<PJCache>> getAllPJCache();
}
