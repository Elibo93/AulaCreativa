package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.alumnos.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.application.command.alumnos.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.alumno.AlumnoRequest;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.web.dto.alumno.AlumnoResponse;

public class AlumnoMapper {

    // REQUEST -> CREATE COMMAND
    public static CreateAlumnoCommand toCommand(AlumnoRequest req) {
        return new CreateAlumnoCommand(
                req.dni(),
                req.nombre(),
                req.apellido(),
                req.email(),
                req.telefono(),
                req.direccion(),
                req.fechaNacimiento()

        );
    }

    // REQUEST -> EDIT COMMAND
    public static EditAlumnoCommand toCommand(int id, AlumnoRequest req) {
        return new EditAlumnoCommand(
                new AlumnoId(id),
                req.email(),
                req.telefono(),
                req.direccion()

        );
    }

    // DOMAIN -> RESPONSE
    public static AlumnoResponse toResponse(Alumno alumno) {
        return new AlumnoResponse(
                alumno.getId() != null ? alumno.getId().getValue() : 0,
                alumno.getDni(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getEmail(),
                alumno.getTelefono(),
                alumno.getDireccion(),
                alumno.getFechaNacimiento(),
                alumno.getCreatedAt());
    }

    // DOMAIN -> ENTITY
    public static AlumnoEntity toEntity(Alumno a) {
        return AlumnoEntity.builder()
                .id(a.getId() != null ? a.getId().getValue() : null)
                .dni(a.getDni())
                .nombre(a.getNombre())
                .apellido(a.getApellido())
                .email(a.getEmail())
                .telefono(a.getTelefono())
                .direccion(a.getDireccion())
                .fechaNacimiento(a.getFechaNacimiento())
                .createdAt(a.getCreatedAt())
                .build();
    }

    // ENTITY -> DOMAIN
    public static Alumno toDomain(AlumnoEntity e) {
        return Alumno.builder()
                .id(e.getId() != null ? new AlumnoId(e.getId()) : null)
                .dni(e.getDni())
                .nombre(e.getNombre())
                .apellido(e.getApellido())
                .email(e.getEmail())
                .telefono(e.getTelefono())
                .direccion(e.getDireccion())
                .fechaNacimiento(e.getFechaNacimiento())
                .createdAt(e.getCreatedAt())
                .build();
    }

    // LIST ENTITY -> LIST DOMAIN
    public static List<Alumno> toDomain(List<AlumnoEntity> lista) {
        return lista.stream()
                .map(AlumnoMapper::toDomain)
                .collect(Collectors.toList());
    }
}
