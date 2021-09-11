package com.dis.disney.dto;

import java.util.Date;
import java.util.List;

public interface IPeliculaSeriePersonajeDTO {
	
	public String getImagen();
	public Date getFecha_creacion() ;
	public String getTitulo();
	public int getCalificacion();
	public List<IPersonajeDTO> getListIPersonajeDTO();
}
