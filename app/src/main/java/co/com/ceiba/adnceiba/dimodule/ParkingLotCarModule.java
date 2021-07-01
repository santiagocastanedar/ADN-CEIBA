package co.com.ceiba.adnceiba.dimodule;

import javax.inject.Singleton;

import co.com.ceiba.dataaccess.repository.ParkingLotCarRepositoryImpl;
import co.com.ceiba.domain.repository.ParkingLotCarRepository;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class ParkingLotCarModule {


    @Binds
    public abstract ParkingLotCarRepository bindParkingLotCarRepository(ParkingLotCarRepositoryImpl parkingLotRepository);
}
