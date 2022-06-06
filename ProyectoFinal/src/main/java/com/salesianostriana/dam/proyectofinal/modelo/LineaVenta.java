package com.salesianostriana.dam.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
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

	public void addToTicket(Carrito carrito) {
		this.carrito=carrito;
		carrito.getLista().add(this);
	}
	
	public void removeFromTicket(Carrito carrito) {
		carrito.getLista().remove(this);
		this.carrito = null;
		
	}

}
