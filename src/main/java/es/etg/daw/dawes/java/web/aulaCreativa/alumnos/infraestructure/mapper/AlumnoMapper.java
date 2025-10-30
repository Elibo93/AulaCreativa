package es.etg.daw.dawes.java.web.aulaCreativa.alumnos.infraestructure.mapper;

import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.command.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.application.command.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.web.aulaCreativa.alumnos.infraestructure.web.dto.AlumnoResponse;

public class AlumnoMapper {

    public static CreateAlumnoCommand toCommand(AlumnoRequest alumnoRequest) {
        return new CreateAlumnoCommand(alumnoRequest.nombre(), alumnoRequest.apellido(), alumnoRequest.email(),alumnoRequest.telefono(), alumnoRequest.direccion(), alumnoRequest.fechaNacimiento());
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

    public static EditAlumnoCommand toCommand(int id, AlumnoRequest alumnoRequest){
		return new EditAlumnoCommand(id, alumnoRequest.email(),alumnoRequest.telefono(), alumnoRequest.direccion());
	}

}