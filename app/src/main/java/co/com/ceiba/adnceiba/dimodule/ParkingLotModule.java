package co.com.ceiba.adnceiba.dimodule;

import co.com.ceiba.dataaccess.repository.ParkingLotRepositoryImpl;
import co.com.ceiba.domain.repository.ParkingLotRepository;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class ParkingLotModule {

    @Binds
    public abstract ParkingLotRepository bindParkingLotRepository(ParkingLotRepositoryImpl parkingLotRepository);
}
