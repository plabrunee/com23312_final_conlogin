package com.consultas.proyecto.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Credenciales {
	@NotEmpty
	private String nombre;
	
	@NotBlank
	private String password;
	
	public Credenciales() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
