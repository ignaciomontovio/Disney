package com.DisneyWorld.model.builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.DisneyWorld.dto.GeneroDto;
import com.DisneyWorld.dto.PeliculaSerieDto;
import com.DisneyWorld.dto.PeliculaSerieDtoRes;
import com.DisneyWorld.dto.PersonajeDtoRes;
import com.DisneyWorld.model.Genero;
import com.DisneyWorld.model.PeliculaSerie;
import com.DisneyWorld.model.Personaje;

public class PeliculaSerieBuilder {

	private String titulo;
	private String imagen;
	private Date fechaCreacion;
	private int calificacion;
	
	private List<Personaje> personajes = new ArrayList<Personaje>();
	private List<Genero> generos = new ArrayList<Genero>();
	
	
	public PeliculaSerieBuilder withSerieDto(PeliculaSerieDto peliculaDto) {
		this.titulo = peliculaDto.getTitulo();
		this.imagen = peliculaDto.getImagen();
		this.fechaCreacion = peliculaDto.getFechaCreacion();
		this.calificacion = peliculaDto.getCalificacion();
		
		if(peliculaDto.getPersonajes() != null) {
			for (Integer idPersonaje : peliculaDto.getPersonajes()) {
				personajes.add(new Personaje(idPersonaje));
			}
		}
		
		if(peliculaDto.getGeneros() != null) {
			for (Integer idGenero : peliculaDto.getGeneros()) {
				generos.add(new Genero(idGenero));
			}
		}
		
		return this;
	}
	
	public PeliculaSerieBuilder withSerieDtoRes(PeliculaSerie peliculaSerie) {
		this.titulo = peliculaSerie.getTitulo();
		this.imagen = peliculaSerie.getImagen();
		this.fechaCreacion = peliculaSerie.getFechaCreacion();
		return this;
	}
	
	public PeliculaSerie build() {
		return new PeliculaSerie(this.titulo,this.imagen,this.fechaCreacion,this.calificacion,this.personajes,this.generos);
	}
	public PeliculaSerieDtoRes buildRes() {
		return new PeliculaSerieDtoRes(this.titulo,this.imagen,this.fechaCreacion);
	}
	
}
