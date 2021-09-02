package com.DisneyWorld.model.builder;

import java.util.Date;

import com.DisneyWorld.dto.SerieDto;
import com.DisneyWorld.model.Serie;

public class SerieBuilder {

	private String imagen;
	private String titulo;
	private Date fechaCreacion;
	private int calificacion;
	
	public SerieBuilder withSerieDto(SerieDto serieDto) {
		this.titulo = serieDto.getTitulo();
		this.imagen = serieDto.getImagen();
		this.fechaCreacion = serieDto.getFechaCreacion();
		this.calificacion = serieDto.getCalificacion();
		return this;
	}
	
	public Serie build() {
		return new Serie(this.titulo,this.imagen,this.fechaCreacion,this.calificacion);
	}
}
