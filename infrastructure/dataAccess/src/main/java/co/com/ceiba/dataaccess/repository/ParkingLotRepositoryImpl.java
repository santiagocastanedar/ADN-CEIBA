package co.com.ceiba.dataaccess.repository;

import javax.inject.Inject;

import co.com.ceiba.dataaccess.AppDatabase;
import co.com.ceiba.dataaccess.anticorruption.VehicleMapper;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.repository.ParkingLotRepository;

public class ParkingLotRepositoryImpl implements ParkingLotRepository {

    private AppDatabase databaseParkingLot;

    @Inject
    public ParkingLotRepositoryImpl(AppDatabase databaseParkingLot) {
        this.databaseParkingLot = databaseParkingLot;
    }

    @Override
    public Vehicle vehicleExist(String plate) {
        return new VehicleMapper().vehicleRoomToVehcleMapper(databaseParkingLot.vehicleDao().getVehicle(plate));

    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        databaseParkingLot.vehicleDao().insertVehicle(new VehicleMapper().vehicleMapper(vehicle));
    }
}
