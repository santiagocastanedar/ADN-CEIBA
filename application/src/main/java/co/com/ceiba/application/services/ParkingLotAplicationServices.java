package co.com.ceiba.application.services;

import javax.inject.Inject;

import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.service.ParkingLotService;

public class ParkingLotAplicationServices {

    @Inject
    ParkingLotService parkingLotService;

    @Inject
    public ParkingLotAplicationServices() {
    }

    public void saveParkingLot(ParkingLot parkingLot){
        parkingLotService.createParkingLot(parkingLot);
    }
}
