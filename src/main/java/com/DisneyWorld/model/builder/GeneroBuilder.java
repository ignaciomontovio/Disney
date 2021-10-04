package com.DisneyWorld.model.builder;

import java.util.ArrayList;
import java.util.List;

import com.DisneyWorld.dto.GeneroDto;
import com.DisneyWorld.model.Genero;
import com.DisneyWorld.model.PeliculaSerie;

public class GeneroBuilder {

	private String nombre;
	private String imagen;
	private List<PeliculaSerie> pelicula = new ArrayList<PeliculaSerie>();
	
	public GeneroBuilder withGeneroDto(GeneroDto generoDto) {
		this.nombre = generoDto.getNombre();
		this.imagen = generoDto.getImagen();
		if(generoDto.getPeliculas() != null)
			for (Long idPelicula : generoDto.getPeliculas()) {
				pelicula.add(new PeliculaSerie(idPelicula));
			}

		return this;
	}
	public GeneroBuilder withGeneroDtoRes(Genero genero) {
		this.nombre = genero.getNombre();
		this.imagen = genero.getImagen();
		return this;
	}
	
	public Genero build() {
		return new Genero(this.nombre,this.imagen,this.pelicula);
	}
	public GeneroDto buildRes() {
		return new GeneroDto(this.nombre,this.imagen);
	}
}
