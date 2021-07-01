package co.com.ceiba.dataaccess.repository;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.dataaccess.AppDatabase;
import co.com.ceiba.dataaccess.anticorruption.MotorcycleMapper;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.repository.ParkingLotMotorcycleRepository;

public class ParkingLotMotorcycleRepositoryImpl implements ParkingLotMotorcycleRepository {

    AppDatabase appDatabaseParkingLot;

    @Inject
    public ParkingLotMotorcycleRepositoryImpl(AppDatabase appDatabaseParkingLot){
        this.appDatabaseParkingLot = appDatabaseParkingLot;
    }

    @Override
    public Motorcycle motorcycleExist(String plate) {
        return null;
    }

    @Override
    public void saveMotorcycle(Motorcycle motorcycle) {

    }

    @Override
    public int getQuantity() {
        return appDatabaseParkingLot.motorcycleDao().getMotorcycleQuantity();
    }

    @Override
    public List<Motorcycle> getMotorcycle() {
        return new MotorcycleMapper().listMotorcycleRoomToListMotorcycle(appDatabaseParkingLot.motorcycleDao().getMotorcycles());
    }
}
