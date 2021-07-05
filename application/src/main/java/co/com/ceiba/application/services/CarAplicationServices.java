package co.com.ceiba.application.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.service.ParkingLotCarService;

public class CarAplicationServices {

    @Inject
    ParkingLotCarService parkingLotCarService;

    @Inject
    public CarAplicationServices(){

    }

    public void saveCar(Car car){
        try {
            parkingLotCarService.saveVehicle(car);
        }catch (Exception e){
            Log.e("mensaje",e.getMessage());
        }
    }

    public List<Car> getCars(){
        return parkingLotCarService.getCars();
    }

}
