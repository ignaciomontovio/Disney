package com.DisneyWorld.service;

import java.util.List;

import com.DisneyWorld.dto.GeneroDto;
import com.DisneyWorld.model.Genero;

public interface IGeneroService {

	List<Genero> findAllGenre();

	Genero saveGenre(GeneroDto generoDto);

	Genero updateGenre(Long id, GeneroDto generoDto);

	Genero deleteGenre(Long id);

}
