package com.DisneyWorld.controller;

import java.util.ArrayList;
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

import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.dto.PersonajeDtoRes;
import com.DisneyWorld.model.Personaje;
import com.DisneyWorld.model.builder.PersonajeBuilder;
import com.DisneyWorld.repo.IPeliculaSerieRepo;
import com.DisneyWorld.repo.IPersonajeRepo;
import com.DisneyWorld.service.IPersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {

	
	@Autowired
	private IPersonajeService personajeService;
	
	@Autowired
	private IPersonajeRepo personajeRepo;
	
	@GetMapping(value ="")
	public ResponseEntity<?> obtenerPersonajesFiltrado(){
		List<PersonajeDtoRes> personajesDtoRes = personajeService.findAllPersonajeDtoRes();
		
		return new ResponseEntity<>(personajesDtoRes,HttpStatus.OK);
	}
	
	@PutMapping( value = "/actualizarPersonaje/{id}")
	public ResponseEntity<?> actualizarPersonaje(@PathVariable(value = "id")Integer id,@RequestBody PersonajeDto personajeDto) {
		
		return new ResponseEntity<>(personajeService.updatePersonaje(id,personajeDto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping( value = "/obtenerPersonajes")
	public ResponseEntity<?> obtenerPersonajes() {
		List<Personaje> personajes = personajeService.findAllPersonaje();
		return new ResponseEntity<>(personajes,HttpStatus.OK);
	}
	
	@PostMapping(value = "/crearPersonaje")
	public ResponseEntity<?> crearPersonaje(@RequestBody PersonajeDto personajeDto){
		Personaje personaje = personajeService.savePersonaje(personajeDto);
		return new ResponseEntity<>(personajeDto,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/eliminarPersonaje/{id}")
	public ResponseEntity<?> eliminarPersonaje(@PathVariable(value = "id")Integer id){
		Personaje personaje = personajeService.deletePersonaje(id);
		return new ResponseEntity<>(personaje,HttpStatus.OK);
	}
	
	
	
	
}
