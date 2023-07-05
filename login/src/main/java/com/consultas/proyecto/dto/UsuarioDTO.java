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

	private String apellido;


	private String password;
	
	private String mail;

	private String telefono;


	private boolean activo;
	private Set<String> roles;

}