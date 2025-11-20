package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.profesor.CreateProfesorCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.profesor.EditProfesorCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Profesor;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.profesor.ProfesorRequest;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.profesor.ProfesorResponse;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.ProfesorId;

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
}