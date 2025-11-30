package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.inscripcion;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.InscripcionRepository;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.InscripcionEntity;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper.InscripcionMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InscripcionJpaRepositoryImpl implements InscripcionRepository {

    private final InscripcionEntityJpaRepository repository;

    @Override
    public Inscripcion save(Inscripcion i) {
        InscripcionEntity entity = InscripcionMapper.toEntity(i);
        return InscripcionMapper.toDomain(repository.save(entity));
    }

    @Override
    public List<Inscripcion> getAll() {
        return InscripcionMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Inscripcion> getById(InscripcionId id) {
        Optional<Inscripcion> inscripcion = null;
        Optional<InscripcionEntity> entity = repository.findById(id.getValue());

        if (entity.isEmpty()) {
            inscripcion = Optional.empty();
        } else {
            inscripcion = Optional.of(InscripcionMapper.toDomain(entity.get()));
        }

        return inscripcion;
    }

    @Override
    public void deleteById(InscripcionId id) {
        repository.deleteById(id.getValue());
    }

    @Override
    public List<Inscripcion> getByAlumnoId(AlumnoId alumnoId) {
        return InscripcionMapper.toDomain(repository.findByIdAlumno(alumnoId.getValue()));
    }

    @Override
    public List<Inscripcion> getByTallerId(TallerId tallerId) {
        return InscripcionMapper.toDomain(repository.findByIdTaller(tallerId.getValue()));
    }

    @Override
    public Optional<Inscripcion> getByAlumnoAndTaller(AlumnoId alumnoId, TallerId tallerId) {
        InscripcionEntity entity = repository.findByIdAlumnoAndIdTaller(alumnoId.getValue(), tallerId.getValue());

        if (entity == null) {
            return Optional.empty();
        }

        return Optional.of(InscripcionMapper.toDomain(entity));
    }

}
