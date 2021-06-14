package lib.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @ClassName: PersonDatabase
 * @Date: 2021/6/11
 * @Author: CS
 * @Description:
 */
@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class PersonDatabase extends RoomDatabase {
    public abstract PersonDao getUserDataDao();
}
