package co.com.ceiba.dataaccess.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import co.com.ceiba.dataaccess.entity.VehicleRoom;


@Dao
public interface VehicleDao {
    @Query("SELECT * FROM vehicles WHERE plate IN (:plate)")
    VehicleRoom getVehicle(String plate);

    @Query("SELECT COUNT(*) FROM vehicles WHERE vehicleType IN (:id)")
    int getVehicleQuantity(int id);

    @Insert
    void insertVehicle(VehicleRoom vehicleRoom);

    @Update
    public void updateDepartureDate(VehicleRoom vehicleRoom);
}
