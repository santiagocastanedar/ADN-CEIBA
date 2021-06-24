package co.com.ceiba.domain.exception;

public class WrongCylinderException extends RuntimeException{
    public static final String WRONG_CYLINDER_MESSAGE = "El cilindraje del vehiculo es incorrecto.";
    public WrongCylinderException(){
        super(WRONG_CYLINDER_MESSAGE);
    }
}
