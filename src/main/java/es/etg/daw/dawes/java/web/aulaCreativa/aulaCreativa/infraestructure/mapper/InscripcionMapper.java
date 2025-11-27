package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.inscripcion.CreateInscripcionCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.InscripcionEntity;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.inscripcion.InscripcionRequest;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.inscripcion.InscripcionResponse;

public class InscripcionMapper {

    // REQUEST -> CREATE COMMAND
    public static CreateInscripcionCommand toCommand(InscripcionRequest req) {
        return new CreateInscripcionCommand(
                req.alumnoId(),
                req.tallerId()
        );
    }

    // DOMAIN -> RESPONSE
    public static InscripcionResponse toResponse(Inscripcion inscripcion) {
        return new InscripcionResponse(
                inscripcion.getId() != null ? inscripcion.getId().getValue() : 0,
                inscripcion.getAlumnoId(),
                inscripcion.getTallerId(),
                inscripcion.getCreatedAt()
        );
    }

    // DOMAIN -> ENTITY
    public static InscripcionEntity toEntity(Inscripcion i) {
        return InscripcionEntity.builder()
                .id(i.getId() != null ? i.getId().getValue() : null)
                .alumnoId(i.getAlumnoId())
                .tallerId(i.getTallerId())
                .createdAt(i.getCreatedAt())
                .build();
    }

    // ENTITY -> DOMAIN
    public static Inscripcion toDomain(InscripcionEntity e) {
        return Inscripcion.builder()
                .id(e.getId() != null ? new InscripcionId(e.getId()) : null)
                .alumnoId(e.getAlumnoId())
                .tallerId(e.getTallerId())
                .createdAt(e.getCreatedAt())
                .build();
    }

    // LIST ENTITY -> LIST DOMAIN
    public static List<Inscripcion> toDomain(List<InscripcionEntity> lista) {
        return lista.stream()
                .map(InscripcionMapper::toDomain)
                .collect(Collectors.toList());
    }
}
