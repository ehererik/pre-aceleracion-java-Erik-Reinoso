package com.dis.disney.dto;

import java.util.List;

public class PersonajePelisSeriesDTO {
	
	private String nombre;

	private int edad;

	private float peso;

	private String historia;

	private String imagen;	
	
	private List<IPeliculaSerieTit> peliculas;

	public List<IPeliculaSerieTit> getPeliculas() {
		return peliculas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public void setPeliculas(List<IPeliculaSerieTit> peliculas2) {
		this.peliculas = peliculas2;
	}
	
	
}
