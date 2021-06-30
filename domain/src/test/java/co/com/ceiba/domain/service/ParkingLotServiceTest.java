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
import co.com.ceiba.domain.repository.ParkingLotRepository;

public class ParkingLotServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private ParkingLotRepository parkingLotRepository;

    @InjectMocks
    ParkingLotService parkingLotService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void vehicleAlreadyExistInParkingLot() {
        //Arrange
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = dateFormat.format(new Date());
        String expectedMessage = "El vehiculo ya se encuentra parqueado";
        Car car = new Car("FGU249",date);

        try {
            //Act
            parkingLotService.saveVehicle(car);
            Assert.fail();
        }catch (VehicleAlreadyExistsException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }

    /*@Test
    public void calculateTimeInParkingLot() {
        //Arrange
        long timeExpected = 5;
        String entryDate = ("2021-06-28 11:00");
        String departureDate = ("2021-06-28 16:00");
        //Act
        long time = parkingLotService.calculateTimeInParkingLot(entryDate,departureDate);
        //Assert
        Assert.assertEquals(timeExpected,time);
    }

    @Test
    public void calculateTimeInParkingLotIncorrectDate() {
        //Arrange
        String entryDate = "";
        String departureDate = "";
        String expectedMessage = "La fecha de entrada o de salida son incorrectas.";

        try {
            //Act
            long time = parkingLotService.calculateTimeInParkingLot(entryDate,departureDate);
            Assert.fail();
        }catch (DateException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }*/


    /*@Test
    public void calculatePaymentCarPerDay() {
        //Arrange
        String entryDate = ("2021-06-28 7:00");
        String departureDate = ("2021-06-29 10:00");
        long time = parkingLotService.calculateTimeInParkingLot(entryDate,departureDate);
        int startDay = parkingLot.getParkingInformationRate().getHourStartDay();
        int endtDay = parkingLot.getParkingInformationRate().getHourEndDay();
        long totalExpected = 11000;
        //Act
        double total = parkingLotService.calculatePaymentCar(time,startDay,endtDay);
        //Assert
        Assert.assertEquals(totalExpected,total);
    }*/


}