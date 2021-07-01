package co.com.ceiba.adnceiba.dimodule;

import co.com.ceiba.dataaccess.repository.ParkingLotMotorcycleRepositoryImpl;
import co.com.ceiba.domain.repository.ParkingLotMotorcycleRepository;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class ParkingLotMotorcycleModule {

    @Binds
    public abstract ParkingLotMotorcycleRepository bindParkingLotMotorcycleRepository(ParkingLotMotorcycleRepositoryImpl parkingLotMotorcycleRepository);

}
