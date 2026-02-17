package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.CreateTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.service.taller.FindTallerService;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.taller.CreateTallerUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.useCase.taller.FindTallerUseCase;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.TallerRepository;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.taller.TallerEntityJpaRepository;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.taller.TallerJpaRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class TallerConfig {

    private final TallerEntityJpaRepository tallerRepository;

    // Creo por configuración la instalacia que me interesa del productoRepository (desde jpa)
    @Bean
    public TallerRepository tallerRepository() {
        return new TallerJpaRepositoryImpl(tallerRepository);
    }

    // POST
    @Bean
    public CreateTallerUseCase createTallerUseCase() {
        return new CreateTallerUseCase(tallerRepository());
    }

    @Bean
    public CreateTallerService createTallerService() {
        return new CreateTallerService(createTallerUseCase());
    }

    // GET
    @Bean
    public FindTallerUseCase findTallerUseCase() {
        return new FindTallerUseCase(tallerRepository());
    }

    @Bean
    public FindTallerService findTallerService() {
        return new FindTallerService(findTallerUseCase());
    }
}
