package co.com.ceiba.domain.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import co.com.ceiba.domain.entity.Vehicle;
import co.com.ceiba.domain.aggregate.ParkingLot;
import co.com.ceiba.domain.exception.DateException;
import co.com.ceiba.domain.exception.ParkingLotAlreadyExistsException;
import co.com.ceiba.domain.exception.ParkingLotCapacityException;
import co.com.ceiba.domain.exception.VehicleAlreadyExistsException;
import co.com.ceiba.domain.repository.ParkingLotRepository;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    private ParkingLot parkingLot;

    @Inject
    public void ParkingLotService(ParkingLotRepository parkingLotRepository,ParkingLot parkingLot){
        this.parkingLotRepository = parkingLotRepository;
        this.parkingLot = parkingLot;
    }

    public void createParkingLot(ParkingLot parkingLot){
        if(parkingLotRepository.parkingLotExist(parkingLot.getId())){
            throw new ParkingLotAlreadyExistsException();
        }
        parkingLotRepository.saveParkingLot(parkingLot);
    }
    public double calculatePayment(Vehicle vehicle){
        String entryDate =  vehicle.getEntryDate();
        String departureDate = vehicle.getDepartureDate();
        int cylinder = vehicle.getVehicleInformation().getCylinder();
        int startDay = parkingLot.getParkingInformationRate().getHourStartDay();
        int endtDay = parkingLot.getParkingInformationRate().getHourEndDay();
        long timeInParkinglot = calculateTimeInParkingLot(entryDate,departureDate);

        if(vehicle.getVehicleType().getName().equals("Carro")){
            return calculatePaymentCar(timeInParkinglot,startDay,endtDay);
        }else{
            return calculatePaymentMotorcycle(timeInParkinglot,startDay,endtDay,cylinder);
        }
    }

    public double calculatePaymentCar(long time,int startDay,int endDay){
        double total = 0;

        if(time >= startDay && time <= endDay){
            total = parkingLot.getParkingInformationRate().getRateCarPerDay();
        }else{
            total = parkingLot.getParkingInformationRate().getRateCarPerHour() * time;
        }
        return total;
    }

    public double calculatePaymentMotorcycle(long time,int startDay,int endDay,int cylinder){
        double total = 0;

        if(time >= startDay && time <= endDay){
            total = parkingLot.getParkingInformationRate().getRateMotorcyclePerDay();
        }else{
            total = parkingLot.getParkingInformationRate().getRateMotorcyclePerDay() * time;
        }
        if(cylinder > 500){
            total += 2000;
        }
        return total;
    }


    public boolean allowEntry(Vehicle vehicle){
        if(parkingLotRepository.vehicleExist(vehicle.getPlate())){
            throw new VehicleAlreadyExistsException();
        }
        if(vehicle.getVehicleType().getName().equals("Carro")){
            if(parkingLotRepository.getQuantityofVehicles(vehicle.getVehicleType()) > parkingLot.getMaxQuantityCar()){
                throw new ParkingLotCapacityException();
            }
            parkingLotRepository.saveVehicle(vehicle);
        }else if(vehicle.getVehicleType().getName().equals("Moto")){
            if(parkingLotRepository.getQuantityofVehicles(vehicle.getVehicleType()) > parkingLot.getMaxQuantityMotorcycle()){
                throw new ParkingLotCapacityException();
            }
            parkingLotRepository.saveVehicle(vehicle);
        }

        return true;
    }

    public long calculateTimeInParkingLot(String entryDate,String departureDate){
        long difference = 0;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date entryDateFormat = dateFormat.parse(entryDate);
            Date departureDateFormat = dateFormat.parse(departureDate);
            difference = Math.abs(entryDateFormat.getTime() - departureDateFormat.getTime());
            difference = difference / (60*60*1000);

        }catch (Exception e){
            throw new DateException();
        }
        return difference;
    }
}
