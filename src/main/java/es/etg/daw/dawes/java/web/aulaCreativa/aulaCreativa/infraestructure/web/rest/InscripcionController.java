package es.etg.daw.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.inscripcion.CreateInscripcionCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.inscripcion.EditInscripcionCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.inscripcion.CreateInscripcionService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.inscripcion.DeleteInscripcionService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.inscripcion.EditInscripcionService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.inscripcion.FindInscripcionService;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.inscripcion.InscripcionRequest;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.inscripcion.InscripcionResponse;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper.InscripcionMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/inscripciones")
@RequiredArgsConstructor
public class InscripcionController {

    private final CreateInscripcionService createService;
    private final FindInscripcionService findService;
    private final DeleteInscripcionService deleteService;
    private final EditInscripcionService editService;

    @PostMapping
    public ResponseEntity<InscripcionResponse> createInscripcion(@RequestBody InscripcionRequest request) {
        CreateInscripcionCommand command = InscripcionMapper.toCommand(request);
        Inscripcion inscripcion = createService.createInscripcion(command);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(InscripcionMapper.toResponse(inscripcion));
    }

    @GetMapping
    public List<InscripcionResponse> allInscripciones() {
        return findService.findAll()
                .stream()
                .map(InscripcionMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public InscripcionResponse getById(@PathVariable int id) {
        Inscripcion inscripcion = findService.findById(new InscripcionId(id));
        return InscripcionMapper.toResponse(inscripcion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        deleteService.delete(new InscripcionId(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public InscripcionResponse editInscripcion(
            @PathVariable int id,
            @RequestBody InscripcionRequest request
    ) {
        EditInscripcionCommand command = InscripcionMapper.toCommand(id, request);
        Inscripcion inscripcion = editService.update(command);
        return InscripcionMapper.toResponse(inscripcion);
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
