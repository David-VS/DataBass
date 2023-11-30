package be.ehb.databass.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {Fish.class})
public abstract class FishDataBass extends RoomDatabase {

    private static FishDataBass INSTANCE;

    public static FishDataBass getInstance(Context context){
        if(INSTANCE == null){
            //maak database verbinding
            INSTANCE = Room.databaseBuilder(context, FishDataBass.class, "fish.sqlite").build();
        }
        return INSTANCE;
    }

    public abstract FishDAO getFishDAO();
}
