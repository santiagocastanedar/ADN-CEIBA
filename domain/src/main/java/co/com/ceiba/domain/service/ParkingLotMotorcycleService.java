package co.com.ceiba.domain.service;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.exception.VehicleAlreadyExistsException;
import co.com.ceiba.domain.repository.ParkingLotMotorcycleRepository;

public class ParkingLotMotorcycleService {

    private final ParkingLotMotorcycleRepository motorcycleRepository;

    @Inject
    public ParkingLotMotorcycleService(ParkingLotMotorcycleRepository parkingLotMotorcycleRepository){
        this.motorcycleRepository = parkingLotMotorcycleRepository;
    }

    public void saveMotorcycle(Motorcycle motorcycle){
        if(motorcycleRepository.motorcycleExist(motorcycle.getPlate()) != null){
            throw new VehicleAlreadyExistsException();
        }
        motorcycleRepository.saveMotorcycle(motorcycle);
    }

    public List<Motorcycle> getMotorcycles(){
        return motorcycleRepository.getMotorcycle();
    }
}
