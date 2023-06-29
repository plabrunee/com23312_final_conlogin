package com.consultas.proyecto.repository;

import com.consultas.proyecto.model.MetodoDePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoDePagoRepository extends JpaRepository<MetodoDePago, Long> {
}
