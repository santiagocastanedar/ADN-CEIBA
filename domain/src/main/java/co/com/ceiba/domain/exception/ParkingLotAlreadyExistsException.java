package co.com.ceiba.domain.exception;

public class ParkingLotAlreadyExistsException extends RuntimeException {
    public static final String PARKINGLOT_ALREADY_ESXIST_MESSAGE = "El estacionamiento ya existe.";
    public ParkingLotAlreadyExistsException(){
        super(PARKINGLOT_ALREADY_ESXIST_MESSAGE);
    }
}
