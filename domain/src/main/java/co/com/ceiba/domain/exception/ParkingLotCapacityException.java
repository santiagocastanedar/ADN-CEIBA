package co.com.ceiba.domain.exception;

public class ParkingLotCapacityException extends RuntimeException{
    public static final String PARKINGLOT_CAPACITY_MESSAGE = "La capacidad del parquedero esta llena.";

    public ParkingLotCapacityException(){
        super(PARKINGLOT_CAPACITY_MESSAGE);
    }
}
