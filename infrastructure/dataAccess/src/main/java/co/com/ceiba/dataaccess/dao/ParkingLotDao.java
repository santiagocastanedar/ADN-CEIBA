package co.com.ceiba.dataaccess.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.com.ceiba.dataaccess.entity.ParkingLotRoom;

@Dao
public interface ParkingLotDao {
    @Query("SELECT * FROM parkingLots WHERE id IN (:id)")
    ParkingLotRoom getParkingLotById(int id);


    @Insert
    void insertParkingLot(ParkingLotRoom parkingLotRoom);
}
