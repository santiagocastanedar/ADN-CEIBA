package co.com.ceiba.domain.exception;

public class VehicleAlreadyExistsException extends RuntimeException {
    public static final String VEHICLE_ALREADY_ESXIST_MESSAGE = "El vehiculo ya se encuentra parqueado";
    public VehicleAlreadyExistsException(){
        super(VEHICLE_ALREADY_ESXIST_MESSAGE);
    }
}
