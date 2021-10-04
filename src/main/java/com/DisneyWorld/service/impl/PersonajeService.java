package com.DisneyWorld.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.dto.PersonajeDtoRes;
import com.DisneyWorld.model.PeliculaSerie;
import com.DisneyWorld.model.Personaje;
import com.DisneyWorld.model.builder.PersonajeBuilder;
import com.DisneyWorld.repo.IPeliculaSerieRepo;
import com.DisneyWorld.repo.IPersonajeRepo;
import com.DisneyWorld.service.IPersonajeService;

@Service
public class PersonajeService implements IPersonajeService{

	@Autowired
	private IPersonajeRepo personajeRepo;

	@Autowired
	private IPeliculaSerieRepo peliculaRepo;

	@Override
	public List<Personaje> findAllCharacters() {
		
		List<Personaje> personajes = personajeRepo.findAll();
		return personajes;
	}

	@Override
	public Personaje saveCharacter(PersonajeDto personajeDto) {
		Personaje personaje = new PersonajeBuilder().withPersonajeDto(personajeDto).build();
		personajeRepo.save(personaje);
		return personaje;
	}

	@Override
	public Personaje updateCharacter(Long id, PersonajeDto personajeDto) {
		
		Personaje personaje = personajeRepo.findById(id).get();
		
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
	public Personaje deleteCharacter(Long id) {
		Personaje personaje = personajeRepo.findById(id).get();
		personajeRepo.deleteById(id);
		return personaje;
	}

	@Override
	public List<PersonajeDtoRes> findAllCharacterDtoRes() {
		List<Personaje> personajes = personajeRepo.findAll();
		List<PersonajeDtoRes> personajesDtoRes = new ArrayList<PersonajeDtoRes>();
		if(personajes != null)
			for (Personaje personaje : personajes) {
				personajesDtoRes.add(new PersonajeBuilder().withPersonajeDtoRes(personaje).buildRes());
			}
		return personajesDtoRes;
	}
}
