package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.AlumnoId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.AlumnoRequest;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.web.dto.AlumnoResponse;

public class AlumnoMapper {

    public static CreateAlumnoCommand toCommand(AlumnoRequest AlumnoRequest) {
        return new CreateAlumnoCommand(AlumnoRequest.nombre(), AlumnoRequest.precio(), new CategoriaId(AlumnoRequest.categoriaId()));
    }

    public static EditAlumnoCommand toCommand(int id, AlumnoRequest AlumnoRequest) {
        // pasamos del int a AlumnoId
        return new EditAlumnoCommand(new AlumnoId(id), AlumnoRequest.nombre(), AlumnoRequest.precio(), new CategoriaId(AlumnoRequest.categoriaId()));
    }

    public static AlumnoResponse toResponse(Alumno alumno) {
        return new AlumnoResponse(Alumno.getId().getValue(), // lo pasamos a int
                alumno.getNombre(),
                alumno.getApellido(),
                alumno.getEmail(),
                alumno.getTelefono(),
                alumno.getDireccion(),
                alumno.getFecha_alta(),
                alumno.getCreatedAt(),
                alumno.getIsActivo()
        );
    }

    public static AlumnoEntity toEntity(Alumno p){
        return AlumnoEntity.builder().id(p.getId().getValue())
                                 .nombre(p.getNombre())
                                 .apellido(p.getApellido())
                                 .email(p.getEmail())
                                 .telefono(p.getTelefono())
                                 .direccion(p.getDireccion())
                                 .fecha_alta(p.getFecha_alta())
                                 .activo(p.isActivo())

                                 .fechaCreacion(p.getCreatedAt())
                                 .build();

    }

    public static Alumno toDomain(AlumnoEntity p){
        return Alumno.builder().id(new AlumnoId(p.getId()))
                                 .nombre(p.getNombre())
                                 .apellido(p.getApellido())
                                 .email(p.getEmail())
                                 .telefono(p.getTelefono())
                                 .direccion(p.getDireccion())
                                 .fecha_alta(p.getFecha_alta())
                                 .activo(p.isActivo())

                                 .createdAt(p.getFechaCreacion())
                                 .build();

    }

    public static List<Alumno> toDomain(List<AlumnoEntity> lista){
        List<Alumno> lp = new ArrayList<>();
        for(AlumnoEntity pe: lista){
            lp.add(toDomain(pe));
        }
        return lp;
    }


}