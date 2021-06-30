package co.com.ceiba.domain.service;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.exception.VehicleAlreadyExistsException;
import co.com.ceiba.domain.repository.ParkingLotRepository;

public class ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;
    @Inject
    public ParkingLotService(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }

    public void saveVehicle(Vehicle vehicle){
        if(parkingLotRepository.vehicleExist(vehicle.getPlate()) == null){
            throw new VehicleAlreadyExistsException();
        }
        parkingLotRepository.saveVehicle(vehicle);
    }

}
