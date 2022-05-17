 package com.salesianostriana.dam.proyectofinal.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.repositorio.ClienteRepository;
import com.salesianostriana.dam.proyectofinal.modelo.Cliente;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;
	
	
	public Cliente add(Cliente c) {
		return clienteRepository.save(c);
	}
	
	public Cliente edit(Cliente c) {
		return clienteRepository.save(c);
	}
	
	public void delete(Cliente c) {
		clienteRepository.delete(c);
	}
	
	public void deleteById(long id) {
		clienteRepository.deleteById(id);
	}
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente findById(long id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
}
