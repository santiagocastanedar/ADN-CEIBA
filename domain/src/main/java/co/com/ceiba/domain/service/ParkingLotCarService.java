package co.com.ceiba.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import co.com.ceiba.domain.entity.Car;
import co.com.ceiba.domain.exception.MaxCapacityException;
import co.com.ceiba.domain.exception.RestPlateException;
import co.com.ceiba.domain.exception.VehicleAlreadyExistsException;
import co.com.ceiba.domain.repository.ParkingLotCarRepository;
import static co.com.ceiba.domain.utils.Constant.DATE_FORMAT_PAYMENT;
import static co.com.ceiba.domain.utils.Constant.MAX_QUANTITY_CAR;
import static co.com.ceiba.domain.utils.Constant.MONDAY_PERMIT;
import static co.com.ceiba.domain.utils.Constant.PLATE_REST;
import static co.com.ceiba.domain.utils.Constant.SUNDAY_PERMIT;

public class ParkingLotCarService {

    private final ParkingLotCarRepository parkingLotCarRepository;
    @Inject
    public ParkingLotCarService(ParkingLotCarRepository parkingLotCarRepository){
        this.parkingLotCarRepository = parkingLotCarRepository;
    }

    public void saveVehicle(Car car) throws ParseException {
        if(parkingLotCarRepository.getCar(car.getPlate()) != null){
            throw new VehicleAlreadyExistsException();
        }
        if(getQuantity() >= MAX_QUANTITY_CAR){
            throw new MaxCapacityException();
        }
        validateEntryPlate(car.getPlate(),car.getEntryDate());
        parkingLotCarRepository.saveVehicle(car);
    }

    public List<Car> getCars(){
        return parkingLotCarRepository.getCars();
    }

    public int getQuantity(){
        return parkingLotCarRepository.getQuantity();
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
