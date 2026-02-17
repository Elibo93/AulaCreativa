package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.taller.CreateTallerCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.CreateTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.FindTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.mapper.TallerMapper;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.taller.TallerRequest;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.taller.TallerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/talleres") // La url para los Talleres será api/v1/talleres
@RequiredArgsConstructor
public class TallerController {

    //Atributos
    private final CreateTallerService createTallerService;
    private final FindTallerService findTallerService;

    @PostMapping
    public ResponseEntity<TallerResponse> createTaller(@Valid@RequestBody TallerRequest tallerRequest) {
        System.out.println("DEBUG Controller - DTO horaInicio = '" + tallerRequest.horaInicio() + "'");
        CreateTallerCommand comando = TallerMapper.toCommand(tallerRequest);
        Taller taller = createTallerService.createTaller(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(TallerMapper.toResponse(taller));
    }

    @GetMapping
    public List<TallerResponse> allTalleres() {

        return findTallerService.findAll()
                .stream() // Convierte la lista en un flujo
                .map(TallerMapper::toResponse) // Mapeamos/Convertimos cada elemento del flujo (Producto) en un objeto
                // de Respuesta (ProductoResponse)
                .toList(); // Lo devuelve como una lista.

    }

    // Gestión de validaciones
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });

        return errors;
    }
}
