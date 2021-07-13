package co.com.ceiba.domain.repository;

import java.util.List;
import co.com.ceiba.domain.entity.Vehicle;


public interface ParkingLotVehicleRepository {
    Vehicle saveVehicle(Vehicle vehicle);
    Vehicle vehicleExist(String plate);
    int getQuantity();
    List<Vehicle> getVehicles();
}
