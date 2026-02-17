package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.alumno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.Alumno;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.alumno.AlumnoId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.AlumnoRepository;

@Repository
public class AlumnoRepositoryMockImpl implements AlumnoRepository {
    private final Map<AlumnoId, Alumno> Alumnos = AlumnoFactory.getDemoData();

    @Override
    public Alumno save(Alumno t) {
        // create
        if (t.getId() == null)
            t.setId(new AlumnoId(obtenerSiguienteId()));

        Alumnos.put(t.getId(), t);
        return t;
    }

    private int obtenerSiguienteId() {
        AlumnoId ultimo = null;
        if (!Alumnos.isEmpty()) {
            Collection<Alumno> lista = Alumnos.values();

            for (Alumno p : lista) {
                ultimo = p.getId();
            }

        }
        return ultimo.getValue() + 1;
    }

    @Override
    public List<Alumno> getAll() {
        return new ArrayList<>(Alumnos.values());
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
        // Un optional puede tener una valor o no. Si no existe el Alumno devuelve
        // Optional.empty
        return Optional.ofNullable(Alumnos.get(id));
    }

    @Override
    public void deleteById(AlumnoId id) {
        Alumnos.remove(id);
    }

    @Override
    public Optional<Alumno> getByName(String name) {
        // TODO Sin implementar
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

}
