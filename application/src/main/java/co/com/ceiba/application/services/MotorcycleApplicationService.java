package co.com.ceiba.application.services;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.service.ParkingLotMotorcycleService;

public class MotorcycleApplicationService {

    @Inject
    public ParkingLotMotorcycleService parkingLotMotorcycleService;

    @Inject
    public MotorcycleApplicationService(){

    }

    public void saveMotorcycle(Motorcycle motorcycle){
        try {
            parkingLotMotorcycleService.saveMotorcycle(motorcycle);
        }catch (Exception e){
            Log.e("mensaje",e.getMessage());
        }
    }

    public List<Motorcycle> getMotorcycle(){
        return parkingLotMotorcycleService.getMotorcycles();
    }
}
