package co.com.ceiba.adnceiba.viewmodel;

import android.os.AsyncTask;
import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.application.services.CarAplicationServices;
import co.com.ceiba.domain.entity.Car;
import dagger.hilt.android.lifecycle.HiltViewModel;


@HiltViewModel
public class ParkingLotCarViewModel extends ViewModel {

    private final CarAplicationServices carAplicationServices;
    private MutableLiveData<Boolean> carSaved;

    @Inject
    public ParkingLotCarViewModel(CarAplicationServices carAplicationServices){
        this.carAplicationServices = carAplicationServices;
    }

    public LiveData<Boolean> executeSaveCar(Car car){
        if(carSaved == null){
            carSaved = new MutableLiveData<>();
            saveCar(car);
        }
        return carSaved;
    }

    private void saveCar(Car car){
        CarAsyncTask carAsyncTask = new CarAsyncTask();
        carAsyncTask.execute(car);
    }

    class CarAsyncTask extends AsyncTask<Car,String,Boolean>{

        @Override
        protected Boolean doInBackground(Car... car) {
            try {
                carAplicationServices.saveCar(car[0]);
                return true;
            }catch (Exception e){
                Log.e("Error1",e.getMessage());
                return false;
            }
        }
    }
}
