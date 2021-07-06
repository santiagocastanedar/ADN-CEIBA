package co.com.ceiba.domain.entity;

import static co.com.ceiba.domain.utils.Constant.CAR;

public class Car extends Vehicle {

    public Car(String plate, String entryDate) {
        super(plate, entryDate,CAR);
    }
}
