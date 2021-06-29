package co.com.ceiba.dataaccess.repository;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import javax.inject.Inject;

import co.com.ceiba.dataaccess.AppDatabase;
import co.com.ceiba.dataaccess.anticorruption.ParkingLotMapper;
import co.com.ceiba.dataaccess.anticorruption.VehicleMapper;
import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.entity.VehicleType;
import co.com.ceiba.domain.repository.ParkingLotRepository;

public class ParkingLotRepositoryImpl implements ParkingLotRepository {

    AppDatabase db;

    @Inject
    public ParkingLotRepositoryImpl(AppDatabase db) {
        this.db = db;
    }


    @Override
    public boolean saveVehicle(Vehicle vehicle) {
        db.vehicleDao().insertVehicle(new VehicleMapper().vehicleMapper(vehicle));
        return false;
    }

    @Override
    public int getQuantityofVehicles(VehicleType vehicleType) {
        return db.vehicleDao().getVehicleQuantity(vehicleType.getId());
    }

    @Override
    public Vehicle getVehicle(String plate) {
        return new VehicleMapper().vehicleRoomToVehcleMapper(db.vehicleDao().getVehicle(plate));
    }

    @Override
    public boolean parkingLotExist(int id) {
        if(db.parkingLotDao().getParkingLotById(id) != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean saveParkingLot(ParkingLot parkingLot) {
        db.parkingLotDao().insertParkingLot(new ParkingLotMapper().parkingLotMapper(parkingLot));
        return true;
    }

    @Override
    public boolean vehicleExist(String plate) {
        if(db.vehicleDao().getVehicle(plate) != null){
            return true;
        }
        return true;
    }
}
