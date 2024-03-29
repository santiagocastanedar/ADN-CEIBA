package co.com.ceiba.application.services;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.service.ParkingLotVehicleService;

public class CarAplicationServices {


    public ParkingLotVehicleService parkingLotVehicleService;


    public CarAplicationServices(ParkingLotVehicleService parkingLotVehicleService){
        this.parkingLotVehicleService = parkingLotVehicleService;
    }

    public void saveCar(Car car){
        try {
            parkingLotVehicleService.saveVehicle(car);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> getCars(){
        return parkingLotVehicleService.getVehicles();
    }
}
