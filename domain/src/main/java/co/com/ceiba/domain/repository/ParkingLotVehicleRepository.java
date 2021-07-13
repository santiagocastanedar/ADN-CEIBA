package co.com.ceiba.domain.repository;

import java.util.List;
import co.com.ceiba.domain.entity.Vehicle;
import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;

@EntryPoint
@InstallIn(ActivityRetainedComponent.class)
public interface ParkingLotVehicleRepository {
    Vehicle saveVehicle(Vehicle vehicle);
    Vehicle VehicleExist(String plate);
    int getQuantity();
    List<Vehicle> getVehicles();
}
