package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.profesor;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.domain.repository.ProfesorRepository;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.ProfesorEntity;
import es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.mapper.ProfesorMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProfesorJpaRepositoryImpl implements ProfesorRepository{
    private final ProfesorEntityJpaRepository repository;

    @Override
    public Profesor save(Profesor t) {

        ProfesorEntity profesor = ProfesorMapper.toEntity(t);
        return ProfesorMapper.toDomain(repository.save(profesor));
    }

    @Override
    public List<Profesor> getAll() {
        return ProfesorMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Profesor> getById(ProfesorId id) {
        Optional<Profesor> Profesor = null;
        Optional<ProfesorEntity> pe = repository.findById(id.getValue());

        if (pe.isEmpty()) {
            Profesor = Optional.empty();
        } else {
            Profesor = Optional.of(ProfesorMapper.toDomain(pe.get()));
        }

        return Profesor;
    }

    @Override
    public void deleteById(ProfesorId id) {
        repository.deleteById(id.getValue());
    }

    @Override
    public Optional<Profesor> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(),
    // etc.

}
