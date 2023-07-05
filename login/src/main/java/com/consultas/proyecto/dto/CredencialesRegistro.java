package com.consultas.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredencialesRegistro {

	private String nombre;

	private String apellido;

	private String telefono;

	private String mail;

	private String password;


}
