package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.profesor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.Profesor;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.ProfesorRepository;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.profesor.ProfesorId;

@Repository
public class ProfesorRepositoryMockImpl implements ProfesorRepository {

    private final Map<ProfesorId, Profesor> profesores = ProfesorFactory.getDemoData();

    @Override
    public Profesor save(Profesor p) {
        // CREATE → si no tiene ID, generar uno nuevo
        if (p.getId() == null) {
            p.setId(new ProfesorId(obtenerSiguienteId()));
        }

        profesores.put(p.getId(), p);
        return p;
    }

    private int obtenerSiguienteId() {
        ProfesorId ultimo = null;

        if (!profesores.isEmpty()) {
            Collection<Profesor> lista = profesores.values();

            for (Profesor prof : lista) {
                ultimo = prof.getId();
            }
        }

        return (ultimo == null) ? 1 : ultimo.getValue() + 1;
    }

    @Override
    public List<Profesor> getAll() {
        return new ArrayList<>(profesores.values());
    }

    @Override
    public Optional<Profesor> getById(ProfesorId id) {
        return Optional.ofNullable(profesores.get(id));
    }

    @Override
    public void deleteById(ProfesorId id) {
        profesores.remove(id);
    }

    @Override
    public Optional<Profesor> getByName(String nombre) {
        return profesores.values()
                .stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

}

