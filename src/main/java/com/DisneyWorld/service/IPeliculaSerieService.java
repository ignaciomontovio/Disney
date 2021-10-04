package com.DisneyWorld.service;

import java.util.List;

import com.DisneyWorld.dto.PeliculaSerieDto;
import com.DisneyWorld.dto.PeliculaSerieDtoRes;
import com.DisneyWorld.model.PeliculaSerie;

public interface IPeliculaSerieService {
	public List<PeliculaSerie> findAllMovieSerie();
	
	public PeliculaSerie saveMovieSerie(PeliculaSerieDto peliculaDto);

	public PeliculaSerie updateMovieSerie(Long id,PeliculaSerieDto peliculaDto);

	public List<PeliculaSerieDtoRes> findAllMovieSerieDtoRes();

	public PeliculaSerie deleteMovieSerie(Long id);

	public List<PeliculaSerie> findByTitulo(String nombre);



}
