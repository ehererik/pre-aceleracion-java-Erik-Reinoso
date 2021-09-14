package com.dis.disney.builder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.dis.disney.dto.PeliSeriePersonajesDTO;
import com.dis.disney.dto.interfaces.IPeliculaSerieDTO;
import com.dis.disney.dto.interfaces.IPersonajeDTO;

public class PeliculaSeriePersonajeBuilder {
	private String imagen;
	private int calificacion;
	private String titulo;
	private Date fechaD;
	private List <IPersonajeDTO> li;
	SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
	
	public PeliculaSeriePersonajeBuilder withPeliSerieDTOYPersonajeDTO(IPeliculaSerieDTO p,List<IPersonajeDTO> l) {
	 this.imagen=p.getImagen();
	 this.calificacion=p.getCalificacion();
	 this.titulo=p.getTitulo();
	 this.fechaD=p.getFecha_creacion();
	 this.li=l;
	 return this;
	}

	public PeliSeriePersonajesDTO PeliculaSeriePersonajeBuild() {
		PeliSeriePersonajesDTO p = new PeliSeriePersonajesDTO();
		p.setCalifiacion(calificacion);
		p.setFechaCreacion(fechaD);
		p.setImagen(imagen);
		p.setTitulo(titulo);
		p.setPersonajes(li);
		return p;
	}

	public PeliculaSeriePersonajeBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}
}
