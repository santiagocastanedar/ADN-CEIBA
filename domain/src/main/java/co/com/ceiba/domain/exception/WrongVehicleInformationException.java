package co.com.ceiba.domain.exception;

public class WrongVehicleInformationException extends RuntimeException {
    public static final String WRONG_VEHICLE_INFORMATION_MESSAGE = "La información del vehiculo es obligatoria.";
    public WrongVehicleInformationException(){
        super(WRONG_VEHICLE_INFORMATION_MESSAGE);
    }
}
