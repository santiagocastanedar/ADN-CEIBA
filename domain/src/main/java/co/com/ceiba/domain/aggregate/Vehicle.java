package co.com.ceiba.domain.aggregate;

import co.com.ceiba.domain.entity.VehicleType;
import co.com.ceiba.domain.exception.WrongPlateException;
import co.com.ceiba.domain.valueobject.VehicleInformation;

public class Vehicle {
    private String plate;
    private VehicleInformation vehicleInformation;
    private VehicleType vehicleType;

    public Vehicle(String plate,VehicleType vehicleType,VehicleInformation vehicleInformation){
        if(validatePlate(plate)){
            this.plate = plate;
        }else{
            throw new WrongPlateException();
        }
        this.vehicleType = vehicleType;
        this.vehicleInformation = vehicleInformation;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public VehicleInformation getVehicleInformation() {
        return vehicleInformation;
    }

    public void setVehicleInformation(VehicleInformation vehicleInformation) {
        this.vehicleInformation = vehicleInformation;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    private boolean validatePlate(String plate){
        if(plate.length() == 6 ){
            return true;
        }else{
            return false;
        }
    }

}
