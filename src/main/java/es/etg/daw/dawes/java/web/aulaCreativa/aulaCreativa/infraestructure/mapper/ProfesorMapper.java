package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.ProfesorEntity;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.profesor.ProfesorRequest;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.profesor.ProfesorResponse;

public class ProfesorMapper {

    public static CreateProfesorCommand toCommand(ProfesorRequest profesorRequest) {
        return new CreateProfesorCommand(profesorRequest.nombre(), profesorRequest.apellido(), profesorRequest.email(),profesorRequest.telefono(), profesorRequest.especialidad());
    }

    public static ProfesorResponse toResponse(Profesor profesor) {
        return new ProfesorResponse(profesor.getId(),
                profesor.getNombre(),
                profesor.getApellido(),
                profesor.getEspecialidad(),
                profesor.getCreatedAt());
    }

    public static EditProfesorCommand toCommand(int id, ProfesorRequest profesorRequest){
		return new EditProfesorCommand(new ProfesorId(id), profesorRequest.especialidad(), profesorRequest.email(),profesorRequest.telefono());
	}

    // DOMAIN -> ENTITY
    public static ProfesorEntity toEntity(Profesor a) {
        return ProfesorEntity.builder()
                .id(a.getId() != null ? a.getId().getValue() : null)
                .nombre(a.getNombre())
                .apellido(a.getApellido())
                .especialidad(a.getEspecialidad())
                .email(a.getEmail())
                .telefono(a.getTelefono())
                .createdAt(a.getCreatedAt())
                .build();
    }

    // ENTITY -> DOMAIN
    public static Profesor toDomain(ProfesorEntity e) {
        return Profesor.builder()
                .id(e.getId() != null ? new ProfesorId(e.getId()) : null)
                .nombre(e.getNombre())
                .apellido(e.getApellido())
                .especialidad(e.getEspecialidad())
                .email(e.getEmail())
                .telefono(e.getTelefono())
                .createdAt(e.getCreatedAt())
                .build();
    }

    // LIST ENTITY -> LIST DOMAIN
    public static List<Profesor> toDomain(List<ProfesorEntity> lista) {
        return lista.stream()
                .map(ProfesorMapper::toDomain)
                .collect(Collectors.toList());
    }
}