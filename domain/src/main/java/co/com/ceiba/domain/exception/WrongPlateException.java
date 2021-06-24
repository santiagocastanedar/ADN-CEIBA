package co.com.ceiba.domain.exception;

public class WrongPlateException extends RuntimeException {

    public static final String WRONG_PLATE_MESSAGE = "La placa ingresada no es valida.";

    public WrongPlateException(){super(WRONG_PLATE_MESSAGE);}
}
