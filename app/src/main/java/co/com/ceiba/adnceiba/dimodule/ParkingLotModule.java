package co.com.ceiba.adnceiba.dimodule;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import co.com.ceiba.domain.repository.ParkingLotVehicleRepository;
import co.com.ceiba.domain.service.CarCapacityServiceImpl;
import co.com.ceiba.domain.service.MotorcycleCapacityServideImpl;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;

@Module
@InstallIn(ActivityRetainedComponent.class)
public abstract class ParkingLotModule {

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ParkingLotMotorcycleRepositoryImpl {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ParkingLotCarRepositoryImpl {
    }

    @ParkingLotCarRepositoryImpl
    @Singleton
    @Binds
    public abstract ParkingLotVehicleRepository bindCarRepository(co.com.ceiba.dataaccess.repository.ParkingLotCarRepositoryImpl parkingLotCarRepository);

    @ParkingLotMotorcycleRepositoryImpl
    @Singleton
    @Binds
    public abstract ParkingLotVehicleRepository bindMotorcycleRepository(co.com.ceiba.dataaccess.repository.ParkingLotMotorcycleRepositoryImpl parkingLotMotorcycleRepository);

}
