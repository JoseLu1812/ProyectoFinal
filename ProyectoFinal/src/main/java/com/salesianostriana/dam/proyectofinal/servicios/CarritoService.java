
package com.salesianostriana.dam.proyectofinal.servicios;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinal.modelo.LineaVenta;
import com.salesianostriana.dam.proyectofinal.modelo.Producto;
import com.salesianostriana.dam.proyectofinal.modelo.Venta;
import com.salesianostriana.dam.proyectofinal.seguridad.Usuario;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoService {
	

	@Autowired
	private LineaVentaService lineaVentaService;
	
	@Autowired
	private VentaService ventaService;
	
	
	
	@Autowired
	private ProductoService productoService;
	
	private Map<Producto, Integer> products = new HashMap <> ();

	public void addProducto (Producto p) {
		productoService.aplicarDescuento(p);
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
    
    /*public void finalizarCompraOld() {
    	
		
    	
    	List<LineaVenta> listaLineasVenta =new ArrayList<LineaVenta>();
		Carrito carrito;
		double total=0;
		for (Map.Entry<Producto, Integer> lineaVenta : products.entrySet()) {
			
			
			// 0º Insertar la nueva venta en la base de datos.
			
			// 1º Construir la instancia de Linea de Venta, sin asignar el pvp, y la guardo en una variable de tipo LineaVenta
			
			// 2º Comprobar si hay descuento, y en función de ello asignar el pvp
			
			// 3º Calcular el subtotal
			
			// 4º Con los métodos helper de Linea de Venta, asociar la venta y la línea
			
			// 5º Guardar en la base de datos la línea de venta
			
			// 6º Actualizar el total
			
			// 7º Actualizar la venta con el nuevo total
			
			
			listaLineasVenta.add(
					LineaVenta.builder()
					.producto(lineaVenta.getKey())
					///.nombre(lineaVenta.getKey().getNombre())
					.unidades(lineaVenta.getValue())
					//.pvp(lineaVenta.getKey().getPvp())
					///.talla(lineaVenta.getKey().getTalla())
					///.imagen(lineaVenta.getKey().getImagen())
					//.subtotal(lineaVenta.getKey().getPvp() * lineaVenta.getValue())
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
				lineaVenta.addAlCarrito(carrito);
				lineaVentaService.save(lineaVenta);
				
			}
			
    	//productoRepository.flush();
    	products.clear();
		}
    
    }*/
    
    
    
    	// 0º Insertar la nueva venta en la base de datos.
	
 		// 1º Construir la instancia de Linea de Venta, sin asignar el pvp, y la guardo en una variable de tipo LineaVenta
 			
 		// 2º Comprobar si hay descuento, y en función de ello asignar el pvp
 		
 		// 3º Calcular el subtotal
 		
 		// 4º Con los métodos helper de Linea de Venta, asociar la venta y la línea
 		
 		// 5º Guardar en la base de datos la línea de venta
 			
 		// 6º Actualizar el total
 			
 		// 7º Actualizar la venta con el nuevo total
    
    public void finalizarCompra(Usuario usuario) {
    	  	
    	Venta venta = Venta.builder()
    					.fecha(LocalDateTime.now())
    					.usuario(usuario.getUsername())
    					.build();
    	
    	double total = 0;
    	
    	ventaService.save(venta);
    	
    	// Guardar la venta en la base de datos usando el servicio de venta
    	
    	//LineaVenta ln = new LineaVenta();
    	Map<Producto, Integer> listado = obtenerProductosCart();
		//LocalDateTime fecha = LocalDateTime.from(ZonedDateTime.now());
		//LocalDateTime af = LocalDateTime.of(2022, 6, 8, 00, 00);
		//LocalDateTime bf = LocalDateTime.of(2022, 6, 20, 23, 59);
		for (Entry<Producto, Integer> p : listado.entrySet()) {

			LineaVenta ln = LineaVenta.builder()
	    				.producto(p.getKey())
	    				.pvp(p.getKey().getPvp())
	    				.cantidad(p.getValue())
	    				.build();
	    				
	    	ln.addToVenta(venta);
	    	
	    	lineaVentaService.save(ln);
	    	
	    	
	    	total += ln.getSubtotal();
    	}
		/*
    	carrito = Venta.builder()
    			.fecha(fecha)
    			.total(total)
    			.build();	
    		
    	
    	ln.addToVenta(carrito);
    					*/
		
		venta.setTotal(total);
		
		ventaService.edit(venta);
		
		
		
		
    	products.clear();
    }
    
	
	public Double calcularCarrito () {
    	
    	Map <Producto,Integer> carrito = this.obtenerProductosCart();
    	double total = 0.0, redondeo = 0.0;
    	if (carrito != null) {
    			for (Producto p: carrito.keySet()) {
	        		total += p.getPvp()*carrito.get(p);
	        		redondeo = Math.round(total*100.0)/100.0;
	        	}
	        	return redondeo;
    		}	    		    	
    	return 0.0;
    }
		
}
