package co.com.ceiba.domain.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.exception.WrongDateException;

import static co.com.ceiba.domain.utils.Constant.ADDITIONAL_PRICE_MOTORCYCLE;
import static co.com.ceiba.domain.utils.Constant.DATE_FORMAT_PAYMENT;
import static co.com.ceiba.domain.utils.Constant.ENDDAY;
import static co.com.ceiba.domain.utils.Constant.MAX_CYLINDER_MOTORCYCLE;
import static co.com.ceiba.domain.utils.Constant.STARTDAY;
import static co.com.ceiba.domain.utils.Constant.TIME_TRANSFORM;

public class PaymentVehicle {

    public double calculatePaymentVehicle(Vehicle vehicle,double rateHour,double rateDay) {
        int startDay = STARTDAY;
        int endDay = ENDDAY;
        long time = calculateTimeInParkingLot(vehicle.getEntryDate(),vehicle.getDepartureDate());
        double total = 0;

        if(time >= startDay && time <= endDay){
            total = rateDay;
        }else if(time > endDay){
            total = rateDay  + ((time - endDay)* rateHour);
        }else{
            total = rateHour * time;
        }
        return total;
    }

    public double calculateExtraPayment(Motorcycle motorcycle){
        double extra = 0;

        if (motorcycle.getCylinder() > MAX_CYLINDER_MOTORCYCLE){
            extra = ADDITIONAL_PRICE_MOTORCYCLE;
        }
        return extra;
    }

    public long calculateTimeInParkingLot(String entryDate,String departureDate){
        long difference = 0;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PAYMENT);
            Date entryDateFormat = dateFormat.parse(entryDate);
            Date departureDateFormat = dateFormat.parse(departureDate);
            difference = Math.abs(entryDateFormat.getTime() - departureDateFormat.getTime());
            difference = difference / TIME_TRANSFORM;
        }catch (ParseException e){
            throw new WrongDateException();
        }
        return difference;
    }
}
