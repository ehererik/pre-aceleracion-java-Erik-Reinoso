package com.dis.disney.service;


import java.util.List;
import java.util.Optional;

import com.dis.disney.dto.IPesonajeNomImgDTO;
import com.dis.disney.dto.PeliculaSerieDTO;
import com.dis.disney.dto.PersonajeDTO;
import com.dis.disney.dto.PersonajePelisSeriesDTO;
import com.dis.disney.dto.PersonanjeImgNomDTO;
import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.model.Personaje;

public interface IPersonajeService {
	public List<IPesonajeNomImgDTO> findAll();
	public Personaje savePersonaje(PersonajeDTO per);
	//public List<IPersonanjeImgNomDTO> getList();
	public List<IPesonajeNomImgDTO>getRequest (Optional<String> name,Optional<String> age,Optional<String> movies);
	public PersonajePelisSeriesDTO details(String id);
	public Personaje update(PersonajeDTO personajeDTO, long id);
	public void delete(long id);
}
