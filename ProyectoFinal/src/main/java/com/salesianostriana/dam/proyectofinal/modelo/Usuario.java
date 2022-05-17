package com.salesianostriana.dam.proyectofinal.modelo;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
public class Usuario {

	@Id
	@GeneratedValue
	private long id;
	
	private String username;
	private String password;
	private String nombre;
	private String apellidos;
	private String role;
	private String email;
	private LocalDate fechaNac;
	
}
