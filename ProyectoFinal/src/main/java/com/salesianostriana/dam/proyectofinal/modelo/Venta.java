package com.salesianostriana.dam.proyectofinal.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Venta {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany (mappedBy="venta", fetch= FetchType.EAGER)
	@Builder.Default
	private List <LineaVenta> lista = new ArrayList<LineaVenta>();
	private LocalDateTime fecha;
	
	private double total;
	
	private String usuario;

	
}
