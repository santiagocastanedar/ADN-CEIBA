package co.com.ceiba.adnceiba.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;

import co.com.ceiba.application.services.ParkingLotAplicationServices;

public class ParkingLotViewModel extends ViewModel {

    private final ParkingLotAplicationServices parkingLotAplicationServices;

    @ViewModelInject
    public ParkingLotViewModel(ParkingLotAplicationServices parkingLotAplicationServices){
        this.parkingLotAplicationServices = parkingLotAplicationServices;
    }
}
