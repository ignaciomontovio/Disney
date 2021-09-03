package com.DisneyWorld.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DisneyWorld.dto.PeliculaDto;
import com.DisneyWorld.model.Pelicula;
import com.DisneyWorld.model.builder.PeliculaBuilder;
import com.DisneyWorld.repo.IGeneroRepo;
import com.DisneyWorld.repo.IPeliculaRepo;
import com.DisneyWorld.service.IPeliculaService;

@Service
public class PeliculaService implements IPeliculaService{

	@Autowired
	private IPeliculaRepo peliculaRepo;
	
	@Autowired
	private IGeneroRepo generoRepo;
	
	public List<Pelicula> findAll(){
		List<Pelicula> peliculas = peliculaRepo.findAll();
		return peliculas;
	}

	@Override
	public Pelicula savePelicula(PeliculaDto peliculaDto) {
		
		Pelicula pelicula = new PeliculaBuilder().withSerieDto(peliculaDto).build();
		//pelicula.setGeneros(generoRepo.findById(peliculaDto.getGenero()).get());
		
		return peliculaRepo.save(pelicula);
	}
}
