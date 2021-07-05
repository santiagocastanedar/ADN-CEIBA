package co.com.ceiba.adnceiba.asynctask;

import android.os.AsyncTask;

import co.com.ceiba.application.services.CarAplicationServices;
import co.com.ceiba.domain.entity.Car;

public class CarAsyncTask extends AsyncTask<Car,String,Boolean> {

    CarAplicationServices carAplicationServices;

    public CarAsyncTask(CarAplicationServices carAplicationServices) {
        this.carAplicationServices = carAplicationServices;
    }

    @Override
    protected Boolean doInBackground(Car... car) {
        try {
            carAplicationServices.saveCar(car[0]);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}