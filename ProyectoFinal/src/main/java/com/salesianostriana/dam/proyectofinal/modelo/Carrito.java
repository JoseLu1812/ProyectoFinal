package com.salesianostriana.dam.proyectofinal.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor
public class Carrito {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private LocalDateTime fecha;
	
	@OneToMany
	private List<LineaVenta> lista = new ArrayList<LineaVenta>();

	
}
