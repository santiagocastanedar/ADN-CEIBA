package co.com.ceiba.domain.service;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.exception.VehicleAlreadyExistsException;
import co.com.ceiba.domain.repository.ParkingLotCarRepository;

public class ParkingLotCarService {

    private final ParkingLotCarRepository parkingLotCarRepository;
    @Inject
    public ParkingLotCarService(ParkingLotCarRepository parkingLotCarRepository){
        this.parkingLotCarRepository = parkingLotCarRepository;
    }

    public void saveVehicle(Car car){
        if(parkingLotCarRepository.getCar(car.getPlate()) != null){
            throw new VehicleAlreadyExistsException();
        }
        parkingLotCarRepository.saveVehicle(car);
    }

    public List<Car> getCars(){
        return parkingLotCarRepository.getCars();
    }

}
