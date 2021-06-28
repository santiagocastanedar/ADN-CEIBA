package co.com.ceiba.dataaccess.repository;

import androidx.room.Room;

import co.com.ceiba.dataaccess.AppDatabase;
import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.entity.VehicleType;
import co.com.ceiba.domain.repository.ParkingLotRepository;

public class ParkingLotRepositoryImpl implements ParkingLotRepository {

    //AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"parkingDatabase").build();

    @Override
    public boolean saveVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public int getQuantityofVehicles(VehicleType vehicleType) {
        return 0;
    }

    @Override
    public Vehicle getVehicle(String plate) {
        return null;
    }

    @Override
    public boolean parkingLotExist(int id) {
        return false;
    }

    @Override
    public boolean saveParkingLot(ParkingLot parkingLot) {
        return false;
    }

    @Override
    public boolean vehicleExist(String plate) {
        return false;
    }
}
