package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.profesor;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.ProfesorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProfesorUseCase {

    //Atributos
    private final ProfesorRepository profesorRepository;

    //Metodo para crear un profesor
    public Profesor create(CreateProfesorCommand comando) {

        Profesor profesor = Profesor.builder()
                .nombre(comando.nombre())
                .apellido(comando.apellido())
                .especialidad(comando.especialidad())
                .email(comando.email())
                .telefono(comando.telefono())
                .createdAt(LocalDateTime.now()).build();

        return profesorRepository.save(profesor);

    }
}
