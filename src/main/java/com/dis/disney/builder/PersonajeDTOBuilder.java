package com.dis.disney.builder;

import java.util.Iterator;
import java.util.Set;

import com.dis.disney.dto.PersonajeDTO;
import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.model.Personaje;

public class PersonajeDTOBuilder {
	private long id;
	private String imagen;
	private String nombre;
	private String historia;
	private int edad;
	private float peso;
	Set<Long> likedPeliculaSerie;
	public PersonajeDTOBuilder withPersonaje(Personaje p) {
		this.id=p.getId();
		this.imagen=p.getImagen();
		this.nombre=p.getNombre();
		this.edad=p.getEdad();
		this.historia=p.getHistoria();
		this.peso=p.getPeso();
		Iterator<PeliculaSerie> it =p.getLikedPeliculaSerie().iterator();
		while(it.hasNext()) {
			this.likedPeliculaSerie.add( it.next().getId());
		}
		return this;
	}
	public PersonajeDTO build() {
		PersonajeDTO per = new PersonajeDTO();
		per.setPeso(this.peso);
		per.setId(this.id);
		per.setImagen(this.imagen);
		per.setNombre(this.nombre);
		per.setEdad(this.edad);
		per.setHistoria(this.historia);
		per.setLikedPeliculaSerie(this.likedPeliculaSerie);
		return per; 
	}
	
	
	
}
