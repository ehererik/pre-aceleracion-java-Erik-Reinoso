package com.dis.disney.service;
import java.util.List;
import java.util.Optional;

import com.dis.disney.dto.IPeliculaSerieDTO;
import com.dis.disney.dto.PeliSeriePersonajesDTO;
import com.dis.disney.dto.PeliculaSerieDTO;
import com.dis.disney.dto.PeliculaSerieImgTitFecDTO;
import com.dis.disney.model.PeliculaSerie;
public interface IPeliculaSerieService {
	
	public List<PeliculaSerieImgTitFecDTO> listar();
	public List<PeliculaSerie> findAll();
	public PeliculaSerie SavePeliculaSerie(PeliculaSerieDTO p);
	public PeliSeriePersonajesDTO details(String id);
	public List<IPeliculaSerieDTO> PeliPorGenero(Optional<String> genre, Optional<String> titulo , Optional<String> order);
	//public List<IPeliculaSerieImgTitFecDTO> listImgTitFech();
	public PeliculaSerie update(PeliculaSerieDTO peliculaSerieDTO, long id);
	public void delete(long id);
}
