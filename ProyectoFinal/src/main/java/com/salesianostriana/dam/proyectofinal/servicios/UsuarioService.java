 package com.salesianostriana.dam.proyectofinal.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.repositorio.UsuarioRepository;
import com.salesianostriana.dam.proyectofinal.modelo.Usuario;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	
	public Usuario add(Usuario c) {
		return usuarioRepository.save(c);
	}
	
	public Usuario edit(Usuario c) {
		return usuarioRepository.save(c);
	}
	
	public void delete(Usuario c) {
		usuarioRepository.delete(c);
	}
	
	public void deleteById(long id) {
		usuarioRepository.deleteById(id);
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
}
