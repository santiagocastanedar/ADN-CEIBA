package co.com.ceiba.domain.entity;



import co.com.ceiba.domain.exception.WrongPlateException;

import static co.com.ceiba.domain.utils.Constant.PLATE_CHARACTERS_REQUIERE;


public class Vehicle {
    private String plate;
    private String entryDate;
    private String departureDate;

    public Vehicle(String plate, String entryDate) {
        validatePlate(plate);
        this.entryDate = entryDate;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
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
        if(plate.length() != PLATE_CHARACTERS_REQUIERE){
            throw new WrongPlateException();
        }
        this.plate = plate;
    }


}
