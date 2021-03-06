package com.salesianostriana.dam.proyectofinal.seguridad;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepo {

	
	private List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return Collections.unmodifiableList(usuarios);
	}

	public Optional<Usuario> findUserByUsername(String username) {
		return usuarios.stream()
				.filter(u -> u.getUsername().equals(username))
				.findFirst();
	}
	
	// TODO Falta metodo init lista usuarios
	
	@PostConstruct
	public void init() {
		usuarios = List.of(
				Usuario.builder()
					.username("admin")
					.password("admin")
					.nombre("José Luis")
					.apellidos("Hidalgo Navas")
					.role("ADMIN")
					.fechaNac(LocalDate.of(2003, 12, 18))
					.build()
				,
					Usuario.builder()
					.username("user")
					.password("1234")
					.nombre("Usuario")
					.apellidos("Usuario")
					.role("USER")
					.fechaNac(LocalDate.of(1973, 10, 3))
					.build()
				);

}
}
