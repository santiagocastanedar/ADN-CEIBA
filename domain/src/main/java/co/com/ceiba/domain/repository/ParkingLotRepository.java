package co.com.ceiba.domain.repository;

import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.entity.VehicleType;

public interface ParkingLotRepository {
    boolean parkingLotExist(int id);
    boolean saveParkingLot(ParkingLot parkingLot);

    boolean vehicleExist(String plate);
    boolean saveVehicle(Vehicle vehicle);
    int getQuantityofVehicles(VehicleType vehicleType);
    Vehicle getVehicle(String plate);



}
