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
		
		int edad = personajeDto.getEdad();
		float peso = personajeDto.getPeso();
		
		String historia = personajeDto.getHistoria(),
				imagen = personajeDto.getImagen(),
				nombre = personajeDto.getNombre();
		if(edad != 0)
			personaje.setEdad(edad);
		if(historia != null )
			personaje.setHistoria(historia);
		if(imagen != null)
			personaje.setImagen(imagen);
		if(nombre != null)
			personaje.setNombre(nombre);
		if(peso != 0)
			personaje.setPeso(peso);
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
