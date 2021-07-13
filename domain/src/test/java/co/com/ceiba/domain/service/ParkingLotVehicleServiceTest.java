package co.com.ceiba.domain.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.text.ParseException;

import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.exception.RestPlateException;
import co.com.ceiba.domain.repository.ParkingLotVehicleRepository;

public class ParkingLotVehicleServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private ParkingLotVehicleRepository parkingLotVehicleRepository;

    @InjectMocks
    ParkingLotVehicleService parkingLotVehicleService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    /*@Test
    public void vehiclePlateRestriction_startWithA_Exception() {
        //Arrange
        String entryDate = ("2021-07-06 7:00");
        String expectedMessage = "La placa ingresada no tiene permitido ingresar este dia";
        Car car = new Car("AGU249",entryDate);

        try {
            //Act
            parkingLotVehicleService.saveVehicle(car);
            Assert.fail();
        }catch (RestPlateException | ParseException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }*/
}