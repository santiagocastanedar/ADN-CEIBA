package co.com.ceiba.domain.other;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.exception.WrongDateException;

import static co.com.ceiba.domain.utils.Constant.RATE_CAR_PER_DAY;
import static co.com.ceiba.domain.utils.Constant.RATE_CAR_PER_HOUR;
import static co.com.ceiba.domain.utils.Constant.RATE_MOTORCYCLE_PER_DAY;
import static co.com.ceiba.domain.utils.Constant.RATE_MOTORCYCLE_PER_HOUR;


public class PaymentVehicleTest {

    PaymentVehicle paymentVehicle;
    String entryDate = ("2021-06-28 7:00");
    Car car = new Car("FGU259",entryDate);
    Motorcycle motorcycle = new Motorcycle("FGU249",entryDate,650);
    double rateHourCar = RATE_CAR_PER_HOUR;
    double rateDayCar = RATE_CAR_PER_DAY;
    double rateDayMotorcycle = RATE_MOTORCYCLE_PER_DAY;
    double rateHourMotorcycle = RATE_MOTORCYCLE_PER_HOUR;


    @Before
    public void setUp() throws Exception {
        paymentVehicle = new PaymentVehicle();
    }

    @Test
    public void calculatePaymentCarMoreOneDay() {
        //Arrange
        car.setDepartureDate("2021-06-29 10:00");
        double totalPaymentExpected = 11000;
        //Act
        double totalPayment = paymentVehicle.calculatePaymentVehicle(car,rateHourCar,rateDayCar);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculatePaymentCarOneDay() {
        //Arrange
        car.setDepartureDate("2021-06-29 5:00");
        double totalPaymentExpected = 8000;
        //Act
        double totalPayment = paymentVehicle.calculatePaymentVehicle(car,rateHourCar,rateDayCar);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculatePaymentCarHours() {
        //Arrange
        car.setDepartureDate("2021-06-28 10:00");
        double totalPaymentExpected = 3000;
        //Act
        double totalPayment = paymentVehicle.calculatePaymentVehicle(car,rateHourCar,rateDayCar);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculatePaymentMotorcycleMoreOneDay() {
        //Arrange
        motorcycle.setDepartureDate("2021-06-29 10:00");
        double totalPaymentExpected = 5500;
        //Act
        double totalPayment = paymentVehicle.calculatePaymentVehicle(motorcycle,rateHourMotorcycle,rateDayMotorcycle);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculatePaymentMotorcycleOneDay() {
        //Arrange
        motorcycle.setDepartureDate("2021-06-29 5:00");
        double totalPaymentExpected = 4000;
        //Act
        double totalPayment = paymentVehicle.calculatePaymentVehicle(motorcycle,rateHourMotorcycle,rateDayMotorcycle);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculatePaymentMotorcylceHours() {
        //Arrange
        motorcycle.setDepartureDate("2021-06-28 10:00");
        double totalPaymentExpected = 1500;
        //Act
        double totalPayment = paymentVehicle.calculatePaymentVehicle(motorcycle,rateHourMotorcycle,rateDayMotorcycle);
        //Assert
        Assert.assertEquals(totalPaymentExpected,totalPayment,3);
    }

    @Test
    public void calculateExtraPayment() {
        //Arrange
        double extraPaymentExpected = 2000;
        //Act
        double extraPayment = paymentVehicle.calculateExtraPayment(motorcycle);
        //Assert
        Assert.assertEquals(extraPaymentExpected,extraPayment,3);
    }

    @Test
    public void calculateNotExtraPayment() {
        //Arrange
        double extraPaymentExpected = 0;
        motorcycle.setCylinder(200);
        //Act
        double extraPayment = paymentVehicle.calculateExtraPayment(motorcycle);
        //Assert
        Assert.assertEquals(extraPaymentExpected,extraPayment,3);
    }

    @Test
    public void calculateTimeInParkingLot() {
        //Arrange
        String departureDate = ("2021-06-29 10:00");
        long timeExcpected = 27;
        //Act
        long time = paymentVehicle.calculateTimeInParkingLot(entryDate,departureDate);
        //Assert
        Assert.assertEquals(timeExcpected,time);
    }

    @Test
    public void calculateTimeInParkingLotWrongDate() {
        //Arrange
        String entryDate = ("");
        String departureDate = ("");
        String expectedMessage = "La fecha de entrada o de salida son incorrectas.";
        //Act
        try {
            long time = paymentVehicle.calculateTimeInParkingLot(entryDate,departureDate);
            Assert.fail();
        }catch (WrongDateException ex){
            //Assert
            Assert.assertEquals(expectedMessage,ex.getMessage());
        }
    }
}