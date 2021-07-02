package co.com.ceiba.dataaccess.anticorruption;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.dataaccess.entity.CarRoom;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Vehicle;

public class CarMapper {

    public CarRoom carToCarRoomMapper(Car car){
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
    
    public List<Car> listCarRoomToListCar(List<CarRoom> carRoomList){
        List<Car> carList = new ArrayList<Car>();
        for (CarRoom car:carRoomList) {
            carList.add(carRoomToCarMapper(car));
        }

        return carList;
    }
}
