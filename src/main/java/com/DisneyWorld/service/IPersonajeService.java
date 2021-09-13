package com.DisneyWorld.service;

import java.util.List;

import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.dto.PersonajeDtoRes;
import com.DisneyWorld.model.Personaje;

public interface IPersonajeService {
	public List<Personaje> findAllPersonaje();
	
	public Personaje savePersonaje(PersonajeDto personaje);
	public Personaje updatePersonaje(Integer id, PersonajeDto personajeDto);

	public Personaje deletePersonaje(Integer id);

	public List<PersonajeDtoRes> findAllPersonajeDtoRes();
	
}
