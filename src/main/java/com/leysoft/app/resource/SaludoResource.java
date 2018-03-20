package com.leysoft.app.resource;

import org.springframework.hateoas.ResourceSupport;

import com.leysoft.app.entity.Saludo;

public class SaludoResource extends ResourceSupport {
	
	private String nombre;

	public SaludoResource(Saludo saludo) {
		this.nombre = saludo.getNombre();
	}

	public String getNombre() {
		return nombre;
	}
}