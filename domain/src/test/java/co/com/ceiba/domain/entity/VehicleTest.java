package co.com.ceiba.domain.entity;

import android.util.Log;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.entity.VehicleType;
import co.com.ceiba.domain.exception.WrongPlateException;
import co.com.ceiba.domain.exception.WrongVehicleInformationException;
import co.com.ceiba.domain.exception.WrongVehicleTypeException;
import co.com.ceiba.domain.valueobject.VehicleInformation;

public class VehicleTest {
    @Test
    public void VehicleCorrectInformation(){
        //Arrange
        String plate = "FGU249";
        VehicleInformation vehicleInformation =  new VehicleInformation(2600);
        VehicleType vehicleType = new VehicleType(1,"moto");

        //Act
        Vehicle vehicle =  new Vehicle(plate,vehicleType,vehicleInformation);
        //Assert
        Assert.assertNotNull(vehicle);
    }

    @Test
    public void VehicleInCorrectPlate(){
        //Arrange
        String plate = "FGU";
        VehicleInformation vehicleInformation =  new VehicleInformation(2600);
        VehicleType vehicleType = new VehicleType(1,"moto");
        String expectedMessage = "La placa ingresada no es valida.";

        //Act
        try {
            Vehicle vehicle =  new Vehicle(plate,vehicleType,vehicleInformation);
            Assert.fail();
        }catch (WrongPlateException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }

    }
    @Test
    public void VehicleInCorrectInformation(){
        //Arrange
        String plate = "FGU249";
        VehicleInformation vehicleInformation =  null;
        VehicleType vehicleType = new VehicleType(1,"moto");
        String expectedMessage = "La información del vehiculo es obligatoria.";

        //Act
        try {
            Vehicle vehicle =  new Vehicle(plate,vehicleType,vehicleInformation);
            Assert.fail();
        }catch (WrongVehicleInformationException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }

    }
    @Test
    public void VehicleTypeInCorrect(){
        //Arrange
        String plate = "FGU249";
        VehicleInformation vehicleInformation =  new VehicleInformation(2600);;
        VehicleType vehicleType = null;
        String expectedMessage = "EL tipo de vehiculo no puede ser nulo.";

        //Act
        try {
            Vehicle vehicle =  new Vehicle(plate,vehicleType,vehicleInformation);
            Assert.fail();
        }catch (WrongVehicleTypeException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }

    }

    @Test
    public void EntryDateCorrect(){
        //Arrange
        String plate = "FGU249";
        VehicleInformation vehicleInformation =  new VehicleInformation(2600);
        VehicleType vehicleType = new VehicleType(1,"moto");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateExpected = dateFormat.format(new Date());

        //Act
        Vehicle vehicle =  new Vehicle(plate,vehicleType,vehicleInformation);
        String entryDate = vehicle.getEntryDate();
        //Assert
        Assert.assertEquals(dateExpected,entryDate);
    }

}