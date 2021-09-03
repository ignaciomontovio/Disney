package com.DisneyWorld.service;

import java.util.List;

import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.model.Personaje;

public interface IPersonajeService {
	public List<Personaje> findAll();
	
	public Personaje savePersonaje(PersonajeDto personaje);
	public Personaje updatePersonaje(Integer id, PersonajeDto personajeDto);

	public Personaje deletePersonaje(Integer id);
	
}
