package com.example.citaservice.service.impl;

import com.example.citaservice.dto.CitaRequest;
import com.example.citaservice.model.Cita;
import com.example.citaservice.service.CitaService;

import java.util.List;

public class CitaServiceImpl implements CitaService {
    @Override
    public Cita registrarCita(CitaRequest request) {
        return null;
    }

    @Override
    public List<Cita> listarCitasPorPaciente(Long idPaciente) {
        return List.of();
    }

    @Override
    public void cancelarCita(Long idCita) {

    }
}
