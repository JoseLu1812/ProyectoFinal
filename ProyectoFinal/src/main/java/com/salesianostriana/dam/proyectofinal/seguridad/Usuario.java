package com.salesianostriana.dam.proyectofinal.seguridad;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
public class Usuario {
	
	private String username;
	private String password;
	private String nombre;
	private String apellidos;
	private String role;
	private String email;
	private LocalDate fechaNac;

}
