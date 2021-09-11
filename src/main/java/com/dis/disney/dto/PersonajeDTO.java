package com.dis.disney.dto;

import java.util.Set;




public class PersonajeDTO {



	public Set<Long> getLikedPeliculaSerie() {
		return likedPeliculaSerie;
	}

	public void setLikedPeliculaSerie(Set<Long> likedPeliculaSerie) {
		this.likedPeliculaSerie = likedPeliculaSerie;
	}
	private long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	private String nombre;
	private int edad;
	private float peso;
	private String historia;
	private String imagen;
	private Set<Long> likedPeliculaSerie;
	
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

	public PersonajeDTO() {

	}

}
