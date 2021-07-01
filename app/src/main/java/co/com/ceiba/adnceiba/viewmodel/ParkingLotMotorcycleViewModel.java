package co.com.ceiba.adnceiba.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;

import co.com.ceiba.application.services.MotorcycleApplicationService;

public class ParkingLotMotorcycleViewModel extends ViewModel {

    private final MotorcycleApplicationService motorcycleApplicationService;

    @ViewModelInject
    public ParkingLotMotorcycleViewModel(MotorcycleApplicationService motorcycleApplicationService){
        this.motorcycleApplicationService =  motorcycleApplicationService;
    }
}
