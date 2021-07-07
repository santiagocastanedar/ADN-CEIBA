package co.com.ceiba.domain.entity;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.exception.WrongCylinderException;
import co.com.ceiba.domain.exception.WrongPlateException;

import static org.junit.Assert.*;

public class MotorcycleTest {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String date = dateFormat.format(new Date());
    @Test
    public void setCylinder_incorrectCylinder_Exception() {
        //Arrange

        String plate = "FGU249";
        String expectedMessage = "El cilindraje del vehiculo es incorrecto.";

        //Act
        try {
            Vehicle motorcycle =  new Motorcycle(plate,date,0);
            Assert.fail();
        }catch (WrongCylinderException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }
    @Test
    public void setCylinder_correctCylinder_true() {
        //Arrange
        String plate = "FGU249";

        //Act
        Vehicle motorcycle =  new Motorcycle(plate,date,650);
        //Assert
        Assert.assertNotNull(motorcycle);

    }
}