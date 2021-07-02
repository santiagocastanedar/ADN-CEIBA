package co.com.ceiba.application.services;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.service.ParkingLotMotorcycleService;

public class MotorcycleApplicationService {

    @Inject
    ParkingLotMotorcycleService parkingLotMotorcycleService;

    @Inject
    public MotorcycleApplicationService(){

    }

    public void saveMotorcycle(Motorcycle motorcycle){
        parkingLotMotorcycleService.saveMotorcycle(motorcycle);
    }

    public List<Motorcycle> getMotorcycle(){
        return parkingLotMotorcycleService.getMotorcycles();
    }
}
