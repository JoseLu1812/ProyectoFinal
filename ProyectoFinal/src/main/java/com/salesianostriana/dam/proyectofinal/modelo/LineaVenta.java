package com.salesianostriana.dam.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class LineaVenta {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private double pvp;
	private String talla;
	private String imagen;
	
	@ManyToOne
	private Carrito carrito;
	
	@OneToOne
	private Producto producto;

}
