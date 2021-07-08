package co.com.ceiba.dataaccess.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.com.ceiba.dataaccess.entity.CarRoom;

@Dao
public interface CarDao {
    @Query("SELECT * FROM cars WHERE plate IN (:plate) AND departureDate IS NULL")
    CarRoom getCarRoom(String plate);

    @Query("SELECT COUNT(*) FROM cars")
    int getCarQuantity();

    @Query("SELECT * FROM cars WHERE departureDate IS NULL ORDER BY entryDate")
    List<CarRoom> getCars();

    @Insert
    void insertCar(CarRoom carRoom);
}
