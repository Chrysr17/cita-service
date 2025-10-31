package com.example.citaservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cita")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_horario", referencedColumnName = "id_horario"),
            @JoinColumn(name = "id_medico", referencedColumnName = "id_medico"),
            @JoinColumn(name = "id_hora", referencedColumnName = "id_hora")
    })
    private HorarioMedicoHora horarioMedicoHora;

    @Column(name = "fecha_cita")
    private LocalDate fechaCita;

    @Enumerated(EnumType.STRING)
    private EstadoCita estadoCita;

}
