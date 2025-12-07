package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.repository.mock.inscripcion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.Inscripcion;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.model.inscripcion.InscripcionId;
import es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.domain.repository.InscripcionRepository;

public class InscripcionRepositoryMockImpl implements InscripcionRepository {

    private final Map<InscripcionId, Inscripcion> inscripciones = InscripcionFactory.getDemoData();

    @Override
    public Inscripcion save(Inscripcion i) {

        // create
        if (i.getId() == null)
            i.setId(new InscripcionId(obtenerSiguienteId()));

        inscripciones.put(i.getId(), i);

        return i;
    }

    private int obtenerSiguienteId() {
        InscripcionId ultimo = null;

        if (!inscripciones.isEmpty()) {
            Collection<Inscripcion> lista = inscripciones.values();

            for (Inscripcion p : lista) {
                ultimo = p.getId();
            }
        }

        return (ultimo != null ? ultimo.getValue() + 1 : 1);
    }

    @Override
    public List<Inscripcion> getAll() {
        return new ArrayList<>(inscripciones.values());
    }

    @Override
    public Optional<Inscripcion> getById(InscripcionId id) {
        return Optional.ofNullable(inscripciones.get(id));
    }

    @Override
    public void deleteById(InscripcionId id) {
        inscripciones.remove(id);
    }

    // @Override
    // public List<Inscripcion> getByAlumnoId(AlumnoId alumnoId) {
    //     List<Inscripcion> result = new ArrayList<>();

    //     for (Inscripcion i : inscripciones.values()) {
    //         if (i.getAlumnoId().equals(alumnoId)) {
    //             result.add(i);
    //         }
    //     }

    //     return result;
    // }

    // @Override
    // public List<Inscripcion> getByTallerId(TallerId tallerId) {
    //     List<Inscripcion> result = new ArrayList<>();

    //     for (Inscripcion i : inscripciones.values()) {
    //         if (i.getTallerId().equals(tallerId)) {
    //             result.add(i);
    //         }
    //     }

    //     return result;
    // }

    // @Override
    // public Optional<Inscripcion> getByAlumnoAndTaller(AlumnoId alumnoId, TallerId tallerId) {

    //     for (Inscripcion i : inscripciones.values()) {
    //         if (i.getAlumnoId().equals(alumnoId) &&
    //             i.getTallerId().equals(tallerId)) {
    //             return Optional.of(i);
    //         }
    //     }

    //     return Optional.empty();
    // }

    // @Override
    // public boolean existsByAlumnoAndTaller(AlumnoId alumnoId, TallerId tallerId) {

    //     for (Inscripcion i : inscripciones.values()) {
    //         if (i.getAlumnoId().equals(alumnoId) &&
    //             i.getTallerId().equals(tallerId)) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }
}
