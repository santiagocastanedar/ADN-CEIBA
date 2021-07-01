package co.com.ceiba.domain.service;

import javax.inject.Inject;

import co.com.ceiba.domain.repository.ParkingLotMotorcycleRepository;

public class ParkingLotMotorcycleService {

    private final ParkingLotMotorcycleRepository motorcycleRepository;

    @Inject
    public ParkingLotMotorcycleService(ParkingLotMotorcycleRepository parkingLotMotorcycleRepository){
        this.motorcycleRepository = parkingLotMotorcycleRepository;
    }
}
