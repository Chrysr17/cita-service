package com.example.citaservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cita")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cita {

    private Long id;
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
