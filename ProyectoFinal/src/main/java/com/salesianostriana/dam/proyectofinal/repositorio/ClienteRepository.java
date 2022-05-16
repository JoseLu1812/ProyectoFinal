package com.salesianostriana.dam.proyectofinal.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.modelo.Cliente;

public interface ClienteRepository 

extends JpaRepository<Cliente, Long>{
	
}
