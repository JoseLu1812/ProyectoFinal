package com.salesianostriana.dam.proyectofinal.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinal.modelo.Usuario;


@Controller 
public class UsuarioController {
	
	@GetMapping({"/", "/index"})
	public String home() {
		return "index";
	}
	
	@GetMapping("/equipaciones")
	public String equipaciones() {
		return "equipaciones";
	}
	
	@GetMapping("/entrenamiento")
	public String entrenamiento() {
		return "entrenamiento";
	}
	
	@GetMapping("/accesorios")
	public String accesorios() {
		return "accesorios";
	}
	
	@GetMapping("/regalos")
	public String regalos() {
		return "regalos";
	}
	
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario";
	}
	
	
}
