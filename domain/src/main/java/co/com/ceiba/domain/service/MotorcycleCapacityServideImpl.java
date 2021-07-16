package co.com.ceiba.domain.service;

import static co.com.ceiba.domain.utils.Constant.MAX_QUANTITY_MOTORCYCLE;

public class MotorcycleCapacityServideImpl implements VehicleCapacityService{
    @Override
    public boolean validateCapacity(int vehicleQuantity) {
        return vehicleQuantity >= MAX_QUANTITY_MOTORCYCLE;
    }
}
