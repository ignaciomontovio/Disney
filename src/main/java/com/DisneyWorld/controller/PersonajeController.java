package com.DisneyWorld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DisneyWorld.model.Personaje;
import com.DisneyWorld.repo.IPeliculaRepo;
import com.DisneyWorld.repo.IPersonajeRepo;
import com.DisneyWorld.service.IPersonajeService;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

	
	@Autowired
	private IPersonajeService personajeService;
	
	@PostMapping( value = "/actualizarPersonaje")
	public String updatePerson(@RequestBody Personaje personaje) {
		System.out.println(personaje);
		return "ok";
	}
	
	@GetMapping( value = "/obtenerPersonajes")
	public List<Personaje> obtenerPersonajes() {
		List<Personaje> personajes = personajeService.findAll();
		return personajes;
	}
	
}
