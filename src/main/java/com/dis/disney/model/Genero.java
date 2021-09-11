package com.dis.disney.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
@Table (name ="genero")
public class Genero implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	
	public Genero(long id, Set<PeliculaSerie> likes, String nombre, String imagen) {
		super();
		this.id = id;
		this.likes = likes;
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public Set<PeliculaSerie> getLikes() {
		return likes;
	}

	public void setLikes(Set<PeliculaSerie> likes) {
		this.likes = likes;
	}

	@Column()
	private String nombre;
	
	@Column()
	private String imagen;

	@ManyToMany(mappedBy = "likedGenero")
	@JsonBackReference
	private Set<PeliculaSerie> likes;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Genero(int id, String nombre, String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
	}

	public Genero() {

	}
	
	
}
