package co.com.ceiba.adnceiba.asynctask;

import android.os.AsyncTask;

import co.com.ceiba.application.services.MotorcycleApplicationService;
import co.com.ceiba.domain.entity.Motorcycle;

public class MotorcycleAsyncTask extends AsyncTask<Motorcycle,String,Boolean> {

    private final MotorcycleApplicationService motorcycleApplicationService;

    public MotorcycleAsyncTask(MotorcycleApplicationService motorcycleApplicationService) {
        this.motorcycleApplicationService = motorcycleApplicationService;
    }

    @Override
    protected Boolean doInBackground(Motorcycle... motorcycles) {
        try {
            motorcycleApplicationService.saveMotorcycle(motorcycles[0]);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}