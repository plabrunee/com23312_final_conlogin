package com.consultas.proyecto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="usuarios")
public class Usuario implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id;
	@Column(nullable = false )
	private String nombre;
	@Column(name="mail")
	private String mail;

	@JsonIgnore
	@Column(nullable = false )
	private String password;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(
			name = "usuarios_perfiles",
			joinColumns = @JoinColumn(name = "id_usuario"),
			inverseJoinColumns = @JoinColumn(name = "id_perfil")
			)
	private Set<Role> perfiles= new HashSet<>();
	
	@Column(nullable = false, columnDefinition = "boolean default true")
	private boolean activo;

	@OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL)
	private List<Reserva> reserva;

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (idUsuario: ");
		result.append(id);
		result.append(", nombre: ");
		result.append(nombre);
		result.append(", mail: ");
		result.append(mail);
		result.append(')');
		return result.toString();
	}
	
}