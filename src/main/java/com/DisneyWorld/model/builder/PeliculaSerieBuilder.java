package com.DisneyWorld.model.builder;

import java.util.ArrayList;
import java.util.Date;
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
	private List<PersonajeDtoRes> personajes = new ArrayList<PersonajeDtoRes>();
	private List<GeneroDto> generos = new ArrayList<GeneroDto>();
	
	
	public PeliculaSerieBuilder withSerieDto(PeliculaSerieDto peliculaDto) {
		this.titulo = peliculaDto.getTitulo();
		this.imagen = peliculaDto.getImagen();
		this.fechaCreacion = peliculaDto.getFechaCreacion();
//		this.calificacion = peliculaDto.getCalificacion();
		return this;
	}
	public PeliculaSerieBuilder withSerieDtoRes(PeliculaSerie peliculaSerie) {
		this.titulo = peliculaSerie.getTitulo();
		this.imagen = peliculaSerie.getImagen();
		this.fechaCreacion = peliculaSerie.getFechaCreacion();
//		this.calificacion = peliculaSerie.getCalificacion();
//		if(peliculaSerie.getPersonajes() != null)
//			for (Personaje personaje : peliculaSerie.getPersonajes()) {
//				personajes.add(new PersonajeBuilder().withPersonajeDtoRes(personaje).buildRes());
//				
//			}
//			
//		if(peliculaSerie.getGeneros() != null)
//			for (Genero genero : peliculaSerie.getGeneros()) {
//				generos.add(new GeneroBuilder().withGeneroDtoRes(genero).buildRes());
//			}
		return this;
	}
	
	public PeliculaSerie build() {
		return new PeliculaSerie(this.titulo,this.imagen,this.fechaCreacion,this.calificacion);
	}
	public PeliculaSerieDtoRes buildRes() {
		return new PeliculaSerieDtoRes(this.titulo,this.imagen,this.fechaCreacion);
	}
	
}
