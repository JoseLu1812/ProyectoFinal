package com.salesianostriana.dam.proyectofinal.servicios;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.modelo.Producto;
import com.salesianostriana.dam.proyectofinal.repositorio.IProductoRepository;
import com.salesianostriana.dam.proyectofinal.servicios.base.ServicioBaseImpl;


@Service
public class ProductoService extends ServicioBaseImpl<Producto, Long, IProductoRepository> {
	
	public void obtenerReglaNeg(Producto prod) {
		double total;
		double desc = 30.0;
		LocalDateTime fecha = LocalDateTime.from(ZonedDateTime.now());
		LocalDateTime a = LocalDateTime.of(2022, 6, 8, 00, 00);
		LocalDateTime b = LocalDateTime.of(2022, 6, 20, 23, 59);
		if(fecha.isAfter(a) && fecha.isBefore(b)) {
			for(int i = 0; i < this.findAll().size();i++) {
				total = prod.getPvp() * (prod.getPvp() * desc / 100);
				prod.setPvp(total);
			}
		}
		
	}
	
}
