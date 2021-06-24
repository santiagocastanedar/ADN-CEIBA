package co.com.ceiba.domain.exception;

public class WrongRateException extends RuntimeException{
    public static final String WRONG_RATE_MESSAGE = "La tarifa es invalida.";
    public WrongRateException(){
        super(WRONG_RATE_MESSAGE);
    }
}
