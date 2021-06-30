package co.com.ceiba.domain.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;

import static org.junit.Assert.*;

public class PaymentVehicleCarTest {

    ParkingLot parkingLot;
    PaymentVehicleCar paymentVehicleCar;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(1,"San",
                new ParkingInformationRate(1000,8000,500,4000,9,24),
                null,20,10);
        paymentVehicleCar = new PaymentVehicleCar(parkingLot);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = dateFormat.format(new Date());

    }

    @Test
    public void calculatePaymentVehicle() {
        //Arrange
        String entryDate = ("2021-06-28 7:00");
        String departureDate = ("2021-06-29 10:00");
        int startDay = parkingLot.getParkingInformationRate().getHourStartDay();
        int endDay = parkingLot.getParkingInformationRate().getHourEndDay();
        long time = parkingLot.calculateTimeInParkingLot(entryDate,departureDate );
        double totalExpected = 11000;
        //Act
        double total = paymentVehicleCar.calculatePaymentVehicle(time,startDay,endDay);
        //Assert
        Assert.assertEquals(totalExpected,total,3);
    }
}