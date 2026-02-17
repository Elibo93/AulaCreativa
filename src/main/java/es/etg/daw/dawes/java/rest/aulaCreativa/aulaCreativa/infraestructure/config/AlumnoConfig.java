package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.CreateAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.DeleteAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.EditAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.alumnos.FindAlumnoService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.alumnos.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.alumnos.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.alumnos.EditAlumnoUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.alumnos.FindAlumnoUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.alumno.AlumnoEntityJpaRepository;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.alumno.AlumnoJpaRepositoryImpl;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.alumno.AlumnoRepositoryMockImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AlumnoConfig {

    private final AlumnoEntityJpaRepository alumnoRepository;

    @Bean
    public AlumnoRepository alumnoRepository() {
        return new AlumnoJpaRepositoryImpl(alumnoRepository);
    }

    // POST
    @Bean
    public CreateAlumnoUseCase createAlumnoUseCase() {
        return new CreateAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public CreateAlumnoService createAlumnoService() {
        return new CreateAlumnoService(createAlumnoUseCase());
    }

    // GET
    @Bean
    public FindAlumnoUseCase findAlumnoUseCase() {
        return new FindAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public FindAlumnoService findAlumnoService() {
        return new FindAlumnoService(findAlumnoUseCase());
    }

    // DELETE

    @Bean
    public DeleteAlumnoUseCase deleteAlumnoUseCase() {
        return new DeleteAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public DeleteAlumnoService deleteAlumnoService() {
        return new DeleteAlumnoService(deleteAlumnoUseCase());
    }

    // PUT
    @Bean
    public EditAlumnoUseCase editAlumnoUseCase() {
        return new EditAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public EditAlumnoService editAlumnoService() {
        return new EditAlumnoService(editAlumnoUseCase());
    }
}