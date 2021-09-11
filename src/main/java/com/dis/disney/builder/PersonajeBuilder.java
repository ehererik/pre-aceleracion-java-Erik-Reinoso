package com.dis.disney.builder;
import com.dis.disney.dto.IPersonajeDTO;
import com.dis.disney.dto.PersonajeDTO;
import com.dis.disney.model.Personaje;

public class PersonajeBuilder {
	private String imagen;
	private String historia;
	private int edad;
	private float peso;
	private String nombre;

	
	public PersonajeBuilder withPersonajeDTO(PersonajeDTO p) {
		this.imagen=p.getImagen();
		this.nombre=p.getNombre();
		this.edad=p.getEdad();
		this.historia=p.getHistoria();
		this.peso=p.getPeso();
		return this;
	
	}
	
	public Personaje build() {
		Personaje per = new Personaje();
		per.setPeso(this.peso);
		per.setImagen(this.imagen);
		per.setNombre(this.nombre);
		per.setEdad(this.edad);
		per.setHistoria(this.historia);
		return per; 
	}
}
