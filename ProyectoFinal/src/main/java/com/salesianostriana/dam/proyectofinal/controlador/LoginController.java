package com.salesianostriana.dam.proyectofinal.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectofinal.servicios.CarritoService;
import com.salesianostriana.dam.proyectofinal.servicios.ProductoService;

@Controller
public class LoginController {
	
	@Autowired
	private CarritoService carritoService;

	@Autowired
	private ProductoService productoService;
	
	 @GetMapping("/login")
	    public String login(Model model) {
		 	model.addAttribute("carrito", carritoService);
		 	model.addAttribute("producto", productoService);
	        return "index";
	    }

	    @GetMapping("/login-error")
	    public String loginError(Model model) {
	        model.addAttribute("loginError", true);
	        return "index";
	    }


}
