package com.dis.disney.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dis.disney.dto.IPersonajeDTO;
import com.dis.disney.dto.PeliculaSerieDTO;
import com.dis.disney.dto.PersonajeDTO;
import com.dis.disney.service.IPersonajeService;

@RestController
@RequestMapping("/characters")
@CrossOrigin("*")
public class PersonajeController {
	
	@Autowired
	private IPersonajeService personajeService;
	

	@GetMapping
	public ResponseEntity<?> getMovie( @RequestParam Optional<String> name,  @RequestParam Optional<String> age ,  @RequestParam Optional<String> movies ){
		return new ResponseEntity<>(personajeService.getRequest(name, age ,movies),HttpStatus.OK);
	}
	
	@GetMapping("/details")
	public ResponseEntity<?> detailsMovie( @RequestParam String id){
		return new ResponseEntity<>(personajeService.details(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> SavePersonaje( @RequestBody PersonajeDTO pDTO) {
		return new ResponseEntity<>(personajeService.savePersonaje(pDTO),HttpStatus.OK);
	}
	@PutMapping ("/{id}")
	public ResponseEntity<?> updatePersonaje(@RequestBody PersonajeDTO personajeDTO, @PathVariable(value="id") long id ){
		return new ResponseEntity<>(personajeService.update(personajeDTO, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable(value="id") long id ){
		personajeService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
