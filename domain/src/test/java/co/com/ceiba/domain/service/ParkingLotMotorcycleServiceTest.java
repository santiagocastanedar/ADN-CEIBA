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

import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.exception.RestPlateException;
import co.com.ceiba.domain.repository.ParkingLotMotorcycleRepository;

import static org.junit.Assert.*;

public class ParkingLotMotorcycleServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private ParkingLotMotorcycleRepository parkingLotMotorcycleRepository;

    @InjectMocks
    ParkingLotMotorcycleService parkingLotMotorcycleService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void vehiclePlateRestriction_startWithA_Exception() {
        //Arrange
        String entryDate = ("2021-07-06 7:00");
        String expectedMessage = "La placa ingresada no tiene permitido ingresar este dia";
        Motorcycle motorcycle = new Motorcycle("AGU249",entryDate,750);

        try {
            //Act
            parkingLotMotorcycleService.saveMotorcycle(motorcycle);
            Assert.fail();
        }catch (RestPlateException | ParseException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }
}