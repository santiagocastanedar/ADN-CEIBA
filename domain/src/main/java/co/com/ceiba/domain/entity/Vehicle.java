package co.com.ceiba.domain.entity;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.exception.RestPlateException;
import co.com.ceiba.domain.exception.WrongDateException;
import co.com.ceiba.domain.exception.WrongPlateException;

import static co.com.ceiba.domain.utils.Constant.DATE_FORMAT_PAYMENT;
import static co.com.ceiba.domain.utils.Constant.MONDAY_PERMIT;
import static co.com.ceiba.domain.utils.Constant.PLATE_CHARACTERS_REQUIERE;
import static co.com.ceiba.domain.utils.Constant.PLATE_REST;
import static co.com.ceiba.domain.utils.Constant.SUNDAY_PERMIT;


public class Vehicle {
    private String plate;
    private String entryDate;
    private String departureDate;
    private String type;

    public Vehicle(String plate, String entryDate,String type) {
        setEntryDate(entryDate);
        setPlate(plate);
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        if(plate.length() != PLATE_CHARACTERS_REQUIERE){
            throw new WrongPlateException();
        }
        this.plate = plate;
    }

    public void setEntryDate(String entryDate) {
         validateDate(entryDate);
        this.entryDate = entryDate;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        validateDate(departureDate);
        this.departureDate = departureDate;
    }

    public void validateDate(String date){
        if(date.equals("")){
            throw new WrongDateException();
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
