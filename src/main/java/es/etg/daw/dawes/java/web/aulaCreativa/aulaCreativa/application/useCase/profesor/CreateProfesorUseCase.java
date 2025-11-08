package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.profesor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateProfesorUseCase {

    //Atributos
    private final ProfesorRepository profesorRespository;

    //Metodo para crear un profesor
    public Profesor create(CreateProfesorCommand comando) {

        Profesor profesor = Profesor.builder()
                .nombre(comando.nombre())
                .apellido(comando.apellido())
                .especialidad(comando.especialidad())
                .email(comando.email())
                .telefono(comando.telefono())
                .createdAt(LocalDateTime.now()).build();

        profesorRepository.save(profesor);

        return profesor;
    }
}
