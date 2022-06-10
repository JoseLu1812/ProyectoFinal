
package com.salesianostriana.dam.proyectofinal.servicios;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
import com.salesianostriana.dam.proyectofinal.servicios.base.ServicioBaseImpl;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoService extends ServicioBaseImpl<Carrito, Long, ICarritoRepository>{
	
	@Autowired
	private LineaVentaService lineaVentaService;

	
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
    
    public void finalizarCompraOld() {
    	
		// 0º Insertar la nueva venta en la base de datos.

    	
    	List<LineaVenta> listaLineasVenta =new ArrayList<LineaVenta>();
		Carrito carrito;
		double total=0;
		for (Map.Entry<Producto, Integer> lineaVenta : products.entrySet()) {
			
			
			
			// 1º Construir la instancia de Linea de Venta, sin asignar el pvp, y la guardo en una variable de tipo LineaVenta
			
			// 2º Comprobar si hay descuento, y en función de ello asignar el pvp
			
			// 3º Calcular el subtotal
			
			// 4º Con los métodos helper de Linea de Venta, asociar la venta y la línea
			
			// 5º Guardar en la base de datos la línea de venta
			
			
			
			
			
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
			
			// 6º Actualizar el total
			total=total+(lineaVenta.getKey().getPvp());
		}
		
		
		// 7º Actualizar la venta con el nuevo total
		
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
    
    }
    
    public void finalizarCompra() {
    	
    	Carrito carrito = new Carrito();;
    	double total = 0;
    	LineaVenta ln;
		LocalDateTime fecha = LocalDateTime.from(ZonedDateTime.now());
		LocalDateTime af = LocalDateTime.of(2022, 6, 8, 00, 00);
		LocalDateTime bf = LocalDateTime.of(2022, 6, 20, 23, 59);
		
		
    	carrito.getLista().add(
    			
    		ln = LineaVenta.builder()
    				.producto(ln.getProducto())
    				.build()
    				);
    	
    	if(fecha.isAfter(af) && fecha.isBefore(bf)) {
    		double pvp = ln.getProducto().getPvp();
			total = pvp - (pvp * ln.getProducto().getDescuento() / 100);
    		ln.getProducto().setPvp(total);
			ln.setSubtotal(total * ln.getProducto().getPvp());			
		}
    	
    	total += ln.getSubtotal();
    	
    	carrito = Carrito.builder()
    			.fecha(fecha)
    			.total(total)
    			.build();	
    	
    	ln.addAlCarrito(carrito);
    					
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
