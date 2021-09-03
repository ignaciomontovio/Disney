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

import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.model.Personaje;
import com.DisneyWorld.repo.IPeliculaRepo;
import com.DisneyWorld.repo.IPersonajeRepo;
import com.DisneyWorld.service.IPersonajeService;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

	
	@Autowired
	private IPersonajeService personajeService;
	
	@PutMapping( value = "/actualizarPersonaje/{id}")
	public ResponseEntity<?> actualizarPersonaje(@PathVariable(value = "id")Integer id,@RequestBody PersonajeDto personajeDto) {
		
		return new ResponseEntity<>(personajeService.updatePersonaje(id,personajeDto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping( value = "/obtenerPersonajes")
	public List<Personaje> obtenerPersonajes() {
		List<Personaje> personajes = personajeService.findAll();
		return personajes;
	}
	
	@PostMapping(value = "/crearPersonaje")
	public ResponseEntity<?> crearPersonaje(@RequestBody PersonajeDto personajeDto){
		System.out.println(personajeDto);
		Personaje personaje = personajeService.savePersonaje(personajeDto);
		
		return new ResponseEntity<>(personaje,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/eliminarPersonaje/{id}")
	public ResponseEntity<?> eliminarPersonaje(@PathVariable(value = "id")Integer id){
		Personaje personaje = personajeService.deletePersonaje(id);
		return new ResponseEntity<>(personaje,HttpStatus.OK);
	}
}
