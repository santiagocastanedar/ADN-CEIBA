package co.com.ceiba.application.services;

import android.util.Log;
import android.widget.Toast;

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
        parkingLotCarService.saveVehicle(car);
    }

    public List<Car> getCars(){
        return parkingLotCarService.getCars();
    }

    public String createCar(String plate, String entryDate){
        String response = "";
        try {
            Car car = new Car(plate,entryDate);
        }catch (Exception e){
            response = e.getMessage();
        }
        return response;
    }
}
