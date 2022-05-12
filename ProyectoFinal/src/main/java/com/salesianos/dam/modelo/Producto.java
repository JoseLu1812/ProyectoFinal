package com.salesianos.dam.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Producto {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String talla;
	private int unidades;

}
