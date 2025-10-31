package com.example.citaservice.controller;

import com.example.citaservice.dto.CitaRequest;
import com.example.citaservice.model.Cita;
import com.example.citaservice.service.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CitaController {

    private final CitaService citaService;

    @PostMapping("/registrar")
    public ResponseEntity<Cita> registrar(@RequestBody CitaRequest citaRequest){
        Cita cita = citaService.registrarCita(citaRequest);
        return ResponseEntity.ok(cita);
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<Cita>> listarPorPaciente (@PathVariable Long idPaciente){
        List<Cita>citas = citaService.listarCitasPorPaciente(idPaciente);
        return ResponseEntity.ok(citas);
    }

    @PutMapping("/cancelar/{idCita}")
    public ResponseEntity<String> cancelar(@PathVariable Long idCita){
        citaService.cancelarCita(idCita);
        return ResponseEntity.ok("CitaCancelada correctamente");
    }
}
