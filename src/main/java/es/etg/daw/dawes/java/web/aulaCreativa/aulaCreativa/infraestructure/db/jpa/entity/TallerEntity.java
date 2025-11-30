package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity;

import jakarta.persistence.Basic;
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
@Table(name = "TALLERES")
public class TallerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Basic(optional=true)
    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    // Relación Many-to-One: Es el lado propietario (tendrá la FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id", nullable = false) // Columna de clave foránea en la tabla Taller
    private ProfesorEntity profesor;

    @Column(name = "hora_inicio", nullable = false, length = 8)
    private String horaInicio;

    @Column(name = "hora_fin", nullable = false, length = 8)
    private String horaFin;

    @Column(name = "aforo_maximo", nullable = false)
    private int aforoMaximo;

}
