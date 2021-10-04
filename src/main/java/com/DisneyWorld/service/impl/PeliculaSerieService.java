package com.DisneyWorld.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DisneyWorld.dto.PeliculaSerieDto;
import com.DisneyWorld.dto.PeliculaSerieDtoRes;
import com.DisneyWorld.model.Genero;
import com.DisneyWorld.model.PeliculaSerie;
import com.DisneyWorld.model.Personaje;
import com.DisneyWorld.model.builder.PeliculaSerieBuilder;
import com.DisneyWorld.model.builder.PersonajeBuilder;
import com.DisneyWorld.repo.IGeneroRepo;
import com.DisneyWorld.repo.IPeliculaSerieRepo;
import com.DisneyWorld.service.IPeliculaSerieService;

@Service
public class PeliculaSerieService implements IPeliculaSerieService{

	@Autowired
	private IPeliculaSerieRepo peliculaSerieRepo;
	
	@Autowired
	private IGeneroRepo generoRepo;
	
	public List<PeliculaSerie> findAllMovieSerie(){
		List<PeliculaSerie> peliculasSeries = peliculaSerieRepo.findAll();
		return peliculasSeries;
	}

	@Override
	public PeliculaSerie saveMovieSerie(PeliculaSerieDto peliculaDto) {
		PeliculaSerie peliculaSerie = new PeliculaSerieBuilder().withSerieDto(peliculaDto).build();
		return peliculaSerieRepo.save(peliculaSerie);
	}

	@Override
	public PeliculaSerie updateMovieSerie(Long id,PeliculaSerieDto peliculaSerieDto) {
		PeliculaSerie peliculaSerie = peliculaSerieRepo.findById(id).get();
		
		String titulo = peliculaSerieDto.getTitulo();
		String imagen = peliculaSerieDto.getImagen();
		Date fechaCreacion = peliculaSerieDto.getFechaCreacion();
		int calificacion = peliculaSerieDto.getCalificacion();	
		
		if(peliculaSerieDto.getPersonajes() != null) {
			List<Personaje> personajes = new ArrayList<Personaje>();
			for (Long idPelicula : peliculaSerieDto.getPersonajes()) {
				personajes.add(new Personaje(idPelicula));
			}
			peliculaSerie.setPersonajes(personajes);
		}
		
		if(peliculaSerieDto.getGeneros() != null) {
			List<Genero> generos = new ArrayList<Genero>();
			for (Long idGenero : peliculaSerieDto.getGeneros()) {
				generos.add(new Genero(idGenero));
			}
			peliculaSerie.setGeneros(generos);
		}	
		
		if(titulo != null)
			peliculaSerie.setTitulo(titulo);
		if(imagen != null)
			peliculaSerie.setImagen(imagen);
		if(fechaCreacion != null)
			peliculaSerie.setFechaCreacion(fechaCreacion);
		if(calificacion != 0)
			peliculaSerie.setCalificacion(calificacion);

		peliculaSerie = peliculaSerieRepo.save(peliculaSerie);
		
		return peliculaSerie;
	}

	@Override
	public List<PeliculaSerieDtoRes> findAllMovieSerieDtoRes() {
		List<PeliculaSerie> peliculasSeries = peliculaSerieRepo.findAll();
		List<PeliculaSerieDtoRes> peliculasSeriesDtoRes = new ArrayList<>();
		if(peliculasSeries != null)
			for (PeliculaSerie peliculaSerie : peliculasSeries) {
				peliculasSeriesDtoRes.add(new PeliculaSerieBuilder().withSerieDtoRes(peliculaSerie).buildRes());
			}
		return peliculasSeriesDtoRes;
	}

	@Override
	public PeliculaSerie deleteMovieSerie(Long id) {
		PeliculaSerie peliculaSerie = peliculaSerieRepo.findById(id).get();
		peliculaSerieRepo.deleteById(id);
		return peliculaSerie;
	}

	@Override
	public List<PeliculaSerie> findByTitulo(String titulo) {
		return peliculaSerieRepo.findByTitulo(titulo);
	}


}
