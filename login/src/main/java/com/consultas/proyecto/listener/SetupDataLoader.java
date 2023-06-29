package com.consultas.proyecto.listener;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.consultas.proyecto.model.Role;
import com.consultas.proyecto.model.Usuario;
import com.consultas.proyecto.repository.RoleRepository;
import com.consultas.proyecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RoleRepository perfilRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (alreadySetup)
            return;
		Role perfilAdministrador = crearPerfilSiNoExiste(Role.ROLE_ADMIN);
		Role perfilEmprendedor = crearPerfilSiNoExiste(Role.ROLE_USER);
		
		
		Usuario usuarioAdmin = new Usuario();
		usuarioAdmin.setNombre("Juan");
		usuarioAdmin.setPassword(passwordEncoder.encode("juancito"));
		usuarioAdmin.setActivo(true);
		Set<Role> perfilesAdmin = new HashSet<>();
		perfilesAdmin.add(perfilAdministrador);
		usuarioAdmin.setPerfiles(perfilesAdmin);
		if(!usuarioRepository.findByNombre(usuarioAdmin.getNombre()).isPresent())
			usuarioRepository.save(usuarioAdmin);				
		
		Usuario usuarioEmprendedor = new Usuario();
		usuarioEmprendedor.setNombre("Fernando");
		usuarioEmprendedor.setPassword(passwordEncoder.encode("fer"));
		usuarioEmprendedor.setActivo(true);
		Set<Role> perfilesUsuario = new HashSet<>();
		perfilesUsuario.add(perfilEmprendedor);
		usuarioEmprendedor.setPerfiles(perfilesUsuario);
		if(!usuarioRepository.findByNombre(usuarioEmprendedor.getNombre()).isPresent())
			usuarioRepository.save(usuarioEmprendedor);
		
		alreadySetup = true;
	}
	
	  @Transactional
	  Role crearPerfilSiNoExiste(String nombrePerfil) {
	 
		  Optional<Role> perfilOptional = perfilRepository.findByNombrePerfil(nombrePerfil);
	        if (!perfilOptional.isPresent()) {
				Role perfil = new Role();
	            perfil.setNombrePerfil(nombrePerfil);
	            perfilRepository.save(perfil);
	            return perfil;
	        }
	        return perfilOptional.get();
	    }

}
