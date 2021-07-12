package co.com.ceiba.dataaccess.anticorruption;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.dataaccess.entity.CarRoom;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Vehicle;

public class CarMapper {

    public CarRoom carToCarRoomMapper(Vehicle car){
        return new CarRoom(car.getPlate(),
                car.getEntryDate());
    }

    public Car carRoomToCarMapper(CarRoom carRoom){
        if(carRoom != null){
            return new Car(carRoom.plate,carRoom.entryDate);
        }else {
            return null;
        }
    }
    
    public List<Vehicle> listCarRoomToListCar(List<CarRoom> carRoomList){
        List<Vehicle> carList = new ArrayList<Vehicle>();
        for (CarRoom car:carRoomList) {
            carList.add(carRoomToCarMapper(car));
        }
        return carList;
    }
}
