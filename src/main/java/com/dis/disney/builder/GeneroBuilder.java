package com.dis.disney.builder;



import com.dis.disney.dto.GeneroDTO;
import com.dis.disney.model.Genero;


public class GeneroBuilder {

	private String nombre;
	private String imagen;
	
	public GeneroBuilder withGeneroDTO(GeneroDTO g) {
		this.nombre=g.getNombre();
		this.imagen=g.getImagen();
		return this;
	}
	
	public Genero build() {
		Genero gen = new Genero();
		gen.setImagen(imagen);
		gen.setNombre(nombre);
		return gen;
	}
	
	public GeneroBuilder() {
		// TODO Auto-generated constructor stub
	}

}
