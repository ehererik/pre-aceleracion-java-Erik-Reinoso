package com.dis.disney.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dis.disney.builder.GeneroBuilder;
import com.dis.disney.builder.GeneroDTOBuilder;
import com.dis.disney.dto.GeneroDTO;
import com.dis.disney.model.Genero;
import com.dis.disney.repository.GeneroRepository;
import com.dis.disney.service.IGeneroService;
@Service
public class GeneroServiceImpl implements IGeneroService {
	
	@Autowired
	GeneroRepository generoRepository;
	@Override
	public List<GeneroDTO> findAll() {
		List<GeneroDTO> l = new ArrayList<GeneroDTO>();
		Iterator<Genero> it = generoRepository.findAll().iterator();
		GeneroDTOBuilder g=new GeneroDTOBuilder();
		while(it.hasNext()) {
			g=g.withGenero(it.next());
			l.add(g.build());
		}
		return l;
	}
	@Override
	public Genero save(GeneroDTO gen) {
		Genero g =new Genero();
		g=new GeneroBuilder().withGeneroDTO(gen).build();
		return generoRepository.save(g);
	}

	

}
