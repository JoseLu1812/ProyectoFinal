package com.salesianostriana.dam.proyectofinal.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.modelo.Producto;
import com.salesianostriana.dam.proyectofinal.repositorio.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository repository;
	
	public List<Producto> findAllProducts() {
		return repository.findAll();
	}
	
	public Optional<Producto> findById(Long id) {
		return repository.findById(id);
	}

	public List<Producto> findByNombre(String nombre){
		return repository.findByNombreContainingIgnoreCase(nombre);
	}

}
