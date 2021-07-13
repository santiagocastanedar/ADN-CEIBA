package co.com.ceiba.domain.service;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MotorcycleCapacityServideImplTest {

    MotorcycleCapacityServideImpl motorcycleCapacityServide = new MotorcycleCapacityServideImpl();

    @Test
    public void motorcycleCapacity_correctCapacity_false() {
        //Arrange
        int quantityOfCars = 5;
        //Act
        boolean response = motorcycleCapacityServide.validateCapacity(quantityOfCars);
        //Assert
        Assert.assertFalse(response);
    }

    @Test
    public void motorcycle_incorrectCapacity_true() {
        //Arrange
        int quantityOfCars = 15;
        //Act
        boolean response = motorcycleCapacityServide.validateCapacity(quantityOfCars);
        //Assert
        Assert.assertTrue(response);
    }
}