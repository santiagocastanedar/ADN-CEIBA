package co.com.ceiba.adnceiba;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class ParkingLotApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
