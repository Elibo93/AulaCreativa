package es.etg.daw.dawes.java.rest.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "inscripciones")
public class InscripcionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Alumno (FK)
     * Lado propietario: columna alumno_id en INSCRIPCIONES
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alumno", nullable = false)
    private AlumnoEntity alumno;

    /**
     * Taller (FK)
     * Lado propietario: columna taller_id en INSCRIPCIONES
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_taller", nullable = false)
    private TallerEntity taller;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
