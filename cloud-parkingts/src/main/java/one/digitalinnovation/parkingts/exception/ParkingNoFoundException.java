package one.digitalinnovation.parkingts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkingNoFoundException extends RuntimeException {
    public ParkingNoFoundException(String id) {
        super("Parking not found with Id: " + id);
    }
}
