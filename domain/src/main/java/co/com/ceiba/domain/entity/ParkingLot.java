package co.com.ceiba.domain.entity;

import co.com.ceiba.domain.exception.ParkingInformationException;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;

public class ParkingLot {
    private int id;
    private String name;
    private ParkingInformationRate parkingInformationRate;

    public ParkingLot(int id, String name, ParkingInformationRate parkingInformationRate) {
        this.id = id;
        this.name = name;
        setParkingInformationRate(parkingInformationRate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParkingInformationRate getParkingInformationRate() {
        return parkingInformationRate;
    }

    public void setParkingInformationRate(ParkingInformationRate parkingInformationRate) {
        if(parkingInformationRate == null){
            throw new ParkingInformationException();
        }
        this.parkingInformationRate = parkingInformationRate;
    }
}
