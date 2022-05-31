
package com.salesianostriana.dam.proyectofinal.servicios;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinal.modelo.Producto;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoService{
	
	
	private Map<Producto, Integer> products = new HashMap <> ();
	
	
	public void addProducto (Producto p) {
		if (products.containsKey(p)) {
			products.replace(p, products.get(p)+1);
		}else {
			products.put(p, 1);
		}
	}
	
	public void eliminarProducto (Producto p) {
        if (products.containsKey(p)) {
            if (products.get(p) > 1)
                products.replace(p, products.get(p) - 1);
            else if (products.get(p) == 1) {
                products.remove(p);
            }
        }
	}
	
    public Map<Producto, Integer> obtenerProductosCart() {
        return Collections.unmodifiableMap(products);
    }
    
    public Double totalCarrito() { 	
    	Map <Producto,Integer> carrito=this.obtenerProductosCart();
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
