package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.CreateProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.DeleteProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.EditProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.profesor.FindProfesorService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.mapper.ProfesorMapper;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.profesor.ProfesorRequest;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.profesor.ProfesorResponse;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/profesores") // La url para los profesores será api/v1/profesores
@RequiredArgsConstructor
public class ProfesorController {

    //Atributos
    private final CreateProfesorService createProfesorService;
    private final FindProfesorService findProfesorService;
    private final DeleteProfesorService deleteProfesorService;
    private final EditProfesorService editProfesorService;

    @PostMapping
    public ResponseEntity<ProfesorResponse> createProfesor(@Valid@RequestBody ProfesorRequest profesorRequest) {
        CreateProfesorCommand comando = ProfesorMapper.toCommand(profesorRequest);
        Profesor profesor = createProfesorService.createProfesor(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProfesorMapper.toResponse(profesor)); // Respuestagit@github.com:julparper/dawes-springboot-restful.git
    }

    @GetMapping
    public List<ProfesorResponse> allProfesors() {

        return findProfesorService.findAll()
                .stream() // Convierte la lista en un flujo
                .map(ProfesorMapper::toResponse) // Mapeamos/Convertimos cada elemento del flujo (Producto) en un objeto
                // de Respuesta (ProductoResponse)
                .toList(); // Lo devuelve como una lista.

    }

    @PutMapping("/{id}")
    public ProfesorResponse editProfesor(@PathVariable int id, @Valid@RequestBody ProfesorRequest profesorRequest) {
        EditProfesorCommand comando = ProfesorMapper.toCommand(id, profesorRequest);
        Profesor profesor = editProfesorService.update(comando);
        return ProfesorMapper.toResponse(profesor); // Respuesta
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfesor(@PathVariable int id) {
        deleteProfesorService.delete(new ProfesorId(id));
        return ResponseEntity.noContent().build(); // Devolvemos una respuesta vacía.
    }
}

