package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper.AlumnoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlumnoJpaRepositoryImpl implements AlumnoRepository {
    private final AlumnoEntityJpaRepository repository;

    @Override
    public Alumno save(Alumno t) {

        AlumnoEntity prod = AlumnoMapper.toEntity(t);
        return AlumnoMapper.toDomain(repository.save(prod));
    }

    @Override
    public List<Alumno> getAll() {
        return AlumnoMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
        Optional<Alumno> Alumno = null;
        Optional<AlumnoEntity> pe = repository.findById(id.getValue());

        if (pe.isEmpty()) {
            Alumno = Optional.empty();
        } else {
            Alumno = Optional.of(AlumnoMapper.toDomain(pe.get()));
        }

        return Alumno;
    }

    @Override
    public void deleteById(AlumnoId id) {
        repository.deleteById(id.getValue());
    }

    @Override
    public Optional<Alumno> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(),
    // etc.

}
