package com.DisneyWorld.service;

import java.util.List;

import com.DisneyWorld.dto.PeliculaDto;
import com.DisneyWorld.model.Pelicula;

public interface IPeliculaService {
	public List<Pelicula> findAll();
	
	public Pelicula save(PeliculaDto peliculaDto);
}
