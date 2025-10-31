package es.etg.daw.dawes.java.web.aulaCreativa.alumnos.infraestructure.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.command.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.service.CreateAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.service.DeleteAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.service.EditAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.service.FindAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.infraestructure.web.dto.AlumnoResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/alumnos") // La url para los alumnos será /alumnos
@RequiredArgsConstructor
public class AlumnoController {
    private final CreateAlumnoService createAlumnoService;
    private final FindAlumnoService findProductoService;
    private final DeleteAlumnoService deleteProductoService;
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
        deleteAlumnoService.delete(id);
        return ResponseEntity.noContent().build(); // Devpñvemos una respuesta vacía.
    }

    @PutMapping("/{id}") // Método Put
    public AlumnoResponse editProducto(@PathVariable int id, @RequestBody AlumnoRequest alumnoRequest) {
        EditAlumnoCommand comando = AlumnoMapper.toCommand(id, alumnoRequest);
        Alumno alumno = editAlumnoService.update(comando);
        return AlumnoMapper.toResponse(alumno); // Respuesta
    }


}
