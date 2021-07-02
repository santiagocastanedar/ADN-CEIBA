package co.com.ceiba.domain.repository;

import java.util.List;

import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;


public interface ParkingLotMotorcycleRepository {

    Motorcycle motorcycleExist(String plate);
    void saveMotorcycle(Motorcycle motorcycle);
    //int getQuantity();
    List<Motorcycle> getMotorcycle();
}
