package co.com.ceiba.domain.exception;

public class WrongVehicleTypeException extends RuntimeException {
    public static final String WRONG_VEHICLE_TYPE_MESSAGE = "EL tipo de vehiculo no puede ser nulo.";
    public WrongVehicleTypeException(){
        super(WRONG_VEHICLE_TYPE_MESSAGE);
    }
}
