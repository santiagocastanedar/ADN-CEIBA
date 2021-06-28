package co.com.ceiba.dataaccess;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import co.com.ceiba.dataaccess.dao.ParkingLotDao;
import co.com.ceiba.dataaccess.entity.ParkingLotRoom;

@Database(entities = {ParkingLotRoom.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ParkingLotDao parkingLotDao();


}
