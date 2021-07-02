package co.com.ceiba.dataaccess.repository;

import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import co.com.ceiba.dataaccess.AppDatabase;
import co.com.ceiba.dataaccess.anticorruption.CarMapper;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.repository.ParkingLotCarRepository;

public class ParkingLotCarRepositoryImpl implements ParkingLotCarRepository {


    private AppDatabase databaseParkingLot;

    @Inject
    public ParkingLotCarRepositoryImpl(AppDatabase databaseParkingLot) {
        this.databaseParkingLot = databaseParkingLot;
    }



    @Override
    public void saveVehicle(Car car) {
        databaseParkingLot.carDao().insertCar(new CarMapper().carToCarRoomMapper(car));
    }

    @Override
    public Car getCar(String plate) {
        return new CarMapper().carRoomToCarMapper(databaseParkingLot.carDao().getCarRoom(plate));
    }

    @Override
    public int getQuantity() {
        return databaseParkingLot.carDao().getCarQuantity();
    }

    @Override
    public List<Car> getCars() {
        return new CarMapper().listCarRoomToListCar(databaseParkingLot.carDao().getCars());
    }


    /*@Override
    public int getQuantity() {
        return databaseParkingLot.carDao().getCarQuantity();
    }*/

    /*@Override
    public List<Car> getCars() {
        return new CarMapper().listCarRoomToListCar(databaseParkingLot.carDao().getCars());
    }*/
}
