package com.dis.disney.builder;

import com.dis.disney.dto.GeneroDTO;
import com.dis.disney.model.Genero;

public class GeneroDTOBuilder {

	private String nombre;
	private String imagen;



	public GeneroDTOBuilder withGenero(Genero g) {
		this.nombre=g.getNombre();
		this.imagen=g.getImagen();
		return this;
	}
	
	public GeneroDTO build() {
		GeneroDTO gen = new GeneroDTO();
		gen.setImagen(imagen);
		gen.setNombre(nombre);
		return gen;
	}
	public GeneroDTOBuilder() {
		// TODO Auto-generated constructor stub
	}

}
