package co.com.ceiba.adnceiba.viewmodel;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.adnceiba.asynctask.CarAsyncTask;
import co.com.ceiba.adnceiba.asynctask.VehicleAsynckTaskParams;
import co.com.ceiba.application.services.CarAplicationServices;
import co.com.ceiba.domain.entity.Car;
import dagger.hilt.android.lifecycle.HiltViewModel;



@HiltViewModel
public class ParkingLotCarViewModel extends ViewModel {

    private final CarAplicationServices carAplicationServices;
    private MutableLiveData<String> carSaved;
    List<Car> carList = new ArrayList<Car>();

    @Inject
    public ParkingLotCarViewModel(CarAplicationServices carAplicationServices){
        this.carAplicationServices = carAplicationServices;
    }

    public List<Car> getCars(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                carList = carAplicationServices.getCars();
            }
        });
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public LiveData<String> executeSaveCar(String plate,String entrydate){
        carSaved = new MutableLiveData<>();
        saveCar(plate,entrydate);
        return carSaved;
    }

    private void saveCar(String plate,String entryDate){
        VehicleAsynckTaskParams vehicleAsynckTaskParams = new VehicleAsynckTaskParams(plate,entryDate,0);
        CarAsyncTask carAsyncTask = new CarAsyncTask(carAplicationServices,carSaved);
        carAsyncTask.execute(vehicleAsynckTaskParams);
    }
}
