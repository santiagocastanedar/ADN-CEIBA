package co.com.ceiba.dataaccess.anticorruption;

import co.com.ceiba.dataaccess.entity.VehicleTypeRoom;
import co.com.ceiba.domain.entity.VehicleType;

public class VehicleTypeMapper {
    public VehicleTypeRoom vehicleTypeRoomMapper(VehicleType vehicleType){
        return new VehicleTypeRoom(vehicleType.getName(),1);
    }
}
