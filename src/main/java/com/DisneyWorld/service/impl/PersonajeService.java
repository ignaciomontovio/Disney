package com.DisneyWorld.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.model.Personaje;
import com.DisneyWorld.model.builder.PersonajeBuilder;
import com.DisneyWorld.repo.IPersonajeRepo;
import com.DisneyWorld.service.IPersonajeService;

@Service
public class PersonajeService implements IPersonajeService{

	@Autowired
	private IPersonajeRepo personajeRepo;

	@Override
	public List<Personaje> findAll() {
		
		List<Personaje> personajes = personajeRepo.findAll();
		return personajes;
	}

	@Override
	public Personaje savePersonaje(PersonajeDto personajeDto) {
		Personaje personaje = new PersonajeBuilder().withPersonajeDto(personajeDto).build();
		personajeRepo.save(personaje);
		return personaje;
	}

	@Override
	public Personaje updatePersonaje(Integer id, PersonajeDto personajeDto) {
		Personaje personaje = personajeRepo.getById(id);
		personaje.setEdad(personajeDto.getEdad());
		personaje.setHistoria(personajeDto.getHistoria());
		personaje.setImagen(personajeDto.getImagen());
		personaje.setNombre(personajeDto.getNombre());
		personaje.setPeso(personajeDto.getPeso());
		personajeRepo.save(personaje);
		return personaje;
	}

	@Override
	public Personaje deletePersonaje(Integer id) {
		Personaje personaje = personajeRepo.getById(id);
		personajeRepo.deleteById(id);
		return personaje;
	}
}
