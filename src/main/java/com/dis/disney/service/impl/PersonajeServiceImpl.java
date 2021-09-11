package com.dis.disney.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.dis.disney.builder.PeliculaSeriePersonajeBuilder;
import com.dis.disney.builder.PersonajeBuilder;
import com.dis.disney.builder.PersonajePelisSeriesBuilder;
import com.dis.disney.builder.PersonanjeImgNomDTOBuilder;
import com.dis.disney.dto.IPeliculaSerieDTO;
import com.dis.disney.dto.IPeliculaSerieTit;
import com.dis.disney.dto.IPersonajeDTO;
import com.dis.disney.dto.IPesonajeNomImgDTO;
import com.dis.disney.dto.PeliSeriePersonajesDTO;
import com.dis.disney.dto.PeliculaSerieDTO;
import com.dis.disney.dto.PersonajeDTO;
import com.dis.disney.dto.PersonajePelisSeriesDTO;
import com.dis.disney.dto.PersonanjeImgNomDTO;
import com.dis.disney.model.PeliculaSerie;
import com.dis.disney.model.Personaje;
import com.dis.disney.repository.PeliculaSerieRepository;
import com.dis.disney.repository.PersonajeRepository;
import com.dis.disney.service.IPersonajeService;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
	@Autowired
	private PersonajeRepository personajeRepository;
	@Autowired
	private PeliculaSerieRepository peliculaRepository;
	
	@Override

	public List<IPesonajeNomImgDTO> findAll() {
		return personajeRepository.listAll();
	}
/*	@Override
	public List<PersonanjeImgNomDTO> getList(){
		List<Personaje> l= personajeRepository.findAll();
		List<PersonanjeImgNomDTO> lDTO = new ArrayList<PersonanjeImgNomDTO>();
		Personaje p;
		Iterator<Personaje> it1 = l.iterator();
		PersonanjeImgNomDTOBuilder b=new PersonanjeImgNomDTOBuilder();
		while(it1.hasNext()) {
		p=it1.next();
		b.withPersonaje(p);
		lDTO.add(b.build());
		}
		return lDTO;
	}
*/
	@Override
	public Personaje savePersonaje(PersonajeDTO per) {
		PersonajeBuilder b= new PersonajeBuilder();
		b=b.withPersonajeDTO(per);
		Personaje personaje = b.build();
		personaje.setLikedPeliculaSerie(new HashSet<PeliculaSerie>());
		Iterator<Long> it = per.getLikedPeliculaSerie().iterator();
		while(it.hasNext()) {
			personaje.getLikedPeliculaSerie().add(peliculaRepository.findById(it.next()).get());
		}
		return personajeRepository.save(personaje);
	}
	@Override
	public List<IPesonajeNomImgDTO> getRequest(Optional<String> name, Optional<String> age, Optional<String> movies) {
		
		if(age.isPresent())
			return personajeRepository.listAllByAge(Integer.parseInt(Objects.requireNonNull(age.get())));
		else if(name.isPresent())
			return personajeRepository.listAllContainsName(name.get());
		else if (movies.isPresent())
			return personajeRepository.listAllByMovie(Integer.parseInt(Objects.requireNonNull(movies.get())));
		else
			return personajeRepository.listAll();
	}
	
	public PersonajePelisSeriesDTO details(String id) {
		IPersonajeDTO per;
		per = personajeRepository.findIPersonajeByID(Long.parseLong(id));
		List<IPeliculaSerieTit> lp = new ArrayList<IPeliculaSerieTit>();
		lp =peliculaRepository.findByPersonajeId(Long.parseLong(id));
		PersonajePelisSeriesBuilder bu2 = new PersonajePelisSeriesBuilder();
		bu2=bu2.whitPersonajePelisSeriesBuilder(per, lp);
		PersonajePelisSeriesDTO psp=bu2.PersonajePelisSeriesBuild();
		return  psp;
	}
	public Personaje update(PersonajeDTO personajeDTO, long id) {
		Personaje per= new Personaje();
		per=personajeRepository.findById(id).get();
		if(personajeDTO.getEdad()>0)
			per.setEdad(personajeDTO.getEdad());
		if(personajeDTO.getHistoria()!=null) 
			per.setHistoria(personajeDTO.getHistoria());
		if(personajeDTO.getNombre()!=null)
			per.setNombre(personajeDTO.getNombre());
		if(personajeDTO.getPeso()>0)
			per.setPeso(personajeDTO.getPeso());
		if(personajeDTO.getImagen()!=null)
			per.setImagen(personajeDTO.getImagen());
		if(personajeDTO.getLikedPeliculaSerie()!=null && !personajeDTO.getLikedPeliculaSerie().isEmpty()) {
			 Iterator <Long> it = personajeDTO.getLikedPeliculaSerie().iterator();
			 while(it.hasNext()) {
				 per.getLikedPeliculaSerie().add(peliculaRepository.findById(it.next()).get());
			 }
		}
		return per;
	}
	@Override
	public void delete(long id) {
		personajeRepository.deleteById(id);
	}
}
