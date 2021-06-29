package co.com.ceiba.dataaccess.anticorruption;

import co.com.ceiba.dataaccess.entity.ParkingLotRoom;
import co.com.ceiba.domain.aggregate.ParkingLot;

public class ParkingLotMapper {

    public ParkingLotRoom parkingLotMapper(ParkingLot parkingLot) {
        return new ParkingLotRoom(parkingLot.getName(),
                parkingLot.getMaxQuantityCar(),
                parkingLot.getMaxQuantityMotorcycle(),
                parkingLot.getParkingInformationRate().getRateCarPerHour(),
                parkingLot.getParkingInformationRate().getRateCarPerDay(),
                parkingLot.getParkingInformationRate().getRateMotorcyclePerHour(),
                parkingLot.getParkingInformationRate().getRateMotorcyclePerDay(),
                parkingLot.getParkingInformationRate().getHourStartDay(),
                parkingLot.getParkingInformationRate().getHourEndDay());
    }

}
