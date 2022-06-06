package com.salesianostriana.dam.proyectofinal.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.modelo.LineaVenta;

public interface ILineaVentaRepository extends JpaRepository<LineaVenta, Long>{

	public List<LineaVenta> findByCarritoId(Long id);

}
