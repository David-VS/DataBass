package be.ehb.databass.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FishDAO {

    @Insert
    void insertFish(Fish f);

    @Query("SELECT * FROM Fish ORDER BY naam")
    LiveData<List<Fish>> getAllFish();

    @Query("SELECT * FROM Fish WHERE kleur LIKE :color")
    LiveData<List<Fish>> getFishByColor(String color);

    @Update
    void updateFish(Fish f);

    @Delete
    void deleteFish(Fish f);
}
