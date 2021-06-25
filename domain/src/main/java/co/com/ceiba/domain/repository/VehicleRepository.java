package co.com.ceiba.domain.repository;

import co.com.ceiba.domain.aggregate.Vehicle;

public interface VehicleRepository {

    boolean vehicleExist(String plate);

    void parkCar(Vehicle vehicle);

    double getOutParking(Vehicle vehicle);
}
