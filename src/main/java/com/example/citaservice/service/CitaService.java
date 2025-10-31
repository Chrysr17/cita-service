package com.example.citaservice.service;

import com.example.citaservice.dto.CitaRequest;
import com.example.citaservice.model.Cita;

import java.util.List;

public interface CitaService {
    Cita registrarCita(CitaRequest request);
    List<Cita> listarCitasPorPaciente(Long idPaciente);
    void cancelarCita(Long idCita);
}
