package co.com.ceiba.dataaccess;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import co.com.ceiba.dataaccess.dao.VehicleDao;
import co.com.ceiba.dataaccess.entity.VehicleRoom;

@Database(entities = {VehicleRoom.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VehicleDao vehicleDao();

    public static volatile AppDatabase INSTANCE;

    public static AppDatabase getDataBase(Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context,
                            AppDatabase.class, "parkingDatabase").build();
                }
            }
        }
        return INSTANCE;
    }

}
