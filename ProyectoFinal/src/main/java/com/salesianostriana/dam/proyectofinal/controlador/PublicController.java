package com.salesianostriana.dam.proyectofinal.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class PublicController {
	
	
	@GetMapping({"/", "/index"})
	public String home() {
		return "index";
	}
	
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario";
	}
	
	@GetMapping("/error-acceso")
	public String error() {
		return "errorAcceso";
	}	
	
}
