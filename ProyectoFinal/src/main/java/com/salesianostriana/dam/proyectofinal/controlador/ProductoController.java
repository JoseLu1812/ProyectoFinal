package com.salesianostriana.dam.proyectofinal.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinal.servicios.ProductoService;

@Controller
public class ProductoController {
	
	private ProductoService productoService;

	@GetMapping({"/"})
	public String productList(Model model) {
		
		model.addAttribute("productos", productoService.findAllProducts());
		return "list";
	}
	
	
	
	
}
