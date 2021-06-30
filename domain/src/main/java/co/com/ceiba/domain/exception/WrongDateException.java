package co.com.ceiba.domain.exception;

public class WrongDateException extends RuntimeException {
    public static final String DATE_MESSAGE = "La fecha de entrada o de salida son incorrectas.";
    public WrongDateException(){
        super(DATE_MESSAGE);
    }
}
