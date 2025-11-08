package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.config;

<<<<<<< HEAD
public class AlumnoConfig {

}
=======
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos.CreateAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos.DeleteAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos.EditAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.alumnos.FindAlumnoService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos.EditAlumnoUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.alumnos.FindAlumnoUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AlumnoConfig {
    private final AlumnoRepository alumnoRepository;

    // POST
    @Bean
    public CreateAlumnoUseCase createAlumnoUseCase() {
        return new CreateAlumnoUseCase(alumnoRepository);
    }

    @Bean
    public CreateAlumnoService createAlumnoService() {
        return new CreateAlumnoService(createAlumnoUseCase());
    }

    // GET
    @Bean
    public FindAlumnoUseCase findAlumnoUseCase() {
        return new FindAlumnoUseCase(alumnoRepository);
    }

    @Bean
    public FindAlumnoService findAlumnoService() {
        return new FindAlumnoService(findAlumnoUseCase());
    }

    // DELETE

    @Bean
    public DeleteAlumnoUseCase deleteAlumnoUseCase() {
        return new DeleteAlumnoUseCase(alumnoRepository);
    }

    @Bean
    public DeleteAlumnoService deleteAlumnoService() {
        return new DeleteAlumnoService(deleteAlumnoUseCase());
    }

    // PUT
    @Bean
    public EditAlumnoUseCase editAlumnoUseCase() {
        return new EditAlumnoUseCase(alumnoRepository);
    }

    @Bean
    public EditAlumnoService editAlumnoService() {
        return new EditAlumnoService(editAlumnoUseCase());
    }
}



>>>>>>> 10a31632194653131cc64149c35db9e45d4ec4f2
