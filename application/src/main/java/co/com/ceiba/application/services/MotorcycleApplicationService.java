package co.com.ceiba.application.services;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.service.ParkingLotVehicleService;

public class MotorcycleApplicationService {

    public ParkingLotVehicleService parkingLotVehicleService;

    public MotorcycleApplicationService(ParkingLotVehicleService parkingLotVehicleService){
        this.parkingLotVehicleService = parkingLotVehicleService;

    }

    public void saveMotorcycle(Motorcycle motorcycle){
        try {
            parkingLotVehicleService.saveVehicle(motorcycle);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> getMotorcycle(){
        return parkingLotVehicleService.getVehicles();
    }
}
