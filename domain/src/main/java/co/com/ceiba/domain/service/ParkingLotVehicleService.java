package co.com.ceiba.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;

import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.exception.MaxCapacityException;
import co.com.ceiba.domain.exception.RestPlateException;
import co.com.ceiba.domain.exception.VehicleAlreadyExistsException;
import co.com.ceiba.domain.repository.ParkingLotVehicleRepository;
import static co.com.ceiba.domain.utils.Constant.DATE_FORMAT_PAYMENT;
import static co.com.ceiba.domain.utils.Constant.MONDAY_PERMIT;
import static co.com.ceiba.domain.utils.Constant.PLATE_REST;
import static co.com.ceiba.domain.utils.Constant.SUNDAY_PERMIT;

public class ParkingLotVehicleService {

    private final ParkingLotVehicleRepository parkingLotVehicleRepository;
    private final VehicleCapacityService vehicleCapacityService;

    @Inject
    public ParkingLotVehicleService(ParkingLotVehicleRepository parkingLotVehicleRepository,VehicleCapacityService vehicleCapacityService){
        this.parkingLotVehicleRepository = parkingLotVehicleRepository;
        this.vehicleCapacityService = vehicleCapacityService;
    }

    public void saveVehicle(Vehicle vehicle) throws ParseException {
        if(1!=1){
            throw new VehicleAlreadyExistsException();
        }
        if(vehicleCapacityService.validateCapacity(getQuantity())){
            throw new MaxCapacityException();
        }
        validateEntryPlate(vehicle.getPlate(),vehicle.getEntryDate());
        parkingLotVehicleRepository.saveVehicle(vehicle);
    }

    public List<Vehicle> getVehicles(){
        return parkingLotVehicleRepository.getVehicles();
    }

    public int getQuantity(){
        return parkingLotVehicleRepository.getQuantity();
    }

    private void validateEntryPlate(String plate, String entryDate) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        int dayOfweek;
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PAYMENT);

        calendar.setTime(formatter.parse(entryDate));
        dayOfweek = calendar.get(Calendar.DAY_OF_WEEK);
        if(dayOfweek != SUNDAY_PERMIT && dayOfweek != MONDAY_PERMIT && plate.startsWith(PLATE_REST)){
            throw new RestPlateException();
        }
    }
}
