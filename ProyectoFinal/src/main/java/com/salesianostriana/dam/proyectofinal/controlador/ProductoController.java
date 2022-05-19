package com.salesianostriana.dam.proyectofinal.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.modelo.Producto;
import com.salesianostriana.dam.proyectofinal.servicios.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;

	@GetMapping("/private/productos")
	public String productList(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "equipaciones";
	}
	
	@GetMapping("/admin/productos/nuevo")
	public String nuevoProducto(Model model) {		
		return "admin/agregarProd";
	}
	
	@PostMapping("/admin/productos/nuevo/submit")
	public String submitNuevoProducto(Producto producto, Model model) {
		model.addAttribute("producto", new Producto());
		productoService.save(producto);
		return "redirect:/equipaciones";
	}
	
	@GetMapping("/admin/productos/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {
		Optional<Producto> producto = productoService.findById(id);
		if (producto != null) {
			productoService.delete(producto.get());
		}
		return "redirect:/equipaciones";

	}
	
	@GetMapping("/admin/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
		Optional<Producto> producto = productoService.findById(id);
		if (producto != null) {
			model.addAttribute("producto", producto);
			return "admin/agregarProd";
		} else {
			return "redirect:/equipaciones";
		}

	}
		
	
}
