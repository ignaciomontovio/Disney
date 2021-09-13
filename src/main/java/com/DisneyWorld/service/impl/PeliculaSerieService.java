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
	
	public List<PeliculaSerie> findAllPeliculaSerie(){
		List<PeliculaSerie> peliculasSeries = peliculaSerieRepo.findAll();
		
		//List<PeliculaSerie> peliculasSeriesDto = new ArrayList<PeliculaSerieDto>();
		
		/*for (PeliculaSerie peliculaSerie : peliculasSeries) {
			//peliculasSeriesDto.add(new PeliculaSerieBuilder().withSerieDtoRes(peliculaSerie).buildRes());
			peliculaSerie.getPersonajes()
		}*/
		return peliculasSeries;
	}

	@Override
	public PeliculaSerie savePelicula(PeliculaSerieDto peliculaDto) {
		
		PeliculaSerie pelicula = new PeliculaSerieBuilder().withSerieDto(peliculaDto).build();
		//pelicula.setGeneros(generoRepo.findById(peliculaDto.getGenero()).get());
		
		return peliculaSerieRepo.save(pelicula);
	}

	@Override
	public PeliculaSerie updatePelicula(Integer id,PeliculaSerieDto peliculaSerieDto) {
		PeliculaSerie peliculaSerie = peliculaSerieRepo.getById(id);
		
		String titulo = peliculaSerieDto.getTitulo();
		String imagen = peliculaSerieDto.getImagen();
		Date fechaCreacion = peliculaSerieDto.getFechaCreacion();
		int calificacion = peliculaSerieDto.getCalificacion();
		
		
		if(peliculaSerieDto.getPersonajes() != null) {
			List<Personaje> personajes = new ArrayList<Personaje>();
			for (Integer idPelicula : peliculaSerieDto.getPersonajes()) {
				personajes.add(new Personaje(idPelicula));
			}
			peliculaSerie.setPersonajes(personajes);
		}
		
		if(peliculaSerieDto.getPersonajes() != null) {
			List<Genero> generos = new ArrayList<Genero>();
			for (Integer idGenero : peliculaSerieDto.getGeneros()) {
				generos.add(new Genero(idGenero));
			}
			peliculaSerie.setGeneros(generos);
		}	
		
		//List<Genero> generos = peliculaSerieDto.getGeneros();
		
		if(titulo != null)
			peliculaSerie.setTitulo(titulo);
		if(imagen != null)
			peliculaSerie.setImagen(imagen);
		if(fechaCreacion != null)
			peliculaSerie.setFechaCreacion(fechaCreacion);
		if(calificacion != 0)
			peliculaSerie.setCalificacion(calificacion);
		/*if(personajes != null)
			peliculaSerie.setPersonajes(personajes);
		if(generos != null)
			peliculaSerie.setGeneros(generos);*/
		
		peliculaSerie = peliculaSerieRepo.save(peliculaSerie);
		
		return peliculaSerie;
	}

	@Override
	public List<PeliculaSerieDtoRes> findAllPeliculaSerieDtoRes() {
		List<PeliculaSerie> peliculasSeries = peliculaSerieRepo.findAll();
		List<PeliculaSerieDtoRes> peliculasSeriesDtoRes = new ArrayList<>();
		if(peliculasSeries != null)
			for (PeliculaSerie peliculaSerie : peliculasSeries) {
				peliculasSeriesDtoRes.add(new PeliculaSerieBuilder().withSerieDtoRes(peliculaSerie).buildRes());
			}
		return peliculasSeriesDtoRes;
	}

	@Override
	public PeliculaSerie deletePelicula(Integer id) {
		PeliculaSerie pelicula = peliculaSerieRepo.getById(id);
		peliculaSerieRepo.deleteById(id);
		return pelicula;
	}

}
