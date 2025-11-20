package es.etg.daw.dawes.java.web.aulaCreativa.common.infraestructure.web.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomResponse {

    private final LocalDateTime date;
    private final HttpStatus status;
    private final String message;

}
