package es.etg.daw.dawes.java.web.aulaCreativa.aulaCreativa.infraestructure.db.jpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "profesores")
public class ProfesorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String apellido;

    @Column(nullable = false, length = 50)
    private String especialidad;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}
