package co.com.ceiba.adnceiba.asynctask;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import co.com.ceiba.application.services.CarAplicationServices;
import co.com.ceiba.domain.entity.Car;

public class CarAsyncTask extends AsyncTask<VehicleAsynckTaskParams,String,String> {

    private CarAplicationServices carAplicationServices;
    private MutableLiveData<String> carSaved;

    public CarAsyncTask(CarAplicationServices carAplicationServices,MutableLiveData carSaved) {
        this.carAplicationServices = carAplicationServices;
        this.carSaved = carSaved;
    }

    @Override
    protected String doInBackground(VehicleAsynckTaskParams... carParam) {
        String plate = carParam[0].plate;
        String entryDate = carParam[0].entrydate;
        try {
            Car car = new Car(plate,entryDate);
            carAplicationServices.saveCar(car);
            return "Carro ingresado con exito.";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String saved) {
        carSaved.setValue(saved);
    }
}