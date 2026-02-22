package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.inscripcion.CreateInscripcionCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.inscripcion.EditInscripcionCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.InscripcionEntity;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.TallerEntity;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.inscripcion.InscripcionRequest;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.inscripcion.InscripcionResponse;

public class InscripcionMapper {

    public static CreateInscripcionCommand toCommand(InscripcionRequest req) {
        return new CreateInscripcionCommand(
                new AlumnoId(req.alumnoId()),
                new TallerId(req.tallerId()));
    }

    public static InscripcionResponse toResponse(Inscripcion inscripcion) {
        return new InscripcionResponse(
                inscripcion.getId() != null ? inscripcion.getId().getValue() : 0,
                inscripcion.getAlumnoId() != null ? inscripcion.getAlumnoId().getValue() : 0,
                inscripcion.getTallerId() != null ? inscripcion.getTallerId().getValue() : 0,
                inscripcion.getCreatedAt());
    }

    public static EditInscripcionCommand toCommand(int id, InscripcionRequest req) {
        return new EditInscripcionCommand(
                new InscripcionId(id),
                new AlumnoId(req.alumnoId()),
                new TallerId(req.tallerId()));
    }

    public static InscripcionEntity toEntity(Inscripcion i) {

        AlumnoEntity alumno = new AlumnoEntity();
        alumno.setId(i.getAlumnoId().getValue());

        TallerEntity taller = new TallerEntity();
        taller.setId(i.getTallerId().getValue());

        InscripcionId id = i.getId();
        return InscripcionEntity.builder()
                .id(id != null ? id.getValue() : null)
                .alumno(alumno)
                .taller(taller)
                .createdAt(i.getCreatedAt())
                .build();
    }

    public static Inscripcion toDomain(InscripcionEntity e) {
        return Inscripcion.builder()
                .id(e.getId() != null ? new InscripcionId(e.getId()) : null)
                .alumnoId(new AlumnoId(e.getAlumno().getId()))
                .tallerId(new TallerId(e.getTaller().getId()))
                .createdAt(e.getCreatedAt())
                .build();
    }

    public static List<Inscripcion> toDomain(List<InscripcionEntity> lista) {
        return lista.stream()
                .map(InscripcionMapper::toDomain)
                .collect(Collectors.toList());
    }
}
