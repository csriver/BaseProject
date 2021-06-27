package lib.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @ClassName: PJCacheDatabase
 * @Date: 2021/6/11
 * @Author: CS
 * @Description:
 */
@Database(entities = {PJCache.class}, version = 2, exportSchema = false)
public abstract class PJCacheDatabase extends RoomDatabase {
    public abstract PJCacheDao getPJCacheDao();
}
