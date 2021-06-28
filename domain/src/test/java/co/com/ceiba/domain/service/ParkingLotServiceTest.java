package co.com.ceiba.domain.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.entity.VehicleType;
import co.com.ceiba.domain.exception.DateException;
import co.com.ceiba.domain.exception.WrongVehicleTypeException;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;
import co.com.ceiba.domain.valueobject.VehicleInformation;

import static org.junit.Assert.*;

public class ParkingLotServiceTest {

    ParkingLot parkingLot = new ParkingLot(1,
            "Santiago's",
            new ParkingInformationRate(1000,
                    8000,
                    500,
                    4000,
                    9,
                    24),
            null,
            20,
            10);

    ParkingLotService parkingLotService = new ParkingLotService();



    @Test
    public void calculateTimeInParkingLot() {
        //Arrange
        long timeExpected = 5;
        String entryDate = ("2021-06-28 11:00");
        String departureDate = ("2021-06-28 16:00");
        //Act
        long time = parkingLotService.calculateTimeInParkingLot(entryDate,departureDate);
        //Assert
        Assert.assertEquals(timeExpected,time);
    }

    @Test
    public void calculateTimeInParkingLotIncorrectDate() {
        //Arrange
        String entryDate = "";
        String departureDate = "";
        String expectedMessage = "La fecha de entrada o de salida son incorrectas.";

        try {
            //Act
            long time = parkingLotService.calculateTimeInParkingLot(entryDate,departureDate);
            Assert.fail();
        }catch (DateException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }

    /*@Test
    public void calculatePaymentCarPerDay() {
        //Arrange
        String entryDate = ("2021-06-28 7:00");
        String departureDate = ("2021-06-29 10:00");
        long time = parkingLotService.calculateTimeInParkingLot(entryDate,departureDate);
        int startDay = parkingLot.getParkingInformationRate().getHourStartDay();
        int endtDay = parkingLot.getParkingInformationRate().getHourEndDay();
        long totalExpected = 11000;
        //Act
        double total = parkingLotService.calculatePaymentCar(time,startDay,endtDay);
        //Assert
        Assert.assertEquals(totalExpected,total);
    }*/


}