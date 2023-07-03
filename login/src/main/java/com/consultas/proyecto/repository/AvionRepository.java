package com.consultas.proyecto.repository;

import com.consultas.proyecto.model.Avion;
import com.consultas.proyecto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {
    @Query("SELECT a FROM Avion a JOIN a.asiento asiento" +
            " WHERE asiento.esta_libre = true")
    List<Avion> findByAsientosDisponibles();
    Optional<Avion> findById(Long id);
    List<Avion> findAll();
}
