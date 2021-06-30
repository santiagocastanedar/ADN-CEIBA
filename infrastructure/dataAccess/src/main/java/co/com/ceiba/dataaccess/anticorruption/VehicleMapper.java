package co.com.ceiba.dataaccess.anticorruption;

import co.com.ceiba.dataaccess.entity.VehicleRoom;
import co.com.ceiba.domain.entity.Vehicle;

public class VehicleMapper {

    public VehicleRoom vehicleMapper(Vehicle vehicle){
        return new VehicleRoom(vehicle.getPlate(),
                vehicle.getEntryDate());
    }

    public Vehicle vehicleRoomToVehcleMapper(VehicleRoom vehicleRoom){
        return new Vehicle(vehicleRoom.plate,vehicleRoom.entryDate);
    }
}
