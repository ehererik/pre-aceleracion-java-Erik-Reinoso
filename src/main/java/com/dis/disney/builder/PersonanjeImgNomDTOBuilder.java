package com.dis.disney.builder;

import com.dis.disney.dto.PersonanjeImgNomDTO;
import com.dis.disney.model.Personaje;

public class PersonanjeImgNomDTOBuilder {
	String imagen;
	String nombre;
	public PersonanjeImgNomDTOBuilder withPersonaje(Personaje p) {
		this.imagen=p.getImagen();
		this.nombre=p.getNombre();
		return this;
	}
	public PersonanjeImgNomDTO build() {
		PersonanjeImgNomDTO per = new PersonanjeImgNomDTO();
		per.setImagen(this.imagen);
		per.setNombre(this.nombre);
		return per; 
	}
}
