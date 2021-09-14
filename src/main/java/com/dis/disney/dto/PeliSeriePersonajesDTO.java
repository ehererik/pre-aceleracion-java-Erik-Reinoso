package com.dis.disney.dto;

import java.util.Date;
import java.util.List;
import com.dis.disney.dto.interfaces.IGeneroNomDTO;
import com.dis.disney.dto.interfaces.IPersonajeDTO;

public class PeliSeriePersonajesDTO {

	private int calificacion;
	private Date fechaCreacion = new Date();
	private String titulo;
	private String imagen;
	private List<IGeneroNomDTO> generos;
	private List<IPersonajeDTO> personajes;

	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public int getCalifiacion() {
		return calificacion;
	}
	public void setCalifiacion(int califiacion) {
		this.calificacion = califiacion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<IGeneroNomDTO> getGeneros() {
		return generos;
	}
	public void setGeneros(List<IGeneroNomDTO> generos) {
		this.generos = generos;
	}
	public List<IPersonajeDTO> getPersonajes() {
		return personajes;
	}
	public void setPersonajes(List<IPersonajeDTO> personajes) {
		this.personajes = personajes;
	}
	public PeliSeriePersonajesDTO() {
		// TODO Auto-generated constructor stub
	}

}
