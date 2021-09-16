package com.DisneyWorld.controller;

import java.util.List;

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
import com.DisneyWorld.model.Genero;
import com.DisneyWorld.service.IGeneroService;

@RestController
@RequestMapping("/genre")
public class GeneroController {
	@Autowired
	private IGeneroService generoService;
	
	@GetMapping( value = "/obtenerGeneros")
	public ResponseEntity<?> obtenerGeneros() {
		List<Genero> generos = generoService.findAllGenero();
		return new ResponseEntity<>(generos,HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/crearGenero")
	public ResponseEntity<?> crearGenero(@RequestBody GeneroDto generoDto) {
		Genero genero = generoService.saveGenero(generoDto);
		return new ResponseEntity<>(genero,HttpStatus.ACCEPTED);
	}
	
	@PutMapping( value = "/actualizarGenero/{id}")
	public ResponseEntity<?> actualizarGeneros(@PathVariable(value = "id")Integer id,@RequestBody GeneroDto generoDto) {
		Genero genero = generoService.updateGenero(id,generoDto);
	
		return new ResponseEntity<>(genero,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/eliminarGenero/{id}")
	public ResponseEntity<?> eliminarGenero(@PathVariable(value = "id")Integer id){
		Genero genero = generoService.deleteGenero(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
