package co.com.ceiba.domain.entity;

import java.util.List;

import co.com.ceiba.domain.aggregate.Vehicle;
import co.com.ceiba.domain.exception.ParkingInformationException;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;

public class ParkingLot {
    private int id;
    private String name;
    private int maxQuaintityCar;
    private int maxQuantityMotorcycle;
    private ParkingInformationRate parkingInformationRate;
    private List<Vehicle> vehicleList;

    public ParkingLot(int id, String name, ParkingInformationRate parkingInformationRate,List<Vehicle> vehicles,int maxQuaintityCar,int maxQuantityMotorcycle) {
        this.id = id;
        this.name = name;
        this.vehicleList = vehicles;
        setMaxQuaintityCar(maxQuaintityCar);
        setMaxQuantityMotorcycle(maxQuantityMotorcycle);
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

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public int getMaxQuaintityCar() {
        return maxQuaintityCar;
    }

    public void setMaxQuaintityCar(int maxQuaintityCar) {
        if(maxQuaintityCar == 0){
            maxQuaintityCar = 20;
        }
        this.maxQuaintityCar = maxQuaintityCar;
    }

    public int getMaxQuantityMotorcycle() {
        return maxQuantityMotorcycle;
    }

    public void setMaxQuantityMotorcycle(int maxQuantityMotorcycle) {
        if(maxQuantityMotorcycle == 0){
            maxQuantityMotorcycle = 10;
        }
        this.maxQuantityMotorcycle = maxQuantityMotorcycle;
    }
}
