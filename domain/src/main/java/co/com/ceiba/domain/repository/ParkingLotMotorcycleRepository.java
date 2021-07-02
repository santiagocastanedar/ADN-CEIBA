package co.com.ceiba.domain.repository;

import java.util.List;

import co.com.ceiba.domain.entity.Motorcycle;


public interface ParkingLotMotorcycleRepository {

    Motorcycle motorcycleExist(String plate);
    void saveMotorcycle(Motorcycle motorcycle);
    //int getQuantity();
    List<Motorcycle> getMotorcycle();
}
