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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.exception.RestPlateException;
import co.com.ceiba.domain.exception.VehicleAlreadyExistsException;
import co.com.ceiba.domain.repository.ParkingLotCarRepository;

public class ParkingLotCarServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private ParkingLotCarRepository parkingLotCarRepository;

    @InjectMocks
    ParkingLotCarService parkingLotCarService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void vehiclePlateRestriction() {
        //Arrange
        String entryDate = ("2021-07-06 7:00");
        String expectedMessage = "La placa ingresada no tiene permitido ingresar este dia";
        Car car = new Car("AGU249",entryDate);

        try {
            //Act
            parkingLotCarService.saveVehicle(car);
            Assert.fail();
        }catch (RestPlateException | ParseException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }
}