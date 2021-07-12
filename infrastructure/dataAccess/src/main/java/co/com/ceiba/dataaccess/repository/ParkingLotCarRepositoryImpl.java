package co.com.ceiba.dataaccess.repository;

import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.dataaccess.AppDatabase;
import co.com.ceiba.dataaccess.anticorruption.CarMapper;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.repository.ParkingLotVehicleRepository;

public class ParkingLotCarRepositoryImpl implements ParkingLotVehicleRepository {

    private AppDatabase databaseParkingLot;

    @Inject
    public ParkingLotCarRepositoryImpl(AppDatabase databaseParkingLot) {
        this.databaseParkingLot = databaseParkingLot;
    }
    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        databaseParkingLot.carDao().insertCar(new CarMapper().carToCarRoomMapper(vehicle));
        return vehicle;
    }

    @Override
    public Vehicle VehicleExist(String plate) {
        return new CarMapper().carRoomToCarMapper(databaseParkingLot.carDao().getCarRoom(plate));
    }

    @Override
    public int getQuantity() {
        return databaseParkingLot.carDao().getCarQuantity();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return new CarMapper().listCarRoomToListCar(databaseParkingLot.carDao().getCars());
    }
}
