package com.consultas.proyecto.repository;

import java.util.Optional;

import com.consultas.proyecto.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByNombrePerfil(String nombrePerfil);
}
