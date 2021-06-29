package co.com.ceiba.dataaccess;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import co.com.ceiba.dataaccess.dao.ParkingLotDao;
import co.com.ceiba.dataaccess.dao.VehicleDao;
import co.com.ceiba.dataaccess.dao.VehicleTypeDao;
import co.com.ceiba.dataaccess.entity.ParkingLotRoom;
import co.com.ceiba.dataaccess.entity.VehicleRoom;
import co.com.ceiba.dataaccess.entity.VehicleTypeRoom;

@Database(entities = {ParkingLotRoom.class, VehicleRoom.class, VehicleTypeRoom.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ParkingLotDao parkingLotDao();
    public abstract VehicleDao vehicleDao();
    public abstract VehicleTypeDao vehicleTypeDao();

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
