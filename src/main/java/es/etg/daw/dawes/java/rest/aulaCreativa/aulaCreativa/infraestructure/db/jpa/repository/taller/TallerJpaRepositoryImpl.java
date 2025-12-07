package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.repository.taller;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.Taller;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.taller.TallerId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.TallerRepository;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity.TallerEntity;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.mapper.TallerMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TallerJpaRepositoryImpl implements TallerRepository {

    //Atributos
    private final TallerEntityJpaRepository repository;

    //Implementacion de metodos
    @Override
    public Taller save(Taller t) {

        TallerEntity taller = TallerMapper.toEntity(t);
        return TallerMapper.toDomain(repository.save(taller));

    }

    @Override
    public List<Taller> getAll() {
        return TallerMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Taller> getById(TallerId id) {
        Optional<Taller> taller = null;
        Optional<TallerEntity> te = repository.findById(id.getValue());

        if(te.isEmpty()) {
            taller = Optional.empty();
        } else {
            taller = Optional.of(TallerMapper.toDomain(te.get()));
        }

        return taller;
    }

    @Override
    public void deleteById(TallerId id) {
        repository.deleteById(id.getValue());
    }

}

