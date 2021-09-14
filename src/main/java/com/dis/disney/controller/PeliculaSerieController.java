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

import com.dis.disney.dto.PeliculaSerieDTO;
import com.dis.disney.service.IPeliculaSerieService;
@RequestMapping("/movies")
@RestController
@CrossOrigin("*")
public class PeliculaSerieController  {
	@Autowired
	IPeliculaSerieService peliculaSerieService;
	

	@PostMapping
	public ResponseEntity<?> savePelicula(@RequestBody PeliculaSerieDTO peli){
		return new ResponseEntity<>(peliculaSerieService.SavePeliculaSerie(peli),HttpStatus.OK);
	}
	
	@GetMapping("/details")
	public ResponseEntity<?> detailsMovie( @RequestParam String id){
		return new ResponseEntity<>(peliculaSerieService.details(id),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<?> getMovie( @RequestParam Optional<String> genre,  @RequestParam Optional<String> title ,  @RequestParam Optional<String> order ){
		return new ResponseEntity<>(peliculaSerieService.getRequest(genre, title ,order),HttpStatus.OK);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<?> updateMovie(@RequestBody PeliculaSerieDTO peliculaSerieDTO, @PathVariable(value="id") long id ){
		return new ResponseEntity<>(peliculaSerieService.update(peliculaSerieDTO, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable(value="id") long id ){
		peliculaSerieService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
