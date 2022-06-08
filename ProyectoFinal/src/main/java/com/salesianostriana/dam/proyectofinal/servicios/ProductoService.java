package com.salesianostriana.dam.proyectofinal.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.modelo.Producto;
import com.salesianostriana.dam.proyectofinal.repositorio.IProductoRepository;
import com.salesianostriana.dam.proyectofinal.servicios.base.ServicioBaseImpl;


@Service
public class ProductoService extends ServicioBaseImpl<Producto, Long, IProductoRepository> {
	
	public double obtenerReglaNeg() {
		LocalDateTime fecha = LocalDateTime.from(ZonedDateTime.now());
		LocalDateTime a = LocalDateTime.of(2022, 6, 18, 00, 00);
		LocalDateTime b = LocalDateTime.of(2022, 6, 20, 00, 00);
		if(fecha.isAfter(a) && fecha.isBefore(b)) {
			
		}
	}
	
}
