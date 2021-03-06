package com.salesianostriana.dam.proyectofinal.servicios;


import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.modelo.Producto;
import com.salesianostriana.dam.proyectofinal.repositorio.IProductoRepository;
import com.salesianostriana.dam.proyectofinal.servicios.base.ServicioBaseImpl;


@Service
public class ProductoService extends ServicioBaseImpl<Producto, Long, IProductoRepository> {
	
	public double aplicarDescuento(Producto prod) {
		double total = prod.getPvp();
		double desc = 30.0;
		double redondeo;
		LocalDateTime fecha = LocalDateTime.from(ZonedDateTime.now());
		LocalDateTime af = LocalDateTime.of(2022, 6, 18, 00, 00);
		LocalDateTime bf = LocalDateTime.of(2022, 6, 20, 23, 59);
		if(fecha.isAfter(af) && fecha.isBefore(bf)) {
			total -= (prod.getPvp() * desc / 100);
			redondeo = Math.round(total*100.0)/100.0;
			prod.setPvp(redondeo);
		}
		return total;
	}
	
	
	
}
