package com.salesianostriana.dam.proyectofinal.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private double pvp;
	private int cantidad;
	
	@ManyToOne
	private Venta venta;
	
	@ManyToOne
	private Producto producto;

	public void addToVenta(Venta venta) {
		this.venta=venta;
		venta.getLista().add(this);
	}
	
	public void removeFromVenta(Venta venta) {
		venta.getLista().remove(this);
		this.venta = null;
		
	}
	
	public double getSubtotal() {
		return pvp * cantidad;
	}

}
