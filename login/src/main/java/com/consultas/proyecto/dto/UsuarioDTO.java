package com.consultas.proyecto.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {
	
	private Long id;
	
	private String nombre;
	
	private String password;
	
	private String mail;

	private boolean activo;

	private Set<String> perfiles;

	public Set<String> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<String> perfiles) {
		this.perfiles = perfiles;
	}


}