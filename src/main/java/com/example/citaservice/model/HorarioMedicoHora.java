package com.example.citaservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "horario_medico_hora")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(HorarioMedicoHoraId.class)
public class HorarioMedicoHora {
    @Id
    @Column(name = "id_horario")
    private Long idHorario;

    @Id
    @Column(name = "id_medico")
    private Long idMedico;

    @Id
    @Column(name = "id_hora")
    private Long idHora;

    @Column(name = "id_consultorio")
    private Long idConsultorio;

    @Column(name = "estado", length = 10)
    private String estado; // Disponible / Ocupado
}
