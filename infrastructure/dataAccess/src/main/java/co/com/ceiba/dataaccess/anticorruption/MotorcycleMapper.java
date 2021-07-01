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
        return new Motorcycle(motorcycleRoom.plate,motorcycleRoom.entryDate,motorcycleRoom.cylinder);
    }

    public List<Motorcycle> listMotorcycleRoomToListMotorcycle(List<MotorcycleRoom> motorcycleRoomList){
        List<Motorcycle> motorcycles = new ArrayList<Motorcycle>();
        for (MotorcycleRoom motorcycleRoom:motorcycleRoomList) {
            motorcycles.add(motorcycleRoomToMotorcycleMapper(motorcycleRoom));
        }

        return motorcycles;
    }
}
