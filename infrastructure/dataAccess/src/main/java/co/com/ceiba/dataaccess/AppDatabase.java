package co.com.ceiba.dataaccess;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import co.com.ceiba.dataaccess.dao.CarDao;
import co.com.ceiba.dataaccess.dao.MotorcycleDao;
import co.com.ceiba.dataaccess.entity.CarRoom;
import co.com.ceiba.dataaccess.entity.MotorcycleRoom;

@Database(entities = {CarRoom.class, MotorcycleRoom.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MotorcycleDao motorcycleDao();
    public abstract CarDao carDao();

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
