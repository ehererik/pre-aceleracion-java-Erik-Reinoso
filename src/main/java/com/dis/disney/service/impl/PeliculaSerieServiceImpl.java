package com.dis.disney.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dis.disney.builder.PeliculaSerieBuilder;
import com.dis.disney.builder.PeliculaSeriePersonajeBuilder;
import com.dis.disney.dto.PeliSeriePersonajesDTO;
import com.dis.disney.dto.PeliculaSerieDTO;
import com.dis.disney.dto.interfaces.IPeliculaSerieDTO;
import com.dis.disney.dto.interfaces.IPersonajeDTO;
import com.dis.disney.model.Genero;
import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.repository.GeneroRepository;
import com.dis.disney.repository.PeliculaSerieRepository;
import com.dis.disney.repository.PersonajeRepository;
import com.dis.disney.service.IPeliculaSerieService;

@Service
public class PeliculaSerieServiceImpl implements IPeliculaSerieService {
	@Autowired
	private PeliculaSerieRepository peliculaSerieRepository;
	@Autowired
	private GeneroRepository generoRepository;
	@Autowired
	private PersonajeRepository personajeRespository;
	
	
	@Override
	public PeliculaSerie SavePeliculaSerie(PeliculaSerieDTO p) {
		PeliculaSerie peli = new PeliculaSerieBuilder().withPeliculaSerieDTO(p).buildPS();
		peli.setLikedGenero( new HashSet<Genero>());
		if(p.getLikedGenero()!=null) {
			Iterator<Long> it =p.getLikedGenero().iterator();
			while(it.hasNext()) {
				long indice=it.next();
				peli.getLikedGenero().add(generoRepository.findById(indice).get());
			}
		}
		return peliculaSerieRepository.save(peli);
	}

	@Override
	public PeliSeriePersonajesDTO details(String id) {
		IPeliculaSerieDTO peli;
		peli=peliculaSerieRepository.buscaPorID(Long.parseLong(id));
		List<IPersonajeDTO> lp = new ArrayList<IPersonajeDTO>();
		lp = personajeRespository.findAllByPeliculaSerieId(Long.parseLong(id));
		PeliculaSeriePersonajeBuilder bu2 = new PeliculaSeriePersonajeBuilder();
		bu2=bu2.withPeliSerieDTOYPersonajeDTO(peli, lp);
		PeliSeriePersonajesDTO psp=bu2.PeliculaSeriePersonajeBuild();
		psp.setGeneros(generoRepository.buscaPorID(Long.parseLong(id)));
		return  psp;
	}
	
	public List<IPeliculaSerieDTO> getRequest(Optional<String> genre, Optional<String> title , Optional<String> order){
			if(genre.isPresent())
				return peliculaSerieRepository.peliPorGenero(Long.parseLong(Objects.requireNonNull(genre.get())));
			else if(title.isPresent())
				return peliculaSerieRepository.peliPorTitulo(title.get());
			else if(order.isPresent()) {
				if(order.get().equals("ASC")) 
					return peliculaSerieRepository.listImgTitFechAsc();
				else
					return peliculaSerieRepository.listImgTitFechDesc();
			}
			else
				return peliculaSerieRepository.listImgTitFech();
	}

	@Override
	public PeliculaSerie update(PeliculaSerieDTO peliculaSerieDTO, long id) {
		PeliculaSerie peli= new PeliculaSerie();
		peli=peliculaSerieRepository.findById(id).get();
		if(peliculaSerieDTO.getCalificacion()>0 && peliculaSerieDTO.getCalificacion()<6)
			peli.setCalificacion(peliculaSerieDTO.getCalificacion());
		if(peliculaSerieDTO.getFecha()!=null) {
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
			try {
				peli.setFechaCreacion(formato.parse(peliculaSerieDTO.getFecha()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(peliculaSerieDTO.getImagen()!=null)
			peli.setImagen(peliculaSerieDTO.getImagen());
		if(peliculaSerieDTO.getImagen()!=null)
			peli.setImagen(peliculaSerieDTO.getImagen());
		if(peliculaSerieDTO.getTitulo()!=null)
			peli.setTitulo(peliculaSerieDTO.getTitulo());
		if(peliculaSerieDTO.getLikedGenero()!=null && !peliculaSerieDTO.getLikedGenero().isEmpty()) {
			peli.setLikedGenero(new HashSet<Genero>());
			Iterator<Long> it =peliculaSerieDTO.getLikedGenero().iterator();
			while(it.hasNext()) {
				long indice=it.next();
				peli.getLikedGenero().add(generoRepository.findById(indice).get());
		}
		
	}
		return peliculaSerieRepository.save(peli);
  }
	
	public void delete(long id) {
		peliculaSerieRepository.deleteById(id);
	}
}