package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.profesor.CreateProfesorService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.profesor.DeleteProfesorService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.profesor.EditProfesorService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.service.profesor.FindProfesorService;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.profesor.CreateProfesorUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.profesor.DeleteProfesorUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.profesor.EditProfesorUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.profesor.FindProfesorUseCase;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProfesorConfig {

    private final ProfesorRepository profesorRepository;

    // POST
    @Bean
    public CreateProfesorUseCase createProfesorUseCase() {
        return new CreateProfesorUseCase(profesorRepository);
    }

    @Bean
    public CreateProfesorService createProfesorService() {
        return new CreateProfesorService(createProfesorUseCase());
    }

    // GET
    @Bean
    public FindProfesorUseCase findProfesorUseCase() {
        return new FindProfesorUseCase(profesorRepository);
    }

    @Bean
    public FindProfesorService findProfesorService() {
        return new FindProfesorService(findProfesorUseCase());
    }

    // DELETE

    @Bean
    public DeleteProfesorUseCase deleteProfesorUseCase() {
        return new DeleteProfesorUseCase(profesorRepository);
    }

    @Bean
    public DeleteProfesorService deleteProfesorService() {
        return new DeleteProfesorService(deleteProfesorUseCase());
    }

    // PUT
    @Bean
    public EditProfesorUseCase editProfesorUseCase() {
        return new EditProfesorUseCase(profesorRepository);
    }

    @Bean
    public EditProfesorService editProfesorService() {
        return new EditProfesorService(editProfesorUseCase());
    }
}
