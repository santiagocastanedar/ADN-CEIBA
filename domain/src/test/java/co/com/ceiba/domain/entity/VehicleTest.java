package co.com.ceiba.domain.entity;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.exception.WrongDateException;
import co.com.ceiba.domain.exception.WrongPlateException;

import static co.com.ceiba.domain.utils.Constant.CAR;
import static co.com.ceiba.domain.utils.Constant.DATE_FORMAT_PAYMENT;
import static co.com.ceiba.domain.utils.Constant.MOTORCYCLE;

public class VehicleTest {
    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PAYMENT);
    String date = dateFormat.format(new Date());

    @Test
    public void saveVehicle_CorrectInformation_true(){
        //Arrange
        String plate = "FGU249";
        //Act
        Vehicle vehicle =  new Vehicle(plate,date,"carro");
        //Assert
        Assert.assertNotNull(vehicle);
    }

    @Test
    public void saveVehicle_InCorrectPlate_Exception(){
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
    public void setEntryDate_Correct_true(){
        //Arrange
        String plate = "FGU249";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PAYMENT);
        String dateExpected = dateFormat.format(new Date());

        //Act
        Vehicle vehicle =  new Vehicle(plate,date,"moto");
        String entryDate = vehicle.getEntryDate();
        //Assert
        Assert.assertEquals(dateExpected,entryDate);
    }

    @Test
    public void setEntryDate_InCorrect_Exception(){
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

    @Test
    public void getTypeCar_correctType_true(){
        //Arrange
        String plate = "FGU249";
        String typeExpected = CAR;

        //Act
        Car car =  new Car(plate,date);
        String type = car.getType();
        //Assert
        Assert.assertEquals(typeExpected,type);
    }

    @Test
    public void getTypeMotorcycle_correctType_true(){
        //Arrange
        String plate = "FGU249";
        String typeExpected = MOTORCYCLE;

        //Act
        Motorcycle motorcycle =  new Motorcycle(plate,date,200);
        String type = motorcycle.getType();
        //Assert
        Assert.assertEquals(typeExpected,type);
    }
}