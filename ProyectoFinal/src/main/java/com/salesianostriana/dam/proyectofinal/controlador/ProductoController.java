package com.salesianostriana.dam.proyectofinal.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

	@GetMapping({"/private/productos"})
	public String productList(Model model, @AuthenticationPrincipal UserDetails user, Optional<Producto> prod) {
		List<Producto> productos = new ArrayList<>();
		if (prod.isEmpty()) {
			for (Producto producto : productoService.findAll()) {
				productos.add(producto);

			}
			model.addAttribute("productos", productos);

		} else {
			productos = productoService.findAll();
		}
		model.addAttribute("productos", productoService.findAll());
		return "productos";
	}
	
	@GetMapping("/admin/productos/nuevo")
	public String nuevoProducto(Model model) {	
		model.addAttribute("producto", new Producto());
		return "admin/agregarProd";
	}
	
	@PostMapping("/admin/productos/nuevo/submit")
	public String submitNuevoProducto(Producto producto, Model model) {
		productoService.save(producto);
		return "redirect:/private/productos";
	}
	
	@GetMapping("/admin/productos/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {
		Optional<Producto> producto = productoService.findById(id);
		if (producto != null) {
			productoService.delete(producto.get());
		}
		return "redirect:/private/productos";

	}
	
	@GetMapping("/admin/productos/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
		Optional<Producto> producto = productoService.findById(id);
		model.addAttribute("producto", producto);
		return "admin/editarProd";
	}
	
	@PostMapping("/admin/productos/editar/submit")
	public String submitEditarProducto(Producto producto, Model model) {
		productoService.edit(producto);
		return "redirect:/private/productos";
	}
		
	
}