package com.DisneyWorld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DisneyWorld.dto.PeliculaDto;
import com.DisneyWorld.model.Pelicula;
import com.DisneyWorld.repo.IPeliculaRepo;
import com.DisneyWorld.service.IPeliculaService;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {
	@Autowired
	private IPeliculaService peliculaService;
	
	@GetMapping( value = "/obtenerPeliculas")
	public List<Pelicula> obtenerPeliculas() {
		List<Pelicula> peliculas = peliculaService.findAll();
		return peliculas;
	}
	
	@PostMapping(value = "/crearPelicula")
	public Pelicula crearPelicula(@RequestBody PeliculaDto peliculaDto) {
		Pelicula pelicula = peliculaService.savePelicula(peliculaDto);
		return pelicula;
	}
	
}
