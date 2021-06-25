package co.com.ceiba.domain.valueobject;

import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.domain.exception.WrongCylinderException;
import co.com.ceiba.domain.exception.WrongRateException;

import static org.junit.Assert.*;

public class VehicleInformationTest {


    @Test
    public void VehicleInformationCorrectInformation() {
        //Arrange
        int cylinder = 2600;
        //Act
        VehicleInformation vehicleInformation = new VehicleInformation(cylinder);
        //Assert
        Assert.assertNotNull(vehicleInformation);
    }

    @Test
    public void VehicleInformationInCorrectInformation(){
        //Arrange
        int cylinder = 0;
        String expectedMessage = "El cilindraje del vehiculo es incorrecto.";

        //Act
        try {
            VehicleInformation vehicleInformation = new VehicleInformation(cylinder);
            Assert.fail();
        }catch (WrongCylinderException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }

    }
}