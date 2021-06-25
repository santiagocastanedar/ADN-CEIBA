package co.com.ceiba.domain.aggregate;

import co.com.ceiba.domain.entity.VehicleType;
import co.com.ceiba.domain.exception.WrongPlateException;
import co.com.ceiba.domain.exception.WrongVehicleInformationException;
import co.com.ceiba.domain.exception.WrongVehicleTypeException;
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
        setVehicleInformation(vehicleInformation);
        setVehicleType(vehicleType);

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
        if(vehicleInformation == null){
            throw new WrongVehicleInformationException();
        }
        this.vehicleInformation = vehicleInformation;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        if(vehicleType == null){
            throw new WrongVehicleTypeException();
        }
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
