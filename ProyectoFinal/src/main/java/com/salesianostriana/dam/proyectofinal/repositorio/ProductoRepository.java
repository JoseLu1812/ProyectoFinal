package com.salesianostriana.dam.proyectofinal.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinal.modelo.Producto;

@Repository
public interface ProductoRepository 
	extends JpaRepository<Producto, Long>{
	
	public  List<Producto> findByNombreContainingIgnoreCase(String nombre);

}
