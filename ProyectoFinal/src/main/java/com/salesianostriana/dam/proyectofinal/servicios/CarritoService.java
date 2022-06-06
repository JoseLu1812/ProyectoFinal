
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
import com.salesianostriana.dam.proyectofinal.repositorio.ICarritoRepository;
import com.salesianostriana.dam.proyectofinal.repositorio.IProductoRepository;
import com.salesianostriana.dam.proyectofinal.servicios.base.ServicioBaseImpl;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoService extends ServicioBaseImpl<Carrito, Long, ICarritoRepository>{
	
	@Autowired
	private LineaVentaService lineaVentaService;
	
	@Autowired
	private IProductoRepository productoRepository;
	
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
					.producto(lineaVenta.getKey())
					.build()
					);
			
			total=total+(lineaVenta.getKey().getPvp());
		}
		//build del carrito
		carrito = Carrito.builder()
		.fecha(LocalDateTime.now())
		.total(total)		
		.build();
		
		if(!listaLineasVenta.isEmpty()) {
			this.save(carrito);
			for (LineaVenta lineaVenta : listaLineasVenta) {
				lineaVenta.addToTicket(carrito);
				lineaVentaService.save(lineaVenta);
				
			}
			
    	productoRepository.flush();
    	products.clear();
    }
    
    }
		
}
