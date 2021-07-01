package co.com.ceiba.domain.repository;

import java.util.List;

import co.com.ceiba.domain.entity.Car;

public interface ParkingLotCarRepository {


    Car getCar(String plate);
    void saveVehicle(Car car);
    int getQuantity();
    List<Car> getCars();



}
