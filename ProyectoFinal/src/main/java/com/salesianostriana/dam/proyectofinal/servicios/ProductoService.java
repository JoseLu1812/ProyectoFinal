package com.salesianostriana.dam.proyectofinal.servicios;


import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.modelo.Producto;
import com.salesianostriana.dam.proyectofinal.repositorio.IProductoRepository;
import com.salesianostriana.dam.proyectofinal.servicios.base.ServicioBaseImpl;


@Service
public class ProductoService extends ServicioBaseImpl<Producto, Long, IProductoRepository> {
	
	public double obtenerReglaNeg(Producto prod) {
		double total;
		double desc = 30.0;
		total = prod.getPvp() * (prod.getPvp() * desc / 100);
		prod.setPvp(total);
		return total;
		
    	//LocalDateTime fecha = LocalDateTime.from(ZonedDateTime.now());
		//LocalDateTime af = LocalDateTime.of(2022, 6, 8, 00, 00);
		//LocalDateTime bf = LocalDateTime.of(2022, 6, 20, 23, 59);
	}
	
	
	public void aplicarReglaProd() {
		
	}
	
}
