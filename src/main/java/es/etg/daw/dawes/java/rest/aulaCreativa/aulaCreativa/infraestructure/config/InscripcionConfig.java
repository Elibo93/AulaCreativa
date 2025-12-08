package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion.CreateInscripcionService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion.DeleteInscripcionService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion.EditInscripcionService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.inscripcion.FindInscripcionService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.inscripcion.CreateInscripcionUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.inscripcion.DeleteInscripcionUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.inscripcion.EditInscripcionUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.inscripcion.FindInscripcionUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.InscripcionRepository;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.inscripcion.InscripcionEntityJpaRepository;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.inscripcion.InscripcionJpaRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class InscripcionConfig {

    private final InscripcionEntityJpaRepository inscripcionRepository;

    // Creo por configuración la instalacia que me interesa de inscripcionRepository (desde jpa)
    @Bean
    public InscripcionRepository inscripcionRepository() {
        return new InscripcionJpaRepositoryImpl(inscripcionRepository);
    }
    // POST
    @Bean
    public CreateInscripcionUseCase createInscripcionUseCase() {
        return new CreateInscripcionUseCase(inscripcionRepository());
    }

    @Bean
    public CreateInscripcionService createInscripcionService() {
        return new CreateInscripcionService(createInscripcionUseCase());
    }

    // GET
    @Bean
    public FindInscripcionUseCase findInscripcionUseCase() {
        return new FindInscripcionUseCase(inscripcionRepository());
    }

    @Bean
    public FindInscripcionService findInscripcionService() {
        return new FindInscripcionService(findInscripcionUseCase());
    }

    // DELETE
    @Bean
    public DeleteInscripcionUseCase deleteInscripcionUseCase() {
        return new DeleteInscripcionUseCase(inscripcionRepository());
    }

    @Bean
    public DeleteInscripcionService deleteInscripcionService() {
        return new DeleteInscripcionService(deleteInscripcionUseCase());
    }

    // PUT
    @Bean
    public EditInscripcionUseCase editInscripcionUseCase() {
        return new EditInscripcionUseCase(inscripcionRepository());
    }

    @Bean
    public EditInscripcionService editInscripcionService() {
        return new EditInscripcionService(editInscripcionUseCase());
    }
}
