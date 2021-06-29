package co.com.ceiba.adnceiba.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import co.com.ceiba.application.services.ParkingLotAplicationServices;
import co.com.ceiba.domain.aggregate.ParkingLot;

public class ParkingLotViewModel extends ViewModel {

    private ParkingLotAplicationServices parkingLotService;

    @ViewModelInject
    public ParkingLotViewModel(ParkingLotAplicationServices parkingLotAplicationServices){
        this.parkingLotService = parkingLotService;
    }

    public void createParkingLot(ParkingLot parkingLot){
        parkingLotService.saveParkingLot(parkingLot);
    }





}
