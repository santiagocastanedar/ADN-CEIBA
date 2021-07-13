package co.com.ceiba.dataaccess.repository;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.dataaccess.AppDatabase;
import co.com.ceiba.dataaccess.anticorruption.MotorcycleMapper;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.repository.ParkingLotVehicleRepository;

public class ParkingLotMotorcycleRepositoryImpl implements ParkingLotVehicleRepository {

    private AppDatabase appDatabaseParkingLot;

    @Inject
    public ParkingLotMotorcycleRepositoryImpl(AppDatabase appDatabaseParkingLot){
        this.appDatabaseParkingLot = appDatabaseParkingLot;
    }


    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        appDatabaseParkingLot.motorcycleDao().insertVehicle(new MotorcycleMapper().motorcycleTomotorcycleRoomMapper((Motorcycle) vehicle));
        return vehicle;
    }

    @Override
    public Vehicle vehicleExist(String plate) {
        return new MotorcycleMapper().motorcycleRoomToMotorcycleMapper(appDatabaseParkingLot.motorcycleDao().getMotorcycle(plate));
    }

    @Override
    public int getQuantity() {
        return appDatabaseParkingLot.motorcycleDao().getMotorcycleQuantity();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return new MotorcycleMapper().listMotorcycleRoomToListMotorcycle(appDatabaseParkingLot.motorcycleDao().getMotorcycles());
    }
}
