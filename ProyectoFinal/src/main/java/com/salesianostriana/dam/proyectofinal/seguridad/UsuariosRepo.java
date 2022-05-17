package com.salesianostriana.dam.proyectofinal.seguridad;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.salesianostriana.dam.proyectofinal.modelo.Usuario;

public class UsuariosRepo {
	
	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return Collections.unmodifiableList(usuarios);
	}

	public Optional<Usuario> findUserByUsername(String username) {
		return usuarios.stream()
				.filter(u -> u.getUsername().equals(username))
				.findFirst();
	}

}
