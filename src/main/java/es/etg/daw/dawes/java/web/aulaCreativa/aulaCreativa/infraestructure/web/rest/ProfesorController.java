package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.profesor.CreateProfesorService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.profesor.DeleteProfesorService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.profesor.EditProfesorService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.profesor.FindProfesorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profesores") // La url para los profesores será /profesores
@RequiredArgsConstructor
public class ProfesorController {

    //Atributos
    private final CreateProfesorService createProfesorService;
    private final FindProfesorService findProfesorService;
    private final DeleteProfesorService deleteProfesorService;
    private final EditProfesorService editProfesorService;

    @PostMapping
    //Implementar metodo POST

    @GetMapping
    //Implementar metodo GET

    @PutMapping("/{id}")
    //Implementar metodo PUT

    @DeleteMapping("/{id}")
    //Implementar metodo DELETE


}
