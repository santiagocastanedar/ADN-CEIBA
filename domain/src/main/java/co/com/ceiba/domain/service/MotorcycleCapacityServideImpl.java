package co.com.ceiba.domain.service;

import static co.com.ceiba.domain.utils.Constant.MAX_QUANTITY_MOTORCYCLE;

public class MotorcycleCapacityServideImpl implements VehicleCapacityService{
    @Override
    public boolean validateCapacity(int vehicleQuantity) {
        if(vehicleQuantity >= MAX_QUANTITY_MOTORCYCLE){
            return true;
        }else{
            return false;
        }
    }
}
