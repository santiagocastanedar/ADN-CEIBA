package co.com.ceiba.domain.repository;

import co.com.ceiba.domain.entity.Vehicle;

public interface ParkingLotRepository {


    Vehicle vehicleExist(String plate);
    void saveVehicle(Vehicle vehicle);
    //int getQuantityofVehicles(Vehicle vehicle);
    //Vehicle getVehicle(String plate);



}
