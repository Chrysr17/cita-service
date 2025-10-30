package com.example.citaservice.dto;

import lombok.Data;

@Data
public class CitaRequest {
    private Long idPaciente;
    private Long idHorario;
    private Long idMedico;
    private Long idHora;
}
