package com.example.citaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioMedicoHoraId implements Serializable {
    private Long idHorario;
    private Long idMedico;
    private Long idHora;

}
