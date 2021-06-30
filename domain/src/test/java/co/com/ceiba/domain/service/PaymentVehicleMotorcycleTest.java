package co.com.ceiba.domain.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;

import static org.junit.Assert.*;

public class PaymentVehicleMotorcycleTest {
    ParkingLot parkingLot;
    PaymentVehicleMotorcycle paymentVehicleMotorcycle;
    Motorcycle motorcycle;
    String entryDate = ("2021-06-28 16:00");


    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(1,"San",
                new ParkingInformationRate(1000,8000,500,4000,9,24),
                null,20,10);

    }

    @Test
    public void calculatePaymentVehicleCylinder() {
        //Arrange
        motorcycle = new Motorcycle("FGU249",entryDate,650);
        paymentVehicleMotorcycle = new PaymentVehicleMotorcycle(parkingLot,motorcycle);
        String departureDate = ("2021-06-29 2:00");
        int startDay = parkingLot.getParkingInformationRate().getHourStartDay();
        int endDay = parkingLot.getParkingInformationRate().getHourEndDay();
        long time = parkingLot.calculateTimeInParkingLot(motorcycle.getEntryDate(),departureDate );
        double totalExpected = 6000;
        //Act
        double total = paymentVehicleMotorcycle.calculatePaymentVehicle(time,startDay,endDay);
        //Assert
        Assert.assertEquals(totalExpected,total,3);
    }

    @Test
    public void calculatePaymentVehicle() {
        //Arrange
        motorcycle = new Motorcycle("FGU249",entryDate,400);
        paymentVehicleMotorcycle = new PaymentVehicleMotorcycle(parkingLot,motorcycle);
        String departureDate = ("2021-06-29 17:00");
        int startDay = parkingLot.getParkingInformationRate().getHourStartDay();
        int endDay = parkingLot.getParkingInformationRate().getHourEndDay();
        long time = parkingLot.calculateTimeInParkingLot(motorcycle.getEntryDate(),departureDate );
        double totalExpected = 4500;
        //Act
        double total = paymentVehicleMotorcycle.calculatePaymentVehicle(time,startDay,endDay);
        //Assert
        Assert.assertEquals(totalExpected,total,3);
    }

    @Test
    public void calculatePaymentVehicleDay() {
        //Arrange
        motorcycle = new Motorcycle("FGU249",entryDate,400);
        paymentVehicleMotorcycle = new PaymentVehicleMotorcycle(parkingLot,motorcycle);
        String departureDate = ("2021-06-29 15:00");
        int startDay = parkingLot.getParkingInformationRate().getHourStartDay();
        int endDay = parkingLot.getParkingInformationRate().getHourEndDay();
        long time = parkingLot.calculateTimeInParkingLot(motorcycle.getEntryDate(),departureDate );
        double totalExpected = 4000;
        //Act
        double total = paymentVehicleMotorcycle.calculatePaymentVehicle(time,startDay,endDay);
        //Assert
        Assert.assertEquals(totalExpected,total,3);
    }
    @Test
    public void calculatePaymentVehicleHour() {
        //Arrange
        motorcycle = new Motorcycle("FGU249",entryDate,400);
        paymentVehicleMotorcycle = new PaymentVehicleMotorcycle(parkingLot,motorcycle);
        String departureDate = ("2021-06-28 17:00");
        int startDay = parkingLot.getParkingInformationRate().getHourStartDay();
        int endDay = parkingLot.getParkingInformationRate().getHourEndDay();
        long time = parkingLot.calculateTimeInParkingLot(motorcycle.getEntryDate(),departureDate );
        double totalExpected = 500;
        //Act
        double total = paymentVehicleMotorcycle.calculatePaymentVehicle(time,startDay,endDay);
        //Assert
        Assert.assertEquals(totalExpected,total,3);
    }
}