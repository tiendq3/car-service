package tiendq.carservice.car_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private HttpStatus httpStatus;
    private String reason;
    private String path;
}
