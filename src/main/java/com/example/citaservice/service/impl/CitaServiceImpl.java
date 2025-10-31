package com.example.citaservice.service.impl;

import com.example.citaservice.dto.CitaRequest;
import com.example.citaservice.model.Cita;
import com.example.citaservice.model.EstadoCita;
import com.example.citaservice.model.HorarioMedicoHora;
import com.example.citaservice.model.Paciente;
import com.example.citaservice.repository.CitaRepository;
import com.example.citaservice.repository.PacienteRepository;
import com.example.citaservice.service.CitaService;

import java.time.LocalDate;
import java.util.List;

public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;

    public CitaServiceImpl(CitaRepository citaRepository, PacienteRepository pacienteRepository) {
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Cita registrarCita(CitaRequest request) {
        Paciente paciente = pacienteRepository.findById(request.getIdPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no econtrado"));

        HorarioMedicoHora medicoHora = HorarioMedicoHora.builder()
                .idHorario(request.getIdHorario())
                .idMedico(request.getIdMedico())
                .idHora(request.getIdHora())
                .build();
        Cita cita = Cita.builder()
                .paciente(paciente)
                .horarioMedicoHora(medicoHora)
                .fechaCita(LocalDate.now())
                .estadoCita(EstadoCita.PENDIENTE)
                .build();

        return citaRepository.save(cita);
    }

    @Override
    public List<Cita> listarCitasPorPaciente(Long idPaciente) {
        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        return citaRepository.findByPaciente(paciente);
    }

    @Override
    public void cancelarCita(Long idCita) {
        Cita cita = citaRepository.findById(idCita)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setEstadoCita(EstadoCita.CANCELADA);
        citaRepository.save(cita);
    }
}
