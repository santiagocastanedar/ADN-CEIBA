package co.com.ceiba.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Motorcycle;
import co.com.ceiba.domain.exception.MaxCapacityException;
import co.com.ceiba.domain.exception.RestPlateException;
import co.com.ceiba.domain.exception.VehicleAlreadyExistsException;
import co.com.ceiba.domain.repository.ParkingLotMotorcycleRepository;

import static co.com.ceiba.domain.utils.Constant.DATE_FORMAT_PAYMENT;
import static co.com.ceiba.domain.utils.Constant.MAX_QUANTITY_MOTORCYCLE;
import static co.com.ceiba.domain.utils.Constant.MONDAY_PERMIT;
import static co.com.ceiba.domain.utils.Constant.PLATE_REST;
import static co.com.ceiba.domain.utils.Constant.SUNDAY_PERMIT;

public class ParkingLotMotorcycleService {

    private final ParkingLotMotorcycleRepository motorcycleRepository;

    @Inject
    public ParkingLotMotorcycleService(ParkingLotMotorcycleRepository parkingLotMotorcycleRepository){
        this.motorcycleRepository = parkingLotMotorcycleRepository;
    }

    public void saveMotorcycle(Motorcycle motorcycle){
        if(motorcycleRepository.motorcycleExist(motorcycle.getPlate()) != null){
            throw new VehicleAlreadyExistsException();
        }
        if(getQuiantity() >= MAX_QUANTITY_MOTORCYCLE){
            throw new MaxCapacityException();
        }
        validateEntryPlate(motorcycle.getPlate(),motorcycle.getEntryDate());
        motorcycleRepository.saveMotorcycle(motorcycle);
    }

    public List<Motorcycle> getMotorcycles(){
        return motorcycleRepository.getMotorcycle();
    }

    public int getQuiantity(){
        return motorcycleRepository.getQuantity();
    }

    private void validateEntryPlate(String plate, String entryDate){
        Date date;
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_PAYMENT);

        try {
            date = (Date)formatter.parse(entryDate);
            if(date.getDay() != SUNDAY_PERMIT && date.getDay() != MONDAY_PERMIT && plate.startsWith(PLATE_REST)){
                throw new RestPlateException();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
