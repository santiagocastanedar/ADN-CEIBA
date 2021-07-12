package co.com.ceiba.adnceiba.viewmodel;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.adnceiba.asynctask.MotorcycleAsyncTask;
import co.com.ceiba.adnceiba.asynctask.VehicleAsynckTaskParams;
import co.com.ceiba.application.services.MotorcycleApplicationService;
import co.com.ceiba.dataaccess.AppDatabase;
import co.com.ceiba.dataaccess.repository.ParkingLotMotorcycleRepositoryImpl;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.service.ParkingLotVehicleService;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ParkingLotMotorcycleViewModel extends ViewModel {


    private final MotorcycleApplicationService motorcycleApplicationService;
    private MutableLiveData<String> motorcycleSaved;
    private List<Vehicle> motorcycleList = new ArrayList<Vehicle>();
    private ParkingLotVehicleService parkingLotVehicleService;

    @Inject
    public ParkingLotMotorcycleViewModel(AppDatabase appDatabase){
        this.parkingLotVehicleService = new ParkingLotVehicleService(new ParkingLotMotorcycleRepositoryImpl(appDatabase));
        this.motorcycleApplicationService =  new MotorcycleApplicationService(parkingLotVehicleService);
    }

    public LiveData<String> executeSaveMotorcycle(String plate,String entrydate,int cylinder){
        motorcycleSaved = new MutableLiveData<>();
        saveMotorcycle(plate,entrydate,cylinder);
        return motorcycleSaved;
    }

    private void saveMotorcycle(String plate,String entrydate,int cylinder){
        VehicleAsynckTaskParams vehicleAsynckTaskParams = new VehicleAsynckTaskParams(plate,entrydate,cylinder);
        MotorcycleAsyncTask motorcycleAsyncTask = new MotorcycleAsyncTask(motorcycleApplicationService,motorcycleSaved);
        motorcycleAsyncTask.execute(vehicleAsynckTaskParams);
    }

    public List<Vehicle> getMotorcycles() throws InterruptedException {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                motorcycleList = motorcycleApplicationService.getMotorcycle();
            }
        });
        Thread.sleep(5000);
        return motorcycleList;
    }
}
