package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.rest;

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

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.alumnos.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.alumnos.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.CreateAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.DeleteAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.EditAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.FindAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.alumno.AlumnoRequest;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.alumno.AlumnoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/alumnos") // La url para los alumnos será api/v1/alumnos
@Tag(name = "Alumnos", description = "Operaciones relacionadas con la gestión de Alumnos")
@RequiredArgsConstructor
public class AlumnoController {
    private final CreateAlumnoService createAlumnoService;
    private final FindAlumnoService findAlumnoService;
    private final DeleteAlumnoService deleteAlumnoService;
    private final EditAlumnoService editAlumnoService;

    @Operation(
        summary = "Crea un Alumno",
        description = "Crea un Alumno dados sus datos"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Alumno creado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos introducidos inválidos")
    })
    @PostMapping // Método Post
    public ResponseEntity<AlumnoResponse> createAlumno(@RequestBody AlumnoRequest alumnoRequest) {
        CreateAlumnoCommand comando = AlumnoMapper.toCommand(alumnoRequest);
        Alumno alumno = createAlumnoService.createAlumno(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(AlumnoMapper.toResponse(alumno));
    }

    @Operation(
        summary = "Obtiene el listado de Alumnos",
        description = "Busca en la base de datos todos los Alumnos y sus detalles"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Listado de alumnos generado"),
        @ApiResponse(responseCode = "404", description = "No hay alumnos en la base de datos")
    })
    @GetMapping // Método Get
    public List<AlumnoResponse> allAlumnos() {

        return findAlumnoService.findAll()
                .stream() // Convierte la lista en un flujo
                .map(AlumnoMapper::toResponse) // Mapeamos/Convertimos cada elemento del flujo (Alumno) en un objeto
                // de Respuesta (AlumnoResponse)
                .toList(); // Lo devuelve como una lista.

    }

    @Operation(
        summary = "Elimina un alumno",
        description = "Elimina un alumno de la base de datos dado un id"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sin cuerpo, Alumno eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    })
    @DeleteMapping("/{id}") // Método Delete
    public ResponseEntity<?> deleteAlumno(@PathVariable int id) {
        deleteAlumnoService.delete(new AlumnoId(id));
        return ResponseEntity.noContent().build(); // Devolvemos una respuesta vacía.
    }

    @Operation(
        summary = "Edita un alumno",
        description = "Edita los datos de un alumno dado su id"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Alumno editado correctamente"),
        @ApiResponse(responseCode = "400", description = "Datos introducidos inválidos")
    })
    @PutMapping("/{id}") // Método Put
    public AlumnoResponse editAlumno(@PathVariable int id, @RequestBody AlumnoRequest alumnoRequest) {
        EditAlumnoCommand comando = AlumnoMapper.toCommand(id, alumnoRequest);
        Alumno alumno = editAlumnoService.update(comando);
        return AlumnoMapper.toResponse(alumno); // Respuesta
    }

    // Método que captura los errores y devuelve un mapa con el campo que no cumple
    // la validación y un mensaje de error.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
