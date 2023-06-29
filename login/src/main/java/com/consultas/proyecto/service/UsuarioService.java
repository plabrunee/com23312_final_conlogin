package com.consultas.proyecto.service;
import java.util.*;

import javax.validation.ValidationException;

import com.consultas.proyecto.dto.UsuarioDTO;
import com.consultas.proyecto.model.Role;
import com.consultas.proyecto.model.Usuario;
import com.consultas.proyecto.repository.RoleRepository;
import com.consultas.proyecto.repository.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UsuarioService implements UserDetailsService {
	UsuarioRepository usuarioRepository;
	RoleRepository perfilRepository;
	PasswordEncoder passwordEncoder;
	public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository perfilRepository,
			PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.perfilRepository = perfilRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Optional<Usuario> findById(Long id) {
		return usuarioRepository.findById(id);
	}

	public Optional<Usuario> findByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario create(UsuarioDTO usuarioDTO) throws ValidationException {
		
		if (usuarioRepository.findByNombre(usuarioDTO.getNombre()).isPresent()) {
		      throw new ValidationException("El nombre de usuario ya existe!");
		 }
		
		Usuario usuario = new Usuario();
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setMail(usuarioDTO.getMail());
		usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
		usuario.setActivo(true);
		Role perfilEmprendedor = crearPerfilSiNoExiste(Role.ROLE_USER);
		Set<Role> perfilesUsuario = new HashSet<>();
		perfilesUsuario.add(perfilEmprendedor);
		usuario.setPerfiles(perfilesUsuario);
		return usuarioRepository.save(usuario);
	}
	

	@Transactional
	public boolean update(UsuarioDTO usuarioDTO) {
		return usuarioRepository.findById(usuarioDTO.getId()).map(usuario -> {
			copy(usuarioDTO, usuario);
			return true;
		}).orElse(false);
	}

	private void copy(UsuarioDTO usuarioDTO, Usuario usuario) {
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setMail(usuarioDTO.getMail());
		Set<Role> perfilesUsuario = new HashSet<>();
		for (String perfil : usuarioDTO.getPerfiles()) {
			Role perfilEmprendedor = crearPerfilSiNoExiste(perfil);
			perfilesUsuario.add(perfilEmprendedor);
		}		
		usuario.setPerfiles(perfilesUsuario);
		if(usuarioDTO.getPassword() != null) {
			//es porque cambiaron la contraseña
			usuario.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));
		}
	}

	public boolean logicalDelete(Long id) {
		return usuarioRepository.findById(id).map(usuario -> {
			usuario.setActivo(false);
			return true;
		}).orElse(false);
	}

	public boolean activateUser(Long id) {
		return usuarioRepository.findById(id).map(usuario -> {
			usuario.setActivo(true);
			return true;
		}).orElse(false);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> userOptional = usuarioRepository.findByNombre(username);
		if (userOptional.isEmpty())
			throw new UsernameNotFoundException("User not found with username: " + username);

		// Creo un usuario(de Spring) que se usará para autenticación y autorización
		// Primero creo los objetos Authority a partir de los perfiles que tiene el
		// usuario.
		Set<Role> perfiles = userOptional.get().getPerfiles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role perfil : perfiles) {
			authorities.add(new SimpleGrantedAuthority(perfil.getNombrePerfil()));
		}
		return new User(userOptional.get().getNombre(), userOptional.get().getPassword(), authorities);
	}
	
	@Transactional
	Role crearPerfilSiNoExiste(String nombrePerfil) {
		 
		  Optional<Role> perfilOptional = perfilRepository.findByNombrePerfil(nombrePerfil);
	        if (perfilOptional.isEmpty()) {
				Role perfil = new Role();
	            perfil.setNombrePerfil(nombrePerfil);
	            perfilRepository.save(perfil);
	            return perfil;
	        }
	        return perfilOptional.get();
	    }

	public UsuarioDTO loadUserDTO(String nombre) {
		Optional<Usuario> userOptional = usuarioRepository.findByNombre(nombre);
		if (userOptional.isEmpty())
			throw new UsernameNotFoundException("User not found with username: " + nombre);
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(userOptional.get().getId());
		usuarioDTO.setNombre(userOptional.get().getNombre());
		usuarioDTO.setMail(userOptional.get().getMail());
		Set<String> perfiles = new HashSet<>();
		for (Role perfil : userOptional.get().getPerfiles()) {
			perfiles.add(perfil.getNombrePerfil());
		}
		usuarioDTO.setPerfiles(perfiles);
		return usuarioDTO;
	}
}
