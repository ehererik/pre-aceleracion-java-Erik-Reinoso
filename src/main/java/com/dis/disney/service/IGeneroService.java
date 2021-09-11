package com.dis.disney.service;

import java.util.List;

import com.dis.disney.model.Genero;
import com.dis.disney.dto.GeneroDTO;

public interface IGeneroService {
	
	List<GeneroDTO> findAll();
	public Genero save(GeneroDTO gen);
}
