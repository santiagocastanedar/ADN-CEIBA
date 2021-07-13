package co.com.ceiba.adnceiba.dimodule;

import javax.inject.Singleton;

import co.com.ceiba.dataaccess.repository.ParkingLotCarRepositoryImpl;
import co.com.ceiba.domain.repository.ParkingLotVehicleRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;

@Module
@InstallIn(ActivityRetainedComponent.class)
public class ParkingLotModule {

    @ParkingLotCarImpl
    @Singleton
    @Provides
    public static ParkingLotVehicleRepository bindCarRepository(ParkingLotCarRepositoryImpl parkingLotCarRepository){
        return parkingLotCarRepository;
    }

    @ParkingLotMotorcycleImpl
    @Singleton
    @Provides
    public static ParkingLotVehicleRepository bindMotorcycleRepository(co.com.ceiba.dataaccess.repository.ParkingLotMotorcycleRepositoryImpl parkingLotMotorcycleRepository){
        return parkingLotMotorcycleRepository;
    }
}
