package co.com.ceiba.application.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.service.PaymentVehicleService;

import static co.com.ceiba.domain.utils.Constant.CAR;
import static co.com.ceiba.domain.utils.Constant.DATE_FORMAT_PAYMENT;
import static co.com.ceiba.domain.utils.Constant.RATE_CAR_PER_DAY;
import static co.com.ceiba.domain.utils.Constant.RATE_CAR_PER_HOUR;
import static co.com.ceiba.domain.utils.Constant.RATE_MOTORCYCLE_PER_DAY;
import static co.com.ceiba.domain.utils.Constant.RATE_MOTORCYCLE_PER_HOUR;

public class PaymentAplication {

    private PaymentVehicleService paymentVehicleService = new PaymentVehicleService();

    public PaymentAplication(){
    }

    public double calculatePayment(Vehicle vehicle){
        double total = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PAYMENT);
        String departureDate = dateFormat.format(new Date());
        vehicle.setDepartureDate(departureDate);
        if (vehicle.getType() == CAR){
            total = paymentVehicleService.calculatePaymentVehicle(vehicle,RATE_CAR_PER_HOUR,RATE_CAR_PER_DAY);
        }else{
            Motorcycle motorcycle = (Motorcycle) vehicle;
            total = paymentVehicleService.calculatePaymentVehicle(motorcycle,RATE_MOTORCYCLE_PER_HOUR,RATE_MOTORCYCLE_PER_DAY) +
                    paymentVehicleService.calculateExtraPayment(motorcycle);
        }
        return total;
    }
}
