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
	
    @GetMapping ("/private/carrito/agregarACarrito/{id}")
    public String productoACarrito (@PathVariable("id") Long id, Model model) {
    		Producto encontrado = productoService.findById(id).get();
			carritoService.addProducto(encontrado); 
			return "redirect:/private/carrito";
    }
    
    @GetMapping("/private/carrito/borrarDeCarrito/{id}")
    public String eliminarProductoCarrito(@PathVariable("id") Long id) {
        carritoService.eliminarProducto(productoService.findById(id).get());
        return "redirect:/private/carrito";
    }
    
    @GetMapping ("/private/carrito")
    public String verCarrito (Model model) {
    	if (model.addAttribute("products",carritoService.obtenerProductosCart()) == null)
    		return "redirect:/private/carrito";
    	return "carrito";
    }
    
    @GetMapping("/private/carrito/finalizarCompra")
    public String checkout() {
    	carritoService.finaizarCompra();
    	return "redirect:/private/carrito";
    }
    
    @ModelAttribute("totalCarrito")
    public Double totalCarrito () {
    	
    	Map <Producto,Integer> carrito=carritoService.obtenerProductosCart();
    	double total=0.0;
    	if (carrito !=null) {
        	for (Producto p: carrito.keySet()) {
        		total+=p.getPvp()*carrito.get(p);
        	}
        	return total;
    	}
    	
    	return 0.0;
    }
    
 
}
