package com.DisneyWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DisneyWorld.dto.GeneroDto;
import com.DisneyWorld.service.IGeneroService;

@RestController
@RequestMapping("/genre")
public class GeneroController {
	@Autowired
	private IGeneroService generoService;
	
	@GetMapping( value = "/")
	public ResponseEntity<?> getGenre() {
		return new ResponseEntity<>(generoService.findAllGenre(),HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<?> createGenre(@RequestBody GeneroDto generoDto) {
		return new ResponseEntity<>(generoService.saveGenre(generoDto),HttpStatus.ACCEPTED);
	}
	
	@PutMapping( value = "/{id}")
	public ResponseEntity<?> updateGenre(@PathVariable(value = "id")Long id,@RequestBody GeneroDto generoDto) {
		return new ResponseEntity<>(generoService.updateGenre(id,generoDto),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGenre(@PathVariable(value = "id")Long id){
		return new ResponseEntity<>(generoService.deleteGenre(id),HttpStatus.ACCEPTED);
	}
}
