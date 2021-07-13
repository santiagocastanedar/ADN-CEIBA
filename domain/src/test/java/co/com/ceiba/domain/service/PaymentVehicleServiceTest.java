package co.com.ceiba.domain.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.exception.WrongDateException;
import co.com.ceiba.domain.service.PaymentVehicleService;

import static co.com.ceiba.domain.utils.Constant.RATE_CAR_PER_DAY;
import static co.com.ceiba.domain.utils.Constant.RATE_CAR_PER_HOUR;
import static co.com.ceiba.domain.utils.Constant.RATE_MOTORCYCLE_PER_DAY;
import static co.com.ceiba.domain.utils.Constant.RATE_MOTORCYCLE_PER_HOUR;


public class PaymentVehicleServiceTest {

    PaymentVehicleService paymentVehicleService;
    String entryDate = ("2021-06-28 7:00");
    Car car = new Car("FGU259",entryDate);
    Motorcycle motorcycle = new Motorcycle("FGU249",entryDate,650);
    double rateHourCar = RATE_CAR_PER_HOUR;
    double rateDayCar = RATE_CAR_PER_DAY;
    double rateDayMotorcycle = RATE_MOTORCYCLE_PER_DAY;
    double rateHourMotorcycle = RATE_MOTORCYCLE_PER_HOUR;
    
    @Before
    public void setUp() throws Exception {
        paymentVehicleService = new PaymentVehicleService();
    }

    @Test
    public void calculatePaymentCar_MoreOneDay_true() {
        //Arrange
        car.setDepartureDate("2021-06-29 10:00");
        double totalPaymentExpected = 11000;
        //Act
        double totalPayment = paymentVehicleService.calculatePaymentVehicle(car,rateHourCar,rateDayCar);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculatePaymentCar_OneDay_true() {
        //Arrange
        car.setDepartureDate("2021-06-29 5:00");
        double totalPaymentExpected = 8000;
        //Act
        double totalPayment = paymentVehicleService.calculatePaymentVehicle(car,rateHourCar,rateDayCar);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculatePaymentCar_Hours_true() {
        //Arrange
        car.setDepartureDate("2021-06-28 10:00");
        double totalPaymentExpected = 3000;
        //Act
        double totalPayment = paymentVehicleService.calculatePaymentVehicle(car,rateHourCar,rateDayCar);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculatePaymentMotorcycle_MoreOneDay_true() {
        //Arrange
        motorcycle.setDepartureDate("2021-06-29 10:00");
        double totalPaymentExpected = 5500;
        //Act
        double totalPayment = paymentVehicleService.calculatePaymentVehicle(motorcycle,rateHourMotorcycle,rateDayMotorcycle);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculatePaymentMotorcycle_OneDay_true() {
        //Arrange
        motorcycle.setDepartureDate("2021-06-29 5:00");
        double totalPaymentExpected = 4000;
        //Act
        double totalPayment = paymentVehicleService.calculatePaymentVehicle(motorcycle,rateHourMotorcycle,rateDayMotorcycle);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculatePaymentMotorcylce_Hours_true() {
        //Arrange
        motorcycle.setDepartureDate("2021-06-28 10:00");
        double totalPaymentExpected = 1500;
        //Act
        double totalPayment = paymentVehicleService.calculatePaymentVehicle(motorcycle,rateHourMotorcycle,rateDayMotorcycle);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculateExtraPayment() {
        //Arrange
        double extraPaymentExpected = 2000;
        //Act
        double extraPayment = paymentVehicleService.calculateExtraPayment(motorcycle);
        //Assert
        Assert.assertEquals(extraPaymentExpected,extraPayment,3);
    }

    @Test
    public void calculateNotExtraPayment() {
        //Arrange
        double extraPaymentExpected = 0;
        motorcycle.setCylinder(200);
        //Act
        double extraPayment = paymentVehicleService.calculateExtraPayment(motorcycle);
        //Assert
        Assert.assertEquals(extraPaymentExpected,extraPayment,3);
    }

    @Test
    public void calculateTimeInParkingLot_correctDate_true() {
        //Arrange
        String departureDate = ("2021-06-29 10:00");
        long timeExcpected = 27;
        //Act
        long time = paymentVehicleService.calculateTimeInParkingLot(entryDate,departureDate);
        //Assert
        Assert.assertEquals(timeExcpected,time);
    }

    @Test
    public void calculateTimeInParkingLot_WrongDate_Exception() {
        //Arrange
        String entryDate = ("");
        String departureDate = ("");
        String expectedMessage = "La fecha de entrada o de salida son incorrectas.";
        //Act
        try {
            long time = paymentVehicleService.calculateTimeInParkingLot(entryDate,departureDate);
            Assert.fail();
        }catch (WrongDateException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }
}