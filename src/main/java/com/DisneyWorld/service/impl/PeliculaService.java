package com.DisneyWorld.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DisneyWorld.dto.PeliculaDto;
import com.DisneyWorld.model.Pelicula;
import com.DisneyWorld.repo.IPeliculaRepo;
import com.DisneyWorld.service.IPeliculaService;

@Service
public class PeliculaService implements IPeliculaService{

	@Autowired
	private IPeliculaRepo peliculaRepo;
	
	public List<Pelicula> findAll(){
		
		
		return null;
	}

	@Override
	public Pelicula save(PeliculaDto peliculaDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
