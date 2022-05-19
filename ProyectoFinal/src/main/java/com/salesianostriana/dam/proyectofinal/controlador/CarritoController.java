package com.salesianostriana.dam.proyectofinal.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinal.modelo.Producto;
import com.salesianostriana.dam.proyectofinal.servicios.CarritoService;
import com.salesianostriana.dam.proyectofinal.servicios.ProductoService;

@Controller 
public class CarritoController {
	
	@Autowired
	private CarritoService carritoService;
	
	@Autowired
	private ProductoService productoService;
	

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }
	
    @GetMapping ("/private/carrito")
    public String verCarrito (Model model) {
    	if (model.addAttribute("products",carritoService.obtenerProductosCart()) == null)
    		return "redirect:/";
    	return "carrito";
    }
    
    @GetMapping ("/private/agregarACarrito/{id}")
    public String productoACarrito (@PathVariable("id") Long id, Model model) {
    	if(productoService.findById(id).isPresent()) {
    		Producto encontrado = productoService.findById(id).get();
    		carritoService.agregarProducto(encontrado);
    	} 		 	
    	return "redirect:/carrito";
    }
    
    @GetMapping("/private/borrarDeCarrito/{id}")
    public String eliminarProductoCarrito(@PathVariable("id") Long id) {
        if(productoService.findById(id).isPresent()) {
        	Producto encontrado = productoService.findById(id).get();
        	carritoService.eliminarProducto(encontrado);
        }
        return "redirect:/carrito";
    }
    
 
}
