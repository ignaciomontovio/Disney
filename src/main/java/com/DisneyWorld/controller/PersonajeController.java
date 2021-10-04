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
import com.DisneyWorld.service.IPersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeController {
	
	@Autowired
	private IPersonajeService personajeService;

	
	@GetMapping(value ="")
	public ResponseEntity<?> getCharactersDtoRes(){
		return new ResponseEntity<>(personajeService.findAllCharacterDtoRes(),HttpStatus.OK);
	}
	
	@PutMapping( value = "/{id}")
	public ResponseEntity<?> updateCharacter(@PathVariable(value = "id")Long id,@RequestBody PersonajeDto personajeDto) {
		return new ResponseEntity<>(personajeService.updateCharacter(id,personajeDto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping( value = "/")
	public ResponseEntity<?> getCharacters() {
		List<Personaje> personajes = personajeService.findAllCharacters();
		return new ResponseEntity<>(personajes,HttpStatus.OK);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<?> createCharacter(@RequestBody PersonajeDto personajeDto){
		return new ResponseEntity<>(personajeService.saveCharacter(personajeDto),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCharacter(@PathVariable(value = "id")Long id){
		return new ResponseEntity<>(personajeService.deleteCharacter(id),HttpStatus.OK);
	}
	
}
