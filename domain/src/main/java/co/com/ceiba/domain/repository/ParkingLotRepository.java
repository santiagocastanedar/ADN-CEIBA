package co.com.ceiba.domain.repository;

import co.com.ceiba.domain.aggregate.Vehicle;
import co.com.ceiba.domain.entity.ParkingLot;
import co.com.ceiba.domain.entity.VehicleType;

public interface ParkingLotRepository {
    double calculatePayment(Vehicle vehicle);
    boolean allowEntry(Vehicle vehicle);
    int getQuantityofVehicles(VehicleType vehicleType);
    boolean vehicleExist(String plate);
}
