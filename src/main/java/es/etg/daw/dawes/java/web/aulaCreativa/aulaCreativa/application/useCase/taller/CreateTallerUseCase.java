package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.useCase.taller;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.taller.CreateTallerCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.TallerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTallerUseCase {

    private final TallerRepository tallerRepository;

    public Taller create(CreateTallerCommand comando) {

        Taller taller = Taller.builder()
                .nombre(comando.nombre())
                .descripcion(comando.descripcion())
                .profesorId(comando.profesorId())
                .horaInicio(comando.horaInicio())
                .horaFin(comando.horaFin())
                .aforoMaximo(comando.aforoMaximo()).build();
        
        return tallerRepository.save(taller);

    }
}
