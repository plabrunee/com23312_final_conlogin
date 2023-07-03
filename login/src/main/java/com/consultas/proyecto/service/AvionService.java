package com.consultas.proyecto.service;


import com.consultas.proyecto.model.Avion;
import com.consultas.proyecto.repository.AvionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AvionService {
    private final AvionRepository avionRepository;

    public AvionService(AvionRepository avionRepository) {

        this.avionRepository = avionRepository;
    }

    public List<Avion> obtenerAvionesConAsientosDisponibles() {

        return avionRepository.findByAsientosDisponibles();
    }
    public Optional<Avion> obtenerAvion(Long avionId) {

        return avionRepository.findById(avionId);
    }
    public List<Avion> obtenerAviones() {
        return avionRepository.findAll();
    }
}



