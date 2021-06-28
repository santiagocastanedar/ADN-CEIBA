package co.com.ceiba.dataaccess.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import co.com.ceiba.dataaccess.entity.VehicleTypeRoom;


@Dao
public interface VehicleTypeDao {

    @Query("SELECT * FROM vehicles_type WHERE id IN (:id)")
    VehicleTypeRoom getVehicleType(int id);


    @Insert
    void insertVehicleType(VehicleTypeRoom vehicleTypeRoom);
}
