package com.DisneyWorld.service;

import java.util.List;

import com.DisneyWorld.dto.GeneroDto;
import com.DisneyWorld.model.Genero;

public interface IGeneroService {

	List<Genero> findAllGenero();

	Genero saveGenero(GeneroDto generoDto);

	Genero updateGenero(Integer id, GeneroDto generoDto);

	Genero deleteGenero(Integer id);

}
