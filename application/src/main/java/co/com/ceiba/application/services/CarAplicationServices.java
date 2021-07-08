package co.com.ceiba.application.services;

import android.util.Log;
import android.widget.Toast;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.service.ParkingLotCarService;

public class CarAplicationServices {

    @Inject
    public ParkingLotCarService parkingLotCarService;

    @Inject
    public CarAplicationServices(){

    }

    public void saveCar(Car car){
        try {
            parkingLotCarService.saveVehicle(car);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getCars(){
        return parkingLotCarService.getCars();
    }
}
