package co.com.ceiba.domain.service;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.exception.ParkingLotCapacityException;
import co.com.ceiba.domain.exception.VehicleAlreadyExistsException;
import co.com.ceiba.domain.repository.ParkingLotRepository;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    ParkingLot parkingLot;

    @Inject
    public void ParkingLotService(ParkingLotRepository parkingLotRepository,ParkingLot parkingLot){
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLot = parkingLot;
    }

    public void calculatePayment(Vehicle vehicle){
        parkingLotRepository.calculatePayment(vehicle);
    }

    public void allowEntry(Vehicle vehicle){
        if(parkingLotRepository.vehicleExist(vehicle.getPlate())){
            throw new VehicleAlreadyExistsException();
        }else{
            if(vehicle.getVehicleType().getName().equals("Carro")){
                if(parkingLotRepository.getQuantityofVehicles(vehicle.getVehicleType()) > parkingLot.getMaxQuantityCar()){
                    throw new ParkingLotCapacityException();
                }
                parkingLotRepository.allowEntry(vehicle);
            }else if(vehicle.getVehicleType().getName().equals("Moto")){
                if(parkingLotRepository.getQuantityofVehicles(vehicle.getVehicleType()) > parkingLot.getMaxQuantityMotorcycle()){
                    throw new ParkingLotCapacityException();
                }
                parkingLotRepository.allowEntry(vehicle);
            }

        }
    }
}
