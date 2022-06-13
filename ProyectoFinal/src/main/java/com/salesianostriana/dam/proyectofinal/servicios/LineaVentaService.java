package com.salesianostriana.dam.proyectofinal.servicios;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.proyectofinal.modelo.LineaVenta;
import com.salesianostriana.dam.proyectofinal.repositorio.ILineaVentaRepository;
import com.salesianostriana.dam.proyectofinal.servicios.base.ServicioBaseImpl;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LineaVentaService extends ServicioBaseImpl<LineaVenta, Long, ILineaVentaRepository>{


	public List <LineaVenta> findByTicket(Long id){
		return repositorio.findByVentaId(id);
	}	
	
}
