package com.salesianostriana.dam.proyectofinal.controlador;

import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinal.servicios.ProductoService;

@Controller
public class ProductoController {
	
	private ProductoService productoService;

	@GetMapping({"/admin/gestion"})
	public String productList(Model model) {
		model.addAttribute("productos", productoService.findAllProducts());
		return "gestion";
	}
	

	
	
	
	
}
