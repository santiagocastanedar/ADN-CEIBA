package co.com.ceiba.domain.service;

import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.repository.VehiclePaymentRepository;

import static co.com.ceiba.domain.utils.Constant.ADDITIONAL_PRICE_MOTORCYCLE;
import static co.com.ceiba.domain.utils.Constant.MAX_CYLINDER_MOTORCYCLE;

public class PaymentVehicleMotorcycle implements VehiclePaymentRepository {

    private ParkingLot parkingLot;
    private Motorcycle motorcycle;
    public PaymentVehicleMotorcycle(ParkingLot parkingLot,Motorcycle motorcycle){
        this.parkingLot = parkingLot;
        this.motorcycle = motorcycle;
    }

    @Override
    public double calculatePaymentVehicle(long time, int startDay, int endDay) {
        double total = 0;


        if(time >= startDay && time <= endDay){
            total = parkingLot.getParkingInformationRate().getRateMotorcyclePerDay();
        }else if(time > endDay){
            total = parkingLot.getParkingInformationRate().getRateMotorcyclePerDay() + ((time - endDay)*parkingLot.getParkingInformationRate().getRateMotorcyclePerHour());
        }else{
            total = parkingLot.getParkingInformationRate().getRateMotorcyclePerHour() * time;
        }
        if(motorcycle.getCylinder() > MAX_CYLINDER_MOTORCYCLE){
            total += ADDITIONAL_PRICE_MOTORCYCLE;
        }
        return total;
    }
}
