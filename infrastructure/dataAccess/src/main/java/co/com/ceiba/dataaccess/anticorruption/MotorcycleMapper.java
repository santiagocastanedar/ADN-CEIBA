package co.com.ceiba.dataaccess.anticorruption;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.dataaccess.entity.CarRoom;
import co.com.ceiba.dataaccess.entity.MotorcycleRoom;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;

public class MotorcycleMapper {

    public MotorcycleRoom motorcycleTomotorcycleRoomMapper(Motorcycle motorcycle){
        return new MotorcycleRoom(motorcycle.getPlate(),
                motorcycle.getCylinder(),
                motorcycle.getEntryDate());
    }

    public Motorcycle motorcycleRoomToMotorcycleMapper(MotorcycleRoom motorcycleRoom){
        if(motorcycleRoom != null){
            return new Motorcycle(motorcycleRoom.plate,motorcycleRoom.entryDate,motorcycleRoom.cylinder);
        }else{
            return null;
        }
    }

    public List<Vehicle> listMotorcycleRoomToListMotorcycle(List<MotorcycleRoom> motorcycleRoomList){
        List<Vehicle> motorcycles = new ArrayList<Vehicle>();
        for (MotorcycleRoom motorcycleRoom:motorcycleRoomList) {
            motorcycles.add(motorcycleRoomToMotorcycleMapper(motorcycleRoom));
        }

        return motorcycles;
    }
}
