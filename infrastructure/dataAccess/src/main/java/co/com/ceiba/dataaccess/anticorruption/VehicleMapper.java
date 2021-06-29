package co.com.ceiba.dataaccess.anticorruption;

import co.com.ceiba.dataaccess.entity.VehicleRoom;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.entity.VehicleType;
import co.com.ceiba.domain.valueobject.VehicleInformation;

public class VehicleMapper {

    public VehicleRoom vehicleMapper(Vehicle vehicle){
        return new VehicleRoom(vehicle.getPlate(),
                vehicle.getVehicleInformation().getColor(),
                vehicle.getVehicleInformation().getBrand(),
                vehicle.getVehicleInformation().getCylinder(),
                vehicle.getVehicleType().getId(),1,
                vehicle.getEntryDate());
    }

    public Vehicle vehicleRoomToVehcleMapper(VehicleRoom vehicleRoom){
        return new Vehicle(vehicleRoom.plate,
                new VehicleType(vehicleRoom.vehicleType,"carro"),
                new VehicleInformation(vehicleRoom.cylinder));
    }
}
