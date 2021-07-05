package co.com.ceiba.domain.exception;

public class MaxCapacityException extends RuntimeException{
    public static final String MAX_CAPACITY_MESSAGE = "El parqueadero esta lleno.";
    public MaxCapacityException(){
        super(MAX_CAPACITY_MESSAGE);
    }
}
