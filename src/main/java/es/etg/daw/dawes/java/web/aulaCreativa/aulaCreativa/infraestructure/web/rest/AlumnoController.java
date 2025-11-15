package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.rest;

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

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos.CreateAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos.DeleteAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos.EditAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos.FindAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.AlumnoResponse;
import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.model.AlumnoId;
import lombok.RequiredArgsConstructor;




@RestController
@RequestMapping("/alumnos") // La url para los alumnos será /alumnos
@RequiredArgsConstructor
public class AlumnoController {
    private final CreateAlumnoService createAlumnoService;
    private final FindAlumnoService findAlumnoService;
    private final DeleteAlumnoService deleteAlumnoService;
    private final EditAlumnoService editAlumnoService;

    @PostMapping // Método Post
    public ResponseEntity<AlumnoResponse> createProducto(@RequestBody AlumnoRequest alumnoRequest) {
        CreateAlumnoCommand comando = AlumnoMapper.toCommand(alumnoRequest);
        Alumno alumno = createAlumnoService.createAlumno(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(AlumnoMapper.toResponse(alumno)); // Respuestagit@github.com:julparper/dawes-springboot-restful.git
    }

    @GetMapping // Método Get
    public List<AlumnoResponse> allAlumnos() {

        return findAlumnoService.findAll()
                .stream() // Convierte la lista en un flujo
                .map(AlumnoMapper::toResponse) // Mapeamos/Convertimos cada elemento del flujo (Producto) en un objeto
                // de Respuesta (ProductoResponse)
                .toList(); // Lo devuelve como una lista.

    }

    @DeleteMapping("/{id}") // Método Delete
    public ResponseEntity<?> deleteAlumno(@PathVariable int id) {
        deleteAlumnoService.delete(new AlumnoId(id));
        return ResponseEntity.noContent().build(); // Devpñvemos una respuesta vacía.
    }

    @PutMapping("/{id}") // Método Put
    public AlumnoResponse editProducto(@PathVariable int id, @RequestBody AlumnoRequest alumnoRequest) {
        EditAlumnoCommand comando = AlumnoMapper.toCommand(id, alumnoRequest);
        Alumno alumno = editAlumnoService.update(comando);
        return AlumnoMapper.toResponse(alumno); // Respuesta
    }


}
