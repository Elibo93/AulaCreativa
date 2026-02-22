package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.taller.CreateTallerCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.ProfesorEntity;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.TallerEntity;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.taller.TallerRequest;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.taller.TallerResponse;

public class TallerMapper {

    public static CreateTallerCommand toCommand(TallerRequest tallerRequest) {
        return new CreateTallerCommand(
                tallerRequest.nombre(),
                tallerRequest.descripcion(),
                new ProfesorId(tallerRequest.profesorId()),
                tallerRequest.horaInicio(),
                tallerRequest.horaFin(),
                tallerRequest.aforoMaximo());
    }

    public static es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.taller.EditTallerCommand toEditCommand(
            TallerId id, TallerRequest tallerRequest) {
        return new es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.taller.EditTallerCommand(
                id,
                tallerRequest.nombre(),
                tallerRequest.descripcion(),
                new ProfesorId(tallerRequest.profesorId()),
                tallerRequest.horaInicio(),
                tallerRequest.horaFin(),
                tallerRequest.aforoMaximo());
    }

    public static TallerResponse toResponse(Taller taller) {
        return new TallerResponse(
                taller.getId().getValue(),
                taller.getNombre(),
                taller.getDescripcion(),
                taller.getProfesor().getValue(),
                taller.getHoraInicio(),
                taller.getHoraFin(),
                taller.getAforoMaximo());
    }

    public static TallerEntity toEntity(Taller t) {

        ProfesorEntity profesor = new ProfesorEntity();
        profesor.setId(t.getProfesor().getValue());

        TallerId id = t.getId();
        return TallerEntity.builder()
                .id(id != null ? id.getValue() : null)
                .nombre(t.getNombre())
                .descripcion(t.getDescripcion())
                .profesor(profesor)
                .horaInicio(t.getHoraInicio())
                .horaFin(t.getHoraFin())
                .aforoMaximo(t.getAforoMaximo())
                .build();
    }

    public static Taller toDomain(TallerEntity e) {
        return Taller.builder()
                .id(e.getId() != null ? new TallerId(e.getId()) : null)
                .nombre(e.getNombre())
                .descripcion(e.getDescripcion())
                .profesor(new ProfesorId(e.getProfesor().getId()))
                .horaInicio(e.getHoraInicio())
                .horaFin(e.getHoraFin())
                .aforoMaximo(e.getAforoMaximo())
                .build();
    }

    public static List<Taller> toDomain(List<TallerEntity> lista) {
        return lista.stream()
                .map(TallerMapper::toDomain)
                .collect(Collectors.toList());
    }
}
