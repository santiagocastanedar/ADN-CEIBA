package co.com.ceiba.adnceiba.asynctask;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import co.com.ceiba.application.services.MotorcycleApplicationService;
import co.com.ceiba.domain.entity.Motorcycle;

public class MotorcycleAsyncTask extends AsyncTask<VehicleAsynckTaskParams,String,String> {

    private final MotorcycleApplicationService motorcycleApplicationService;
    private MutableLiveData<String> motorcycleSaved;

    public MotorcycleAsyncTask(MotorcycleApplicationService motorcycleApplicationService,MutableLiveData motorcycleSaved) {
        this.motorcycleApplicationService = motorcycleApplicationService;
        this.motorcycleSaved = motorcycleSaved;
    }

    @Override
    protected String doInBackground(VehicleAsynckTaskParams... vehicleAsynckTaskParams) {
        String plate = vehicleAsynckTaskParams[0].plate;
        String entrydate = vehicleAsynckTaskParams[0].entrydate;
        int cylinder = vehicleAsynckTaskParams[0].cylinder;
        try {
            Motorcycle motorcycle = new Motorcycle(plate,entrydate,cylinder);
            motorcycleApplicationService.saveMotorcycle(motorcycle);
            return "Moto ingresada con exito.";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String saved) {
        motorcycleSaved.setValue(saved);
    }
}