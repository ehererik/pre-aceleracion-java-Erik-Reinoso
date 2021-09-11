package com.dis.disney.dto;

import java.util.Date;
import java.util.Set;


public class PeliculaSerieDTO {
	private int califiacion=0;
	private String fecha_creacion;
	private String titulo;
	private String imagen;
	private Set<Long> likedGenero;
	


	public int getCalificacion() {
		return califiacion;
	}

	public void setCalificacion(int califiacion) {
		this.califiacion = califiacion;
	}

	public String getFecha() {
		return fecha_creacion;
	}

	public void setFecha(String fecha) {
		this.fecha_creacion = fecha;
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

	public Set<Long> getLikedGenero() {
		return likedGenero;
	}

	public void setLikedGenero(Set<Long> likedGenero) {
		this.likedGenero = likedGenero;
	}

	public PeliculaSerieDTO() {
	}

}
