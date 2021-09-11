package com.dis.disney.builder;
import java.util.List;
import com.dis.disney.dto.IPeliculaSerieDTO;
import com.dis.disney.dto.IPeliculaSerieTit;
import com.dis.disney.dto.IPersonajeDTO;
import com.dis.disney.dto.PersonajePelisSeriesDTO;
public class PersonajePelisSeriesBuilder {

	private String nombre;
	private String imagen;
	private int edad;
	private float peso;
	private String historia;
	private List<IPeliculaSerieTit> peliculas;
	
   public PersonajePelisSeriesBuilder whitPersonajePelisSeriesBuilder(IPersonajeDTO per,List<IPeliculaSerieTit> p ) {
	   nombre=per.getNombre();
	   imagen=per.getImagen();
	   edad= per.getEdad();
	   peso= per.getPeso();
	   historia=per.getHistoria();
	   peliculas=p;
	   return this;
   }
   
   public  PersonajePelisSeriesDTO PersonajePelisSeriesBuild() {
	   PersonajePelisSeriesDTO per = new PersonajePelisSeriesDTO();
	   per.setEdad(this.edad);
	   per.setNombre(nombre);
	   per.setImagen(imagen);
	   per.setHistoria(historia);
	   per.setPeso(peso);
	   per.setPeliculas(peliculas);
	   return per;
   }
}
