package com.salesianostriana.dam.proyectofinal.modelo;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
public class Cliente {

	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String apellidos;
	private String email;
	private LocalDate fechaNac;
	
}
