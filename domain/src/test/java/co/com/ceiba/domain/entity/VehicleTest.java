package co.com.ceiba.domain.entity;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.exception.WrongDateException;
import co.com.ceiba.domain.exception.WrongPlateException;

public class VehicleTest {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String date = dateFormat.format(new Date());

    @Test
    public void VehicleCorrectInformation(){
        //Arrange
        String plate = "FGU249";
        //Act
        Vehicle vehicle =  new Vehicle(plate,date,"carro");
        //Assert
        Assert.assertNotNull(vehicle);
    }

    @Test
    public void VehicleInCorrectPlate(){
        //Arrange
        String plate = "FGU";
        String expectedMessage = "La placa ingresada no es valida.";

        //Act
        try {
            Vehicle vehicle =  new Vehicle(plate,date,"moto");
            Assert.fail();
        }catch (WrongPlateException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }

    }
    @Test
    public void EntryDateCorrect(){
        //Arrange
        String plate = "FGU249";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateExpected = dateFormat.format(new Date());

        //Act
        Vehicle vehicle =  new Vehicle(plate,date,"moto");
        String entryDate = vehicle.getEntryDate();
        //Assert
        Assert.assertEquals(dateExpected,entryDate);
    }

    @Test
    public void EntryDateInCorrect(){
        //Arrange
        String plate = "FGU249";
        String expectedMessage = "La fecha de entrada o de salida son incorrectas.";
        //Act
        try {
            Vehicle vehicle =  new Vehicle(plate,"","carro");
            Assert.fail();
        }catch (WrongDateException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }

}