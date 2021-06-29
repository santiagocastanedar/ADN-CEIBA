package co.com.ceiba.domain.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.exception.WrongPlateException;
import co.com.ceiba.domain.exception.WrongVehicleInformationException;
import co.com.ceiba.domain.exception.WrongVehicleTypeException;
import co.com.ceiba.domain.valueobject.VehicleInformation;

public class Vehicle {
    private String plate;
    private VehicleInformation vehicleInformation;
    private VehicleType vehicleType;
    private String entryDate;
    private String departureDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public Vehicle(String plate,VehicleType vehicleType,VehicleInformation vehicleInformation){
        validatePlate(plate);
        setVehicleInformation(vehicleInformation);
        setVehicleType(vehicleType);
        this.entryDate =  dateFormat.format(new Date());

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

    public String getEntryDate() {
        return entryDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    private void validatePlate(String plate){
        if(plate.length() != 6 ){
            throw new WrongPlateException();
        }
        this.plate = plate;
    }


}
