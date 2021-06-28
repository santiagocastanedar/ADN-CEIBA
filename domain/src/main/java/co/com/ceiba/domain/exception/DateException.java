package co.com.ceiba.domain.exception;

public class DateException extends RuntimeException {
    public static final String DATE_MESSAGE = "La fecha de entrada o de salida son incorrectas.";
    public DateException(){
        super(DATE_MESSAGE);
    }
}
