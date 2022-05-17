package com.salesianostriana.dam.proyectofinal.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinal.modelo.Cliente;

@Controller
public class AdminController {
	
	@GetMapping("/private")
	public String privateIndex(Model model, @AuthenticationPrincipal Cliente user) {
		
		model.addAttribute("usuario", user);
		
		return "private/index";
	}


}
