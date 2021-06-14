package lib.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @ClassName: PersonDao
 * @Date: 2021/6/11
 * @Author: CS
 * @Description:
 */
@Dao
public interface PersonDao {
    @Insert
    void insertPerson(Person... persons);

    @Update
    void updatePerson(Person... persons);

    @Delete
    void deletePerson(Person... persons);

    @Query("UPDATE Person SET personValue = :value WHERE personKey = :key")
    void updatePersonByKey(String value,String key);

    @Query("DELETE FROM Person WHERE personKey IN (:keys)")
    void deletePerson(String... keys);

    @Query("DELETE FROM Person")
    void deleteAllPerson();

    @Query("SELECT * FROM Person WHERE id LIKE :id")
    Person getPerson(int id);

    @Query("SELECT * FROM Person WHERE id IN (:ids)")
    LiveData<List<Person>> getPersons(int... ids);

    @Query("SELECT * FROM Person WHERE personKey LIKE :key")
    Person getPerson(String key);

    @Query("SELECT * FROM Person WHERE personKey IN (:keys)")
    LiveData<List<Person>> getPersons(String... keys);

    @Query("SELECT * FROM Person ORDER BY ID ASC")
    LiveData<List<Person>> getAllPerson();
}
