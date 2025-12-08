package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.profesor;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.ProfesorRepository;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.ProfesorEntity;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.mapper.ProfesorMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProfesorJpaRepositoryImpl implements ProfesorRepository{

    //Atributos
    private final ProfesorEntityJpaRepository repository;

    //Implementacion de metodos
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
        Optional<Profesor> profesor = null;
        Optional<ProfesorEntity> pe = repository.findById(id.getValue());

        if (pe.isEmpty()) {
            profesor = Optional.empty();
        } else {
            profesor = Optional.of(ProfesorMapper.toDomain(pe.get()));
        }

        return profesor;
    }

    @Override
    public void deleteById(ProfesorId id) {
        repository.deleteById(id.getValue());
    }

    @Override
    public Optional<Profesor> getByName(String name) {
        ProfesorEntity profesor = repository.findByNombre(name);
        if(profesor!=null)
            return Optional.of(ProfesorMapper.toDomain(profesor));
        else
            return Optional.empty() ;
    }
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(),
    // etc.

}
