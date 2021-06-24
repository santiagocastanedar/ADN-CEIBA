package co.com.ceiba.domain.valueobject;

import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.domain.exception.WrongRateException;

import static org.junit.Assert.*;

public class ParkingInformationRateTest {

    @Test
    public void parkingInformationCorrect(){
        //Arrange
        double rateCarPerHour = 1000;
        double rateCarPerDay = 8000;
        double rateMotorcyclePerHour = 500;
        double rateMotorcyclePerDay = 4000;
        int startDay = 9;
        int endDay = 24;

        //Act
        ParkingInformationRate informationRateExpected = new ParkingInformationRate(rateCarPerHour,rateCarPerDay,rateMotorcyclePerHour,rateMotorcyclePerDay,startDay,endDay);

        //Assert
        Assert.assertNotNull(informationRateExpected);

    }

    @Test
    public void rateInformationInCorrect(){
        //Arrange
        double rateCarPerHour = 0;
        double rateCarPerDay = 0;
        double rateMotorcyclePerHour = 0;
        double rateMotorcyclePerDay = 0;
        int startDay = 1;
        int endDay = 24;
        String expectedMessage = "La tarifa es invalida.";

        //Act
        try {
            ParkingInformationRate informationRateExpected = new ParkingInformationRate(rateCarPerHour,rateCarPerDay,rateMotorcyclePerHour,rateMotorcyclePerDay,startDay,endDay);
            Assert.fail();
        }catch (WrongRateException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }

    }

}