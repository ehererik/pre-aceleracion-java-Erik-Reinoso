package com.dis.disney.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "personaje")
public class Personaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column()
	private String nombre;
	@Column()
	private int edad;
	@Column()
	private float peso;
	@Column()
	private String historia;
	@Column()
	private String imagen;	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			  name = "peli_serie_like", 
			  joinColumns = @JoinColumn(name = "personaje_id"), 
			  inverseJoinColumns = @JoinColumn(name = "pelicula_serie_id"))
	@JsonManagedReference
	private Set<PeliculaSerie> likedPeliculaSerie;
	
	public Set<PeliculaSerie> getLikedPeliculaSerie() {
		return likedPeliculaSerie;
	}
	public void setLikedPeliculaSerie(Set<PeliculaSerie> likedPeliculaSerie) {
		this.likedPeliculaSerie = likedPeliculaSerie;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Personaje(Long id, String nombre, int edad, float peso, String historia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
	}
	public Personaje() {

	}
	
	
}
