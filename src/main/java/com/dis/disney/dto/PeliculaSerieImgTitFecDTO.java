package com.dis.disney.dto;

import java.util.Date;

public class PeliculaSerieImgTitFecDTO {
	
	public PeliculaSerieImgTitFecDTO(String imagen, Date fecha, String titulo) {
		super();
		this.imagen = imagen;
		this.fecha = fecha;
		this.titulo = titulo;
	}


	private String imagen;
	private Date fecha;
	private String titulo;
	



	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public PeliculaSerieImgTitFecDTO() {
		// TODO Auto-generated constructor stub
	}

}
