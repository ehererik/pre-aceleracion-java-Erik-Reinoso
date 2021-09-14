package com.dis.disney.builder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.dis.disney.dto.PeliculaSerieDTO;
import com.dis.disney.model.PeliculaSerie;
public  class PeliculaSerieBuilder {
	private long id;
	private String imagen;
	private int calificacion;
	private String titulo;
	private Date fechaD;
	SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
	
	public PeliculaSerieBuilder withPeliculaSerie(PeliculaSerie p) {
		this.id=p.getId();
		this.imagen=p.getImagen();
		this.calificacion=p.getCalificacion();
		this.titulo=p.getTitulo();
		this.fechaD=p.getFechaCreacion();
		return this;
	}
	public PeliculaSerieBuilder withPeliculaSerieDTO(PeliculaSerieDTO p) {
		System.out.println(p.getFecha());
		this.imagen=p.getImagen();
		this.calificacion=p.getCalificacion();
		this.titulo=p.getTitulo();
		if(p.getFecha()!=null) {
			try {
				this.fechaD=formato.parse(p.getFecha());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this;
	}
	
	public PeliculaSerie buildPS() {
		PeliculaSerie p= new PeliculaSerie();
		p.setCalificacion(this.calificacion);
		p.setFechaCreacion(fechaD);
		p.setId(id);
		p.setImagen(imagen);
		p.setTitulo(titulo);
		return p;
	}
	
	public PeliculaSerieDTO buildPSDTO() {
		PeliculaSerieDTO p= new PeliculaSerieDTO();
		p.setCalificacion(this.calificacion);
		p.setImagen(imagen);
		p.setTitulo(titulo);
		return p;
	}
	
	
}
