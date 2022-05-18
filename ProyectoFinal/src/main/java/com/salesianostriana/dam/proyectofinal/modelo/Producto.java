package com.salesianostriana.dam.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Producto {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private double pvp;
	private String talla;
	private int unidades;
	private double descuento;
	private String imagen;

}
