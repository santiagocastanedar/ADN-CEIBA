package co.com.ceiba.domain.entity;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import co.com.ceiba.domain.exception.WrongDateException;
import co.com.ceiba.domain.exception.WrongPlateException;

import static co.com.ceiba.domain.utils.Constant.PLATE_CHARACTERS_REQUIERE;


public class Vehicle {
    private String plate;
    private String entryDate;
    private String departureDate;

    public Vehicle(String plate, String entryDate) {
        validatePlate(plate,entryDate);
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

    private void validatePlate(String plate,String entryDate){
        String dayOfWeef = "";
        TimeZone timeZone = TimeZone.getDefault();
        Calendar calendar = new GregorianCalendar(timeZone);

        if(plate.length() != PLATE_CHARACTERS_REQUIERE){
            throw new WrongPlateException();
        }else if(entryDate.equals("")){
            throw new WrongDateException();
        }

        this.plate = plate;
    }


}
