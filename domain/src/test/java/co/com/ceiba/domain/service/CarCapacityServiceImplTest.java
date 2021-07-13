package co.com.ceiba.domain.service;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarCapacityServiceImplTest {

    CarCapacityServiceImpl carCapacityService = new CarCapacityServiceImpl();

    @Test
    public void carCapacity_correctCapacity_false() {
        //Arrange
        int quantityOfCars = 15;
        //Act
        boolean response = carCapacityService.validateCapacity(quantityOfCars);
        //Assert
        Assert.assertFalse(response);
    }

    @Test
    public void carCapacity_incorrectCapacity_true() {
        //Arrange
        int quantityOfCars = 25;
        //Act
        boolean response = carCapacityService.validateCapacity(quantityOfCars);
        //Assert
        Assert.assertTrue(response);
    }
}