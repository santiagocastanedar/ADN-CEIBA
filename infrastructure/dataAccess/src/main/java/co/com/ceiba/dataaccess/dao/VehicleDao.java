package co.com.ceiba.dataaccess.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import co.com.ceiba.dataaccess.entity.VehicleRoom;


@Dao
public interface VehicleDao {
    @Query("SELECT * FROM vehicles WHERE plate IN (:plate)")
    VehicleRoom getVehicle(String plate);

    @Insert
    void insertVehicle(VehicleRoom vehicleRoom);
}
