package com.salesianostriana.dam.proyectofinal.modelo;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String apellidos;
	private String email;
	private LocalDate fechaNac;
	
}
