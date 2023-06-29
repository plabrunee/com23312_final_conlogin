package com.consultas.proyecto.service;

import java.util.List;
import java.util.Optional;

import com.consultas.proyecto.dto.RoleDTO;
import com.consultas.proyecto.model.Role;
import com.consultas.proyecto.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RoleService {
	
	private final RoleRepository perfilRepository;
	
	public RoleService (RoleRepository perfilRepository) {
		this.perfilRepository = perfilRepository;
	}
	
	public Optional<Role> findById(Long id){
		return perfilRepository.findById(id);
	}
	
	public Optional<Role> findByNombrePerfil(String nombrePerfil){
		return perfilRepository.findByNombrePerfil(nombrePerfil);
	}
	
	public List<Role> findAll(){
		return perfilRepository.findAll();
	}
	
	public Role create(RoleDTO perfilDTO) {
		Role perfil = new Role();
		perfil.setNombrePerfil(perfilDTO.getNombrePerfil());
		return perfilRepository.save(perfil);
	}
	
	@Transactional
	public boolean update(Long id, RoleDTO perfilDTO) {
		return perfilRepository.findById(id).map(perfil -> {
            copy(perfilDTO, perfil);
            return true;
        })
        .orElse(false);
	}
	
	private void copy(RoleDTO perfilDTO, Role perfil) {
		perfil.setNombrePerfil(perfilDTO.getNombrePerfil());    
    }
	
	public void delete(Long id) {
		if(perfilRepository.existsById(id)) {
			perfilRepository.deleteById(id);
		}
	}



}
