package co.com.ceiba.domain.exception;

public class RestPlateException extends RuntimeException {
    public static final String REST_PLATE_MESSAGE = "La placa ingresada no tiene permitido ingresar este dia";

    public RestPlateException() {
        super(REST_PLATE_MESSAGE);
    }
}
