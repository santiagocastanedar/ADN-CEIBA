package co.com.ceiba.adnceiba.dimodule;

import javax.inject.Singleton;

import co.com.ceiba.dataaccess.repository.ParkingLotCarRepositoryImpl;
import co.com.ceiba.dataaccess.repository.ParkingLotMotorcycleRepositoryImpl;
import co.com.ceiba.domain.other.PaymentVehicle;
import co.com.ceiba.domain.repository.ParkingLotCarRepository;
import co.com.ceiba.domain.repository.ParkingLotMotorcycleRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(ActivityRetainedComponent.class)
public abstract class ParkingLotModule {


    @Binds
    public abstract ParkingLotMotorcycleRepository bindParkingLotMotorcycleRepository(ParkingLotMotorcycleRepositoryImpl parkingLotMotorcycleRepository);
    @Binds
    public abstract ParkingLotCarRepository bindParkingLotCarRepository(ParkingLotCarRepositoryImpl parkingLotRepository);
}
