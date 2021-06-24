package co.com.ceiba.domain.exception;

public class ParkingInformationException extends RuntimeException{
    public static final String PARKING_INFORMATION_MESSAGE = "La informacion de las tarifas es obligatoria.";
    public ParkingInformationException(){
        super(PARKING_INFORMATION_MESSAGE);
    }
}
