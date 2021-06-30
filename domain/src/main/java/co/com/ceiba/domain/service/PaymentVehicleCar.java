package co.com.ceiba.domain.service;

import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.repository.VehiclePaymentRepository;

public class PaymentVehicleCar implements VehiclePaymentRepository {

    private final ParkingLot parkingLot;

    public PaymentVehicleCar(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    @Override
    public double calculatePaymentVehicle(long time, int startDay, int endDay) {
        double total = 0;

        if(time >= startDay && time <= endDay){
            total = parkingLot.getParkingInformationRate().getRateCarPerDay();
        }else if(time > endDay){
            total = parkingLot.getParkingInformationRate().getRateCarPerDay() + ((time - endDay)*parkingLot.getParkingInformationRate().getRateCarPerHour());
        }else{
            total = parkingLot.getParkingInformationRate().getRateCarPerHour() * time;
        }
        return total;
    }
}
