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
import co.com.ceiba.domain.entity.Motorcycle;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ParkingLotMotorcycleViewModel extends ViewModel {


    private final MotorcycleApplicationService motorcycleApplicationService;
    private MutableLiveData<String> motorcycleSaved;
    private List<Motorcycle> motorcycleList = new ArrayList<Motorcycle>();

    @Inject
    public ParkingLotMotorcycleViewModel(MotorcycleApplicationService motorcycleApplicationService){
        this.motorcycleApplicationService =  motorcycleApplicationService;
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

    public List<Motorcycle> getMotorcycles() throws InterruptedException {

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
