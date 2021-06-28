package co.com.ceiba.domain.aggregate;

import java.util.List;

import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.exception.ParkingInformationException;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;

public class ParkingLot {
    private int id;
    private String name;
    private int maxQuantityCar;
    private int maxQuantityMotorcycle;
    private ParkingInformationRate parkingInformationRate;
    private List<Vehicle> vehicleList;

    public ParkingLot(int id, String name, ParkingInformationRate parkingInformationRate, List<Vehicle> vehicles, int maxQuantityCar, int maxQuantityMotorcycle) {
        this.id = id;
        this.name = name;
        this.vehicleList = vehicles;
        setMaxQuantityCar(maxQuantityCar);
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

    public int getMaxQuantityCar() {
        return maxQuantityCar;
    }

    public void setMaxQuantityCar(int maxQuantityCar) {
        if(maxQuantityCar == 0){
            maxQuantityCar = 20;
        }
        this.maxQuantityCar = maxQuantityCar;
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
