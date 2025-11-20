package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.CreateAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.application.command.alumnos.EditAlumnoCommand;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.AlumnoId;
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

    public static AlumnoResponse toResponse(Alumno Alumno) {
        return new AlumnoResponse(Alumno.getId().getValue(), // lo pasamos a int
                Alumno.getNombre(),
                Alumno.getPrecio(),
                Alumno.getCreatedAt(),
                Alumno.getCategoria().getValue());// Agregamos la categoria.
    }

    public static AlumnoEntity toEntity(Alumno p){

        // Defino la categoría
        CategoriaEntity cat = new CategoriaEntity();
        cat.setId(p.getCategoria().getValue());
        AlumnoId id = p.getId();
        return AlumnoEntity.builder().id(id!=null?id.getValue():null)
                                        .nombre(p.getNombre())
                                       .precio(new BigDecimal(p.getPrecio()))
                                       .fechaCreacion(p.getCreatedAt())
                                       .categoria(cat)
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