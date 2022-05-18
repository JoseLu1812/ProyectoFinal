package com.salesianostriana.dam.proyectofinal.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class PublicController {
	
	@GetMapping({"/", "/index"})
	public String home() {
		return "index";
	}
	
	@GetMapping("/equipaciones")
	public String equipaciones() {
		return "equipaciones";
	}
	
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
	
}
