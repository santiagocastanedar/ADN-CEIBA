package co.com.ceiba.domain.entity;



import android.text.format.DateFormat;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import co.com.ceiba.domain.exception.RestPlateException;
import co.com.ceiba.domain.exception.WrongDateException;
import co.com.ceiba.domain.exception.WrongPlateException;

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
        validatePlate(plate);
        validateEntryPlate(plate,entryDate);
        this.plate = plate;
        this.entryDate = entryDate;
        this.type = type;
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
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private void validateEntryPlate(String plate, String entryDate){
        Date date;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if(entryDate.equals("")){
            throw new WrongDateException();
        }
        try {
            date = (Date)formatter.parse(entryDate);
            if(date.getDay() != SUNDAY_PERMIT && date.getDay() != MONDAY_PERMIT && plate.startsWith(PLATE_REST)){
                throw new RestPlateException();
            }
        } catch (ParseException e) {

        }

    }



}
