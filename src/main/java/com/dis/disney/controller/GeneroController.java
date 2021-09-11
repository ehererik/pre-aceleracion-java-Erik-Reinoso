package com.dis.disney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dis.disney.dto.GeneroDTO;
import com.dis.disney.service.IGeneroService;

@RestController
@RequestMapping("/genero")
@CrossOrigin("*")
public class GeneroController {
	@Autowired
	IGeneroService generoService;
	@GetMapping
	public ResponseEntity<?> getGenero(){
		return new ResponseEntity<>(generoService.findAll(),HttpStatus.OK);
	}
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody GeneroDTO gen){
		return new ResponseEntity<>(generoService.save(gen),HttpStatus.OK);
	}
}
