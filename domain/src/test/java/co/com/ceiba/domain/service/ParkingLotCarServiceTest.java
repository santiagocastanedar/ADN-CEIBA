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

import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.domain.entity.Car;
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

    /*@Test
    public void vehicleAlreadyExistInParkingLot() {
        //Arrange
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = dateFormat.format(new Date());
        String expectedMessage = "El vehiculo ya se encuentra parqueado";
        Car car = new Car("FGU249",date);

        try {
            //Act
            parkingLotCarService.saveVehicle(car);
            Assert.fail();
        }catch (VehicleAlreadyExistsException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }*/




}