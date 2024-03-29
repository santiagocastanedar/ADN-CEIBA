package co.com.ceiba.dataaccess.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.com.ceiba.dataaccess.entity.MotorcycleRoom;

@Dao
public interface MotorcycleDao {
    @Query("SELECT * FROM motorcycles WHERE plate IN (:plate) AND departureDate IS NULL")
    MotorcycleRoom getMotorcycle(String plate);

    @Query("SELECT * FROM motorcycles WHERE departureDate IS NULL ORDER BY entryDate")
    List<MotorcycleRoom> getMotorcycles();

    @Query("SELECT COUNT(*) FROM motorcycles ")
    int getMotorcycleQuantity();

    @Insert
    void insertVehicle(MotorcycleRoom motorcycleRoom);
}
