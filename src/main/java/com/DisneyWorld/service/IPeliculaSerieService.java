package com.DisneyWorld.service;

import java.util.List;

import com.DisneyWorld.dto.PeliculaSerieDto;
import com.DisneyWorld.dto.PeliculaSerieDtoRes;
import com.DisneyWorld.model.PeliculaSerie;

public interface IPeliculaSerieService {
	public List<PeliculaSerie> findAllPeliculaSerie();
	
	public PeliculaSerie savePelicula(PeliculaSerieDto peliculaDto);

	public PeliculaSerie updatePelicula(Integer id,PeliculaSerieDto peliculaDto);

	public List<PeliculaSerieDtoRes> findAllPeliculaSerieDtoRes();

	public PeliculaSerie deletePelicula(Integer id);



}
