package com.dis.disney.model;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.fasterxml.jackson.annotation.JsonIgnore;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table (name="pelicula_serie")
public class PeliculaSerie {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column()
	private String imagen;
	
	@Column
	private String titulo;
	
	@Column(name ="fecha_creacion")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonIgnoreProperties
	private Date fechaCreacion;
	
	@Column
	private int calificacion;
	

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(
			  name = "genero_like", 
			  joinColumns = @JoinColumn(name = "pelicula_serie_id"), 
			  inverseJoinColumns = @JoinColumn(name = "genero_id"))
	@JsonManagedReference
	Set<Genero> likedGenero;
	
	@ManyToMany(mappedBy = "likedPeliculaSerie")
	@JsonBackReference
	Set<Personaje> likes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public PeliculaSerie(long id) {
		this.id=id;
	}

	public PeliculaSerie(long id, String imagen, String titulo, Date fechaCreacion, int calificacion) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
	}
	public Set<Personaje> getLikes() {
		return likes;
	}

	public void setLikes(Set<Personaje> likes) {
		this.likes = likes;
	}

	public Set<Genero> getLikedGenero() {
		return likedGenero;
	}

	public void setLikedGenero(Set<Genero> likedGenero) {
		this.likedGenero = likedGenero;
	}

	public PeliculaSerie() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
