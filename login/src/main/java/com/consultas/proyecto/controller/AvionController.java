package com.consultas.proyecto.controller;

import com.consultas.proyecto.model.Avion;
import com.consultas.proyecto.service.AvionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aviones")
public class AvionController {
    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @GetMapping("/asientos-disponibles")
    public ResponseEntity<List<Avion>> listarAvionesConAsientosDisponibles() {
        List<Avion> aviones = avionService.obtenerAvionesConAsientosDisponibles();
        return ResponseEntity.ok(aviones);
    }
    @GetMapping("/{avionId}")
    public ResponseEntity<Optional<Avion>> obtenerAvion(@PathVariable Long avionId) {
        Optional<Avion> avion = avionService.obtenerAvion(avionId);
        return ResponseEntity.ok(avion);
    }

    @GetMapping("/all")
    public List<Avion> obtenerAviones() {
        List<Avion> aviones = avionService.obtenerAviones();
        return aviones;
    }
}
