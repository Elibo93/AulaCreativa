package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.AlumnoResponse;
import es.etg.daw.dawes.java.web.aulaCreativa.common.domain.model.AlumnoId;

public class AlumnoMapper {

    public static CreateAlumnoCommand toCommand(AlumnoRequest alumnoRequest) {
        return new CreateAlumnoCommand(alumnoRequest.nombre(), alumnoRequest.apellido(), alumnoRequest.email(),alumnoRequest.telefono(), alumnoRequest.direccion(), alumnoRequest.fechaNacimiento());
    }

     public static EditAlumnoCommand toCommand(int id, AlumnoRequest alumnoRequest) {
        return new EditAlumnoCommand(new AlumnoId(id), alumnoRequest.nombre(), alumnoRequest.apellido(), alumnoRequest.email(),alumnoRequest.telefono(), alumnoRequest.direccion());
    }

    public static AlumnoResponse toResponse(Alumno alumno) {
        return new AlumnoResponse(alumno.getId(),
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getEmail(),
                alumno.getTelefono(),
                alumno.getDireccion(),
                alumno.getCreatedAt());
    }


}