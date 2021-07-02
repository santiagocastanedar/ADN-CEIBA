package co.com.ceiba.domain.repository;

import java.util.List;

import co.com.ceiba.domain.entity.Car;
import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;


public interface ParkingLotCarRepository {

    void saveVehicle(Car car);
    Car getCar(String plate);

    //int getQuantity();
    List<Car> getCars();



}
