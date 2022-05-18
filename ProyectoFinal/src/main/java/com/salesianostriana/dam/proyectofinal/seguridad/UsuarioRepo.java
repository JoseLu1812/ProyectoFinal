package com.salesianostriana.dam.proyectofinal.seguridad;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioRepo {

	
	@Autowired
	private List<Usuario> usuarios;

	@Autowired
	public List<Usuario> getUsuarios() {
		return Collections.unmodifiableList(usuarios);
	}

	public Optional<Usuario> findUserByUsername(String username) {
		return usuarios.stream()
				.filter(u -> u.getUsername().equals(username))
				.findFirst();
	}

}
