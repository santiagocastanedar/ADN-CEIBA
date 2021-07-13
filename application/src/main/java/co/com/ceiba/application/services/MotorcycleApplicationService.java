package co.com.ceiba.application.services;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.service.ParkingLotVehicleService;

public class MotorcycleApplicationService {


    @Inject
    public ParkingLotVehicleService parkingLotVehicleService;

    @Inject
    public MotorcycleApplicationService(){

    }

    public void saveMotorcycle(Motorcycle motorcycle){
        try {
            parkingLotVehicleService.saveVehicle(motorcycle);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*public List<Vehicle> getMotorcycle(){
        return parkingLotVehicleService.getVehicles();
    }*/
}
