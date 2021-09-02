package com.DisneyWorld.model.builder;

import java.util.Date;

import com.DisneyWorld.dto.PeliculaDto;
import com.DisneyWorld.model.Pelicula;

public class PeliculaBuilder {

	private String titulo;
	private String imagen;
	private Date fechaCreacion;
	private int calificacion;
	
	public PeliculaBuilder withSerieDto(PeliculaDto serieDto) {
		this.titulo = serieDto.getTitulo();
		this.imagen = serieDto.getImagen();
		this.fechaCreacion = serieDto.getFechaCreacion();
		this.calificacion = serieDto.getCalificacion();
		return this;
	}
	
	public Pelicula build() {
		return new Pelicula(this.titulo,this.imagen,this.fechaCreacion,this.calificacion);
	}
	
}
