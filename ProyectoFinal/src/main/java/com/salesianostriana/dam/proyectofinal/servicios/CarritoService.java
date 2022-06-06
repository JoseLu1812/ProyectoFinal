
package com.salesianostriana.dam.proyectofinal.servicios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinal.modelo.Carrito;
import com.salesianostriana.dam.proyectofinal.modelo.LineaVenta;
import com.salesianostriana.dam.proyectofinal.modelo.Producto;
import com.salesianostriana.dam.proyectofinal.repositorio.ProductoRepository;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoService{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	private Map<Producto, Integer> products = new HashMap <> ();

	public void addProducto (Producto p) {
		if (products.containsKey(p)) {
			products.replace(p, products.get(p)+1);
		}else {
			products.put(p, 1);
		}
	}
	
	public void eliminarProducto (Producto producto) {
        if (products.containsKey(producto)) {
                products.remove(producto);
        }
	}
	
	
    public Map<Producto, Integer> obtenerProductosCart() {
        return Collections.unmodifiableMap(products);
    }
    
    public void finaizarCompra() {
    	
    	List<LineaVenta> listaLineasVenta =new ArrayList<LineaVenta>();
		Carrito carrito;
		double total=0;
		for (Map.Entry<Producto, Integer> lineaVenta : products.entrySet()) {//
			
			
			listaLineasVenta.add(
					LineaVenta.builder()
					.manga(lineaVenta.getKey())
					.cantidad(lineaVenta.getValue())
					.subtotal(lineaVenta.getKey().getPvp() * lineaVenta.getValue())
					.build()
					);
			
			total=total+(lineaVenta.getKey().getPvp() * lineaVenta.getValue());
		}
		//build del carrito
		carrito = Carrito.builder()
		.fecha(LocalDateTime.now())
		.total(total)		
		.build();
		
		if(!listaLineasVenta.isEmpty()) {
			this.save(carrito);
			for (LineaVenta lineaDeVenta : listaLineasVenta) {
				lineaVenta.addToTicket(carrito);
				lineaVentaServicio.save(lineaDeVenta);
				
			}
			
    	productoRepository.flush();
    	products.clear();
    }
    

		
}
