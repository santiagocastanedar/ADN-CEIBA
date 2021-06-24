package co.com.ceiba.domain.service;

import javax.inject.Inject;

import co.com.ceiba.domain.aggregate.Vehicle;
import co.com.ceiba.domain.exception.VehicleAlreadyExistsException;
import co.com.ceiba.domain.repository.VehicleRepository;

public class VehicleService {

    private VehicleRepository vehicleRepository;

    @Inject
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public void parkCar(Vehicle vehicle){
        if(vehicleRepository.vehicleExist(vehicle.getPlate())){
            throw new VehicleAlreadyExistsException();
        }else{
            vehicleRepository.parkCar(vehicle);
        }
    }
}
