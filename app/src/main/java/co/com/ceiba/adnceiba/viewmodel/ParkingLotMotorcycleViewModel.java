package co.com.ceiba.adnceiba.viewmodel;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.application.services.MotorcycleApplicationService;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ParkingLotMotorcycleViewModel extends ViewModel {


    private final MotorcycleApplicationService motorcycleApplicationService;
    private MutableLiveData<Boolean> motorcycleSaved;
    List<Motorcycle> motorcycleList = new ArrayList<Motorcycle>();

    @Inject
    public ParkingLotMotorcycleViewModel(MotorcycleApplicationService motorcycleApplicationService){
        this.motorcycleApplicationService =  motorcycleApplicationService;
    }

    public LiveData<Boolean> executeSaveMotorcycle(Motorcycle motorcycle){
        if(motorcycleSaved == null){
            motorcycleSaved = new MutableLiveData<>();
            saveMotorcycle(motorcycle);
        }
        return motorcycleSaved;
    }

    private void saveMotorcycle(Motorcycle motorcycle){
        MotorcycleAsyncTask motorcycleAsyncTask = new MotorcycleAsyncTask();
        motorcycleAsyncTask.execute(motorcycle);
    }

    class MotorcycleAsyncTask extends AsyncTask<Motorcycle,String,Boolean> {

        @Override
        protected Boolean doInBackground(Motorcycle... motorcycles) {
            try {
                motorcycleApplicationService.saveMotorcycle(motorcycles[0]);
                return true;
            }catch (Exception e){
                Log.e("Error1",e.getMessage());
                return false;
            }
        }
    }

    public List<Motorcycle> getMotorcycles(){

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                motorcycleList = motorcycleApplicationService.getMotorcycle();
            }
        });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
        return motorcycleList;
    }
}
