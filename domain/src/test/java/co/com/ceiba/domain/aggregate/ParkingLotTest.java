package co.com.ceiba.domain.aggregate;

import org.junit.Assert;
import org.junit.Test;

import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.exception.ParkingInformationException;
import co.com.ceiba.domain.valueobject.ParkingInformationRate;

public class ParkingLotTest {

    @Test
    public void parkingLot_createWithCorrectRateInformation(){
        //Arrange
        int id = 1;
        String name = "Parqueadero Santiago's";
        //Act
        ParkingInformationRate parkingInformationRate = new ParkingInformationRate(1000,8000,500,4000,9,24);
        ParkingLot parkingLotExpected =  new ParkingLot(id,name,parkingInformationRate,null,0,0);

        //Assert
        Assert.assertNotNull(parkingLotExpected);
    }

    @Test
    public void parkingLot_createWithInCorrectRateInformation(){
        //Arrange
        int id = 0;
        String name = "";
        String expectedMessage = "La informacion de las tarifas es obligatoria.";

        //Act
        try {
            ParkingLot parkingLotExpected =  new ParkingLot(id,name,null,null,0,0);
            Assert.fail();
        }catch (ParkingInformationException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }

    }
}