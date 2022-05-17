package com.salesianostriana.dam.proyectofinal.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinal.modelo.Usuario;


public interface UsuarioRepository 

extends JpaRepository<Usuario, Long>{
	
	
}
