package com.DisneyWorld.service;

import java.util.List;

import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.dto.PersonajeDtoRes;
import com.DisneyWorld.model.Personaje;

public interface IPersonajeService {
	public List<Personaje> findAllCharacters();
	
	public Personaje saveCharacter(PersonajeDto personaje);
	public Personaje updateCharacter(Long id, PersonajeDto personajeDto);

	public Personaje deleteCharacter(Long id);

	public List<PersonajeDtoRes> findAllCharacterDtoRes();
	
}
